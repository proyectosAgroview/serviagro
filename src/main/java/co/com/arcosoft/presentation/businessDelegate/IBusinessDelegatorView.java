package co.com.arcosoft.presentation.businessDelegate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.*;
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
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 *
 */
public interface IBusinessDelegatorView {

	public List<AreaTrabajo> getAreaTrabajo() throws Exception;

	public void saveAreaTrabajo(AreaTrabajo entity) throws Exception;

	public void deleteAreaTrabajo(AreaTrabajo entity) throws Exception;

	public void updateAreaTrabajo(AreaTrabajo entity) throws Exception;

	public AreaTrabajo getAreaTrabajo(Long areaTrabajoId) throws Exception;

	public List<AreaTrabajo> findByCriteriaInAreaTrabajo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AreaTrabajo> findPageAreaTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAreaTrabajo() throws Exception;

	public List<AreaTrabajoDTO> getDataAreaTrabajo() throws Exception;

	public List<DatSolicitudesMtto> getDatSolicitudesMtto() throws Exception;

	public void saveDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception;

	public void deleteDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception;

	public void updateDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception;

	public DatSolicitudesMtto getDatSolicitudesMtto(Long datSolicitudesMttoId) throws Exception;

	public List<DatSolicitudesMtto> findByCriteriaInDatSolicitudesMtto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatSolicitudesMtto> findPageDatSolicitudesMtto(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatSolicitudesMtto() throws Exception;

	public List<DatSolicitudesMttoDTO> getDataDatSolicitudesMtto() throws Exception;

	public List<NivelPrioridad> getNivelPrioridad() throws Exception;

	public void saveNivelPrioridad(NivelPrioridad entity) throws Exception;

	public void deleteNivelPrioridad(NivelPrioridad entity) throws Exception;

	public void updateNivelPrioridad(NivelPrioridad entity) throws Exception;

	public NivelPrioridad getNivelPrioridad(Long nivelPrioridadId) throws Exception;

	public List<NivelPrioridad> findByCriteriaInNivelPrioridad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<NivelPrioridad> findPageNivelPrioridad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivelPrioridad() throws Exception;

	public List<NivelPrioridadDTO> getDataNivelPrioridad() throws Exception;

	public List<Almacen> getAlmacen() throws Exception;

	public void saveAlmacen(Almacen entity) throws Exception;

	public void deleteAlmacen(Almacen entity) throws Exception;

	public void updateAlmacen(Almacen entity) throws Exception;

	public Almacen getAlmacen(Long almacenId) throws Exception;

	public List<Almacen> findByCriteriaInAlmacen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Almacen> findPageAlmacen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberAlmacen() throws Exception;

	public List<AlmacenDTO> getDataAlmacen(Long companiUserId) throws Exception;

	public List<AnaCultivo> getAnaCultivo() throws Exception;

	public void saveAnaCultivo(AnaCultivo entity) throws Exception;

	public void deleteAnaCultivo(AnaCultivo entity) throws Exception;

	public void updateAnaCultivo(AnaCultivo entity) throws Exception;

	public AnaCultivo getAnaCultivo(Long anaCultId) throws Exception;

	public List<AnaCultivo> findByCriteriaInAnaCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnaCultivo> findPageAnaCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnaCultivo() throws Exception;

	public List<AnaCultivoDTO> getDataAnaCultivo() throws Exception;

	public List<CategoriaEquipo> getCategoriaEquipo() throws Exception;

	public void saveCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	public void deleteCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	public void updateCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	public CategoriaEquipo getCategoriaEquipo(Long categEquipId) throws Exception;

	public List<CategoriaEquipo> findByCriteriaInCategoriaEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CategoriaEquipo> findPageCategoriaEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCategoriaEquipo() throws Exception;

	public List<CategoriaEquipoDTO> getDataCategoriaEquipo() throws Exception;

	public List<Ciudad> getCiudad() throws Exception;

	public void saveCiudad(Ciudad entity) throws Exception;

	public void deleteCiudad(Ciudad entity) throws Exception;

	public void updateCiudad(Ciudad entity) throws Exception;

	public Ciudad getCiudad(Long ciudadId) throws Exception;

	public List<Ciudad> findByCriteriaInCiudad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Ciudad> findPageCiudad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCiudad() throws Exception;

	public List<CiudadDTO> getDataCiudad() throws Exception;

	public List<ClaseToxicologica> getClaseToxicologica() throws Exception;

	public void saveClaseToxicologica(ClaseToxicologica entity) throws Exception;

	public void deleteClaseToxicologica(ClaseToxicologica entity) throws Exception;

	public void updateClaseToxicologica(ClaseToxicologica entity) throws Exception;

	public ClaseToxicologica getClaseToxicologica(Long claseToxicId) throws Exception;

	public List<ClaseToxicologica> findByCriteriaInClaseToxicologica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ClaseToxicologica> findPageClaseToxicologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberClaseToxicologica() throws Exception;

	public List<ClaseToxicologicaDTO> getDataClaseToxicologica() throws Exception;

	public List<ConceptoNomina> getConceptoNomina() throws Exception;

	public void saveConceptoNomina(ConceptoNomina entity) throws Exception;

	public void deleteConceptoNomina(ConceptoNomina entity) throws Exception;

	public void updateConceptoNomina(ConceptoNomina entity) throws Exception;

	public ConceptoNomina getConceptoNomina(Long ceptoNominaId) throws Exception;

	public List<ConceptoNomina> findByCriteriaInConceptoNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConceptoNomina> findPageConceptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberConceptoNomina() throws Exception;

	public List<ConceptoNominaDTO> getDataConceptoNomina() throws Exception;

	public List<Conductor> getConductor() throws Exception;

	public void saveConductor(Conductor entity) throws Exception;

	public void deleteConductor(Conductor entity) throws Exception;

	public void updateConductor(Conductor entity) throws Exception;

	public Conductor getConductor(Long conductorId) throws Exception;

	public List<Conductor> findByCriteriaInConductor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Conductor> findPageConductor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConductor() throws Exception;

	public List<ConductorDTO> getDataConductor() throws Exception;

	public List<CostoRecurso> getCostoRecurso() throws Exception;

	public void saveCostoRecurso(CostoRecurso entity) throws Exception;

	public void deleteCostoRecurso(CostoRecurso entity) throws Exception;

	public void updateCostoRecurso(CostoRecurso entity) throws Exception;

	public CostoRecurso getCostoRecurso(CostoRecursoId id) throws Exception;

	public List<CostoRecurso> findByCriteriaInCostoRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CostoRecurso> findPageCostoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCostoRecurso() throws Exception;

	public List<CostoRecursoDTO> getDataCostoRecurso() throws Exception;

	public List<CuentaContable> getCuentaContable() throws Exception;

	public void saveCuentaContable(CuentaContable entity) throws Exception;

	public void deleteCuentaContable(CuentaContable entity) throws Exception;

	public void updateCuentaContable(CuentaContable entity) throws Exception;

	public CuentaContable getCuentaContable(Long ccontableId) throws Exception;

	public List<CuentaContable> findByCriteriaInCuentaContable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CuentaContable> findPageCuentaContable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCuentaContable() throws Exception;

	public List<CuentaContableDTO> getDataCuentaContable() throws Exception;

	public List<DatAplicProdDet> getDatAplicProdDet() throws Exception;

	public void saveDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	public void deleteDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	public void updateDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	/***/
	public DatAplicProdDet getDatAplicProdDet(Long datProdDetId) throws Exception;

	/**/
	public List<DatAplicProdDet> findByCriteriaInDatAplicProdDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAplicProdDet> findPageDatAplicProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAplicProdDet() throws Exception;

	public List<DatAplicProdDetDTO> getDataDatAplicProdDet() throws Exception;

	public List<DatAplicProducto> getDatAplicProducto() throws Exception;

	public void deleteDatAplicProducto(DatAplicProducto entity) throws Exception;

	public DatAplicProducto getDatAplicProducto(Long datAplicProdId) throws Exception;

	public List<DatAplicProducto> findByCriteriaInDatAplicProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAplicProducto> findPageDatAplicProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAplicProducto() throws Exception;

	public List<DatAplicProductoDTO> getDataDatAplicProducto() throws Exception;

	public List<DatEstimCosecha> getDatEstimCosecha() throws Exception;

	public void saveDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	public void deleteDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	public void updateDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	public DatEstimCosecha getDatEstimCosecha(Long datEstimCosechaId) throws Exception;

	public List<DatEstimCosecha> findByCriteriaInDatEstimCosecha(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatEstimCosecha> findPageDatEstimCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatEstimCosecha() throws Exception;

	public List<DatEstimCosechaDTO> getDataDatEstimCosecha() throws Exception;

	public List<DatPlanillaNomina> getDatPlanillaNomina() throws Exception;

	public void saveDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataServicioDet, List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception;

	public void deleteDatPlanillaNomina(DatPlanillaNomina entity) throws Exception;

	public void updateDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataServicioDet, List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception;

	public DatPlanillaNomina getDatPlanillaNomina(Long planillaNominaId) throws Exception;

	public List<DatPlanillaNomina> findByCriteriaInDatPlanillaNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanillaNomina> findPageDatPlanillaNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanillaNomina() throws Exception;

	public List<DatPlanillaNominaDTO> getDataDatPlanillaNomina() throws Exception;

	public List<DatPlanLabor> getDatPlanLabor() throws Exception;

	public void saveDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception;

	public void deleteDatPlanLabor(DatPlanLabor entity) throws Exception;

	public void updateDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception;

	public DatPlanLabor getDatPlanLabor(Long planLaborId) throws Exception;

	public List<DatPlanLabor> findByCriteriaInDatPlanLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanLabor> findPageDatPlanLabor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanLabor() throws Exception;

	public List<DatPlanLaborDTO> getDataDatPlanLabor() throws Exception;

	public List<DatRiego> getDatRiego() throws Exception;

	public void saveDatRiego(DatRiego entity) throws Exception;

	public void deleteDatRiego(DatRiego entity) throws Exception;

	public void updateDatRiego(DatRiego entity) throws Exception;

	public DatRiego getDatRiego(Long datRiegoId) throws Exception;

	public List<DatRiego> findByCriteriaInDatRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatRiego> findPageDatRiego(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatRiego() throws Exception;

	public List<DatRiegoDTO> getDataDatRiego() throws Exception;

	public List<DatServicio> getDatServicio() throws Exception;

	public void saveDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception;

	public void deleteDatServicio(DatServicio entity) throws Exception;

	public void updateDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception;

	public DatServicio getDatServicio(Long datServicioId) throws Exception;

	public List<DatServicio> findByCriteriaInDatServicio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatServicio> findPageDatServicio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatServicio() throws Exception;

	public List<DatServicioDTO> getDataDatServicio() throws Exception;

	public List<DatTransProd> getDatTransProd() throws Exception;

	public void deleteDatTransProd(DatTransProd entity) throws Exception;

	public DatTransProd getDatTransProd(Long datTransProdId) throws Exception;

	public List<DatTransProd> findByCriteriaInDatTransProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProd> findPageDatTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatTransProd() throws Exception;

	public List<DatTransProdDTO> getDataDatTransProd() throws Exception;

	public List<DatTransProdDet> getDatTransProdDet() throws Exception;

	public void saveDatTransProdDet(DatTransProdDet entity) throws Exception;

	public void deleteDatTransProdDet(DatTransProdDet entity) throws Exception;

	public void updateDatTransProdDet(DatTransProdDet entity) throws Exception;

	public DatTransProdDet getDatTransProdDet(Long datTransProdDetId) throws Exception;

	public List<DatTransProdDet> findByCriteriaInDatTransProdDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdDet> findPageDatTransProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdDet() throws Exception;

	public List<DatTransProdDetDTO> getDataDatTransProdDet() throws Exception;

	public List<ElementoCosto> getElementoCosto() throws Exception;

	public void saveElementoCosto(ElementoCosto entity) throws Exception;

	public void deleteElementoCosto(ElementoCosto entity) throws Exception;

	public void updateElementoCosto(ElementoCosto entity) throws Exception;

	public ElementoCosto getElementoCosto(Long elemCostoId) throws Exception;

	public List<ElementoCosto> findByCriteriaInElementoCosto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ElementoCosto> findPageElementoCosto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberElementoCosto() throws Exception;

	public List<ElementoCostoDTO> getDataElementoCosto() throws Exception;

	public List<Empaque> getEmpaque() throws Exception;

	public void saveEmpaque(Empaque entity) throws Exception;

	public void deleteEmpaque(Empaque entity) throws Exception;

	public void updateEmpaque(Empaque entity) throws Exception;

	public Empaque getEmpaque(Long empaqueId) throws Exception;

	public List<Empaque> findByCriteriaInEmpaque(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Empaque> findPageEmpaque(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEmpaque() throws Exception;

	public List<EmpaqueDTO> getDataEmpaque() throws Exception;

	public List<EmpaqueProducto> getEmpaqueProducto() throws Exception;

	public void saveEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	public void deleteEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	public void updateEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	public EmpaqueProducto getEmpaqueProducto(EmpaqueProductoId id) throws Exception;

	public List<EmpaqueProducto> findByCriteriaInEmpaqueProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EmpaqueProducto> findPageEmpaqueProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEmpaqueProducto() throws Exception;

	public List<EmpaqueProductoDTO> getDataEmpaqueProducto() throws Exception;

	public List<Equipo> getEquipo() throws Exception;

	public void deleteEquipo(Equipo entity) throws Exception;

	public Equipo getEquipo(Long equipoId) throws Exception;

	public List<Equipo> findByCriteriaInEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Equipo> findPageEquipo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEquipo() throws Exception;

	public List<EquipoDTO> getDataEquipo() throws Exception;

	public List<Estado> getEstado() throws Exception;

	public void saveEstado(Estado entity) throws Exception;

	public void deleteEstado(Estado entity) throws Exception;

	public void updateEstado(Estado entity) throws Exception;

	public Estado getEstado(Long estadoId) throws Exception;

	public List<Estado> findByCriteriaInEstado(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Estado> findPageEstado(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstado() throws Exception;

	public List<EstadoDTO> getDataEstado() throws Exception;

	public List<FabricanteEquipo> getFabricanteEquipo() throws Exception;

	public void saveFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	public void deleteFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	public void updateFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	public FabricanteEquipo getFabricanteEquipo(Long fabricEquipId) throws Exception;

	public List<FabricanteEquipo> findByCriteriaInFabricanteEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FabricanteEquipo> findPageFabricanteEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFabricanteEquipo() throws Exception;

	public List<FabricanteEquipoDTO> getDataFabricanteEquipo() throws Exception;

	public List<FactorConversion> getFactorConversion() throws Exception;

	public void saveFactorConversion(FactorConversion entity) throws Exception;

	public void deleteFactorConversion(FactorConversion entity) throws Exception;

	public void updateFactorConversion(FactorConversion entity) throws Exception;

	public FactorConversion getFactorConversion(Long factorConversionId) throws Exception;

	public List<FactorConversion> findByCriteriaInFactorConversion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FactorConversion> findPageFactorConversion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFactorConversion() throws Exception;

	public List<FactorConversionDTO> getDataFactorConversion() throws Exception;

	public List<FlotaTransporte> getFlotaTransporte() throws Exception;

	public void saveFlotaTransporte(FlotaTransporte entity) throws Exception;

	public void deleteFlotaTransporte(FlotaTransporte entity) throws Exception;

	public void updateFlotaTransporte(FlotaTransporte entity) throws Exception;

	public FlotaTransporte getFlotaTransporte(Long flotaTranspId) throws Exception;

	public List<FlotaTransporte> findByCriteriaInFlotaTransporte(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FlotaTransporte> findPageFlotaTransporte(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFlotaTransporte() throws Exception;

	public List<FlotaTransporteDTO> getDataFlotaTransporte() throws Exception;

	public List<GrpLabor> getGrpLabor() throws Exception;

	public void saveGrpLabor(GrpLabor entity) throws Exception;

	public void deleteGrpLabor(GrpLabor entity) throws Exception;

	public void updateGrpLabor(GrpLabor entity) throws Exception;

	public GrpLabor getGrpLabor(Long grpLaborId) throws Exception;

	public List<GrpLabor> findByCriteriaInGrpLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GrpLabor> findPageGrpLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpLabor() throws Exception;

	public List<GrpLaborDTO> getDataGrpLabor() throws Exception;

	public List<Labor> getLabor() throws Exception;

	public void saveLabor(Labor entity) throws Exception;

	public void deleteLabor(Labor entity) throws Exception;

	public void updateLabor(Labor entity) throws Exception;

	public Labor getLabor(Long laborId) throws Exception;

	public List<Labor> findByCriteriaInLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Labor> findPageLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLabor() throws Exception;

	public List<LaborDTO> getDataLabor() throws Exception;

	public List<LimiteCeptoNomina> getLimiteCeptoNomina() throws Exception;

	public void saveLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	public void deleteLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	public void updateLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	public LimiteCeptoNomina getLimiteCeptoNomina(LimiteCeptoNominaId id) throws Exception;

	public List<LimiteCeptoNomina> findByCriteriaInLimiteCeptoNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LimiteCeptoNomina> findPageLimiteCeptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLimiteCeptoNomina() throws Exception;

	public List<LimiteCeptoNominaDTO> getDataLimiteCeptoNomina() throws Exception;

	public List<Medidor> getMedidor() throws Exception;

	public void saveMedidor(Medidor entity) throws Exception;

	public void deleteMedidor(Medidor entity) throws Exception;

	public void updateMedidor(Medidor entity) throws Exception;

	public Medidor getMedidor(Long medidorId) throws Exception;

	public List<Medidor> findByCriteriaInMedidor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Medidor> findPageMedidor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMedidor() throws Exception;

	public List<MedidorDTO> getDataMedidor() throws Exception;

	public List<ModalidadCosecha> getModalidadCosecha() throws Exception;

	public void saveModalidadCosecha(ModalidadCosecha entity) throws Exception;

	public void deleteModalidadCosecha(ModalidadCosecha entity) throws Exception;

	public void updateModalidadCosecha(ModalidadCosecha entity) throws Exception;

	public ModalidadCosecha getModalidadCosecha(Long modalidadCosId) throws Exception;

	public List<ModalidadCosecha> findByCriteriaInModalidadCosecha(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ModalidadCosecha> findPageModalidadCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberModalidadCosecha() throws Exception;

	public List<ModalidadCosechaDTO> getDataModalidadCosecha() throws Exception;

	public List<ModeloEquipo> getModeloEquipo() throws Exception;

	public void saveModeloEquipo(ModeloEquipo entity) throws Exception;

	public void deleteModeloEquipo(ModeloEquipo entity) throws Exception;

	public void updateModeloEquipo(ModeloEquipo entity) throws Exception;

	public ModeloEquipo getModeloEquipo(Long modeloEquipoId) throws Exception;

	public List<ModeloEquipo> findByCriteriaInModeloEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ModeloEquipo> findPageModeloEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberModeloEquipo() throws Exception;

	public List<ModeloEquipoDTO> getDataModeloEquipo() throws Exception;

	public List<MotivoCierreOt> getMotivoCierreOt() throws Exception;

	public void saveMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	public void deleteMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	public void updateMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	public MotivoCierreOt getMotivoCierreOt(Long motCierreOtId) throws Exception;

	public List<MotivoCierreOt> findByCriteriaInMotivoCierreOt(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MotivoCierreOt> findPageMotivoCierreOt(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMotivoCierreOt() throws Exception;

	public List<MotivoCierreOtDTO> getDataMotivoCierreOt() throws Exception;

	public List<NumeroEje> getNumeroEje() throws Exception;

	public void saveNumeroEje(NumeroEje entity) throws Exception;

	public void deleteNumeroEje(NumeroEje entity) throws Exception;

	public void updateNumeroEje(NumeroEje entity) throws Exception;

	public NumeroEje getNumeroEje(Long numEjeId) throws Exception;

	public List<NumeroEje> findByCriteriaInNumeroEje(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<NumeroEje> findPageNumeroEje(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNumeroEje() throws Exception;

	public List<NumeroEjeDTO> getDataNumeroEje() throws Exception;

	public List<Pais> getPais() throws Exception;

	public void savePais(Pais entity) throws Exception;

	public void deletePais(Pais entity) throws Exception;

	public void updatePais(Pais entity) throws Exception;

	public Pais getPais(Long paisId) throws Exception;

	public List<Pais> findByCriteriaInPais(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Pais> findPagePais(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPais() throws Exception;

	public List<PaisDTO> getDataPais() throws Exception;

	public List<PlanAsignarRecurso> getPlanAsignarRecurso() throws Exception;

	public void savePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	public void deletePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	public void updatePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	public PlanAsignarRecurso getPlanAsignarRecurso(PlanAsignarRecursoId id) throws Exception;

	public List<PlanAsignarRecurso> findByCriteriaInPlanAsignarRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanAsignarRecurso> findPagePlanAsignarRecurso(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanAsignarRecurso() throws Exception;

	public List<PlanAsignarRecursoDTO> getDataPlanAsignarRecurso() throws Exception;

	public List<PrecioPromProd> getPrecioPromProd() throws Exception;

	public void savePrecioPromProd(PrecioPromProd entity) throws Exception;

	public void deletePrecioPromProd(PrecioPromProd entity) throws Exception;

	public void updatePrecioPromProd(PrecioPromProd entity) throws Exception;

	public PrecioPromProd getPrecioPromProd(PrecioPromProdId id) throws Exception;

	public List<PrecioPromProd> findByCriteriaInPrecioPromProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PrecioPromProd> findPagePrecioPromProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPrecioPromProd() throws Exception;

	public List<PrecioPromProdDTO> getDataPrecioPromProd(Double cantidadCompra) throws Exception;

	public List<Producto> getProducto() throws Exception;

	public void saveProducto(Producto entity) throws Exception;

	public void deleteProducto(Producto entity) throws Exception;

	public void updateProducto(Producto entity) throws Exception;

	public Producto getProducto(Long productoId) throws Exception;

	public List<Producto> findByCriteriaInProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Producto> findPageProducto(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProducto() throws Exception;

	public List<ProductoDTO> getDataProducto() throws Exception;

	/*
	 * public List<Recurso> getRecurso() throws Exception;
	 * 
	 * public void saveRecurso(Recurso entity) throws Exception;
	 * 
	 * public void deleteRecurso(Recurso entity) throws Exception;
	 * 
	 * public void updateRecurso(Recurso entity) throws Exception;
	 * 
	 * public Recurso getRecurso(Long recursoId) throws Exception;
	 * 
	 * public List<Recurso> findByCriteriaInRecurso(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception;
	 * 
	 * public List<Recurso> findPageRecurso(String sortColumnName, boolean
	 * sortAscending, int startRow, int maxResults) throws Exception;
	 * 
	 * public Long findTotalNumberRecurso() throws Exception;
	 * 
	 * public List<RecursoDTO> getDataRecurso() throws Exception;
	 */
	public List<Servicio> getServicio() throws Exception;

	public void saveServicio(Servicio entity) throws Exception;

	public void deleteServicio(Servicio entity) throws Exception;

	public void updateServicio(Servicio entity) throws Exception;

	public Servicio getServicio(Long servicioId) throws Exception;

	public List<Servicio> findByCriteriaInServicio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Servicio> findPageServicio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberServicio() throws Exception;

	public List<ServicioDTO> getDataServicio() throws Exception;

	public List<SistemaRiego> getSistemaRiego() throws Exception;

	public void saveSistemaRiego(SistemaRiego entity) throws Exception;

	public void deleteSistemaRiego(SistemaRiego entity) throws Exception;

	public void updateSistemaRiego(SistemaRiego entity) throws Exception;

	public SistemaRiego getSistemaRiego(Long sistemaRiegoId) throws Exception;

	public List<SistemaRiego> findByCriteriaInSistemaRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SistemaRiego> findPageSistemaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSistemaRiego() throws Exception;

	public List<SistemaRiegoDTO> getDataSistemaRiego() throws Exception;

	public List<TipoCliente> getTipoCliente() throws Exception;

	public void saveTipoCliente(TipoCliente entity) throws Exception;

	public void deleteTipoCliente(TipoCliente entity) throws Exception;

	public void updateTipoCliente(TipoCliente entity) throws Exception;

	public TipoCliente getTipoCliente(Long tipoClienteId) throws Exception;

	public List<TipoCliente> findByCriteriaInTipoCliente(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoCliente> findPageTipoCliente(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoCliente() throws Exception;

	public List<TipoClienteDTO> getDataTipoCliente() throws Exception;

	public List<TipoInfraestructura> getTipoInfraestructura() throws Exception;

	public void saveTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	public void deleteTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	public void updateTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	public TipoInfraestructura getTipoInfraestructura(Long tipoInfraId) throws Exception;

	public List<TipoInfraestructura> findByCriteriaInTipoInfraestructura(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoInfraestructura> findPageTipoInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoInfraestructura() throws Exception;

	public List<TipoInfraestructuraDTO> getDataTipoInfraestructura() throws Exception;

	public List<Infraestructura> getInfraestructura() throws Exception;

	public void saveInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception;

	public void deleteInfraestructura(Infraestructura entity) throws Exception;

	public void updateInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception;

	public Infraestructura getInfraestructura(Long infraId) throws Exception;

	public List<Infraestructura> findByCriteriaInInfraestructura(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Infraestructura> findPageInfraestructura(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberInfraestructura() throws Exception;

	public List<InfraestructuraDTO> getDataInfraestructura() throws Exception;

	public List<TipoProducto> getTipoProducto() throws Exception;

	public void saveTipoProducto(TipoProducto entity) throws Exception;

	public void deleteTipoProducto(TipoProducto entity) throws Exception;

	public void updateTipoProducto(TipoProducto entity) throws Exception;

	public TipoProducto getTipoProducto(Long tipoProdId) throws Exception;

	public List<TipoProducto> findByCriteriaInTipoProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoProducto> findPageTipoProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoProducto() throws Exception;

	public List<TipoProductoDTO> getDataTipoProducto() throws Exception;

	public List<TipoRecurso> getTipoRecurso() throws Exception;

	public void saveTipoRecurso(TipoRecurso entity,

			List<TipoRecursosProfesionDTO> dataTRProfesion, List<TipoRecursosEquiposDTO> dataTREquipos,
			List<TipoRecursosInsumosDTO> dataTRInsumos, List<TipoRecursosOtrosDTO> dataTROtros) throws Exception;

	public void deleteTipoRecurso(TipoRecurso entity) throws Exception;

	public void updateTipoRecurso(TipoRecurso entity,

			List<TipoRecursosProfesionDTO> dataTRProfesion, List<TipoRecursosEquiposDTO> dataTREquipos,
			List<TipoRecursosInsumosDTO> dataTRInsumos, List<TipoRecursosOtrosDTO> dataTROtros) throws Exception;

	public TipoRecurso getTipoRecurso(Long tpRecursoId) throws Exception;

	public List<TipoRecurso> findByCriteriaInTipoRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecurso> findPageTipoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoRecurso() throws Exception;

	public List<TipoRecursoDTO> getDataTipoRecurso() throws Exception;

	public List<Transportadora> getTransportadora() throws Exception;

	public void saveTransportadora(Transportadora entity) throws Exception;

	public void deleteTransportadora(Transportadora entity) throws Exception;

	public void updateTransportadora(Transportadora entity) throws Exception;

	public Transportadora getTransportadora(Long transpId) throws Exception;

	public List<Transportadora> findByCriteriaInTransportadora(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Transportadora> findPageTransportadora(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTransportadora() throws Exception;

	public List<TransportadoraDTO> getDataTransportadora() throws Exception;

	public List<TurnoCampo> getTurnoCampo() throws Exception;

	public void saveTurnoCampo(TurnoCampo entity) throws Exception;

	public void deleteTurnoCampo(TurnoCampo entity) throws Exception;

	public void updateTurnoCampo(TurnoCampo entity) throws Exception;

	public TurnoCampo getTurnoCampo(Long turnoCampoId) throws Exception;

	public List<TurnoCampo> findByCriteriaInTurnoCampo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TurnoCampo> findPageTurnoCampo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTurnoCampo() throws Exception;

	public List<TurnoCampoDTO> getDataTurnoCampo() throws Exception;

	public List<VehiculosTransp> getVehiculosTransp() throws Exception;

	public void saveVehiculosTransp(VehiculosTransp entity) throws Exception;

	public void deleteVehiculosTransp(VehiculosTransp entity) throws Exception;

	public void updateVehiculosTransp(VehiculosTransp entity) throws Exception;

	public VehiculosTransp getVehiculosTransp(Long vehiTranspId) throws Exception;

	public List<VehiculosTransp> findByCriteriaInVehiculosTransp(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<VehiculosTransp> findPageVehiculosTransp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberVehiculosTransp() throws Exception;

	public List<VehiculosTranspDTO> getDataVehiculosTransp() throws Exception;

	public List<AnaSanVeg> getAnaSanVeg() throws Exception;

	public void saveAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception;

	public void deleteAnaSanVeg(AnaSanVeg entity) throws Exception;

	public void updateAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception;

	public AnaSanVeg getAnaSanVeg(Long anaSanVegId) throws Exception;

	public List<AnaSanVeg> findByCriteriaInAnaSanVeg(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnaSanVeg> findPageAnaSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberAnaSanVeg() throws Exception;

	public List<AnaSanVegDTO> getDataAnaSanVeg() throws Exception;

	public List<AnioFiscal> getAnioFiscal() throws Exception;

	public void saveAnioFiscal(AnioFiscal entity) throws Exception;

	public void deleteAnioFiscal(AnioFiscal entity) throws Exception;

	public void updateAnioFiscal(AnioFiscal entity) throws Exception;

	public AnioFiscal getAnioFiscal(Long anioFiscalId) throws Exception;

	public List<AnioFiscal> findByCriteriaInAnioFiscal(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnioFiscal> findPageAnioFiscal(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnioFiscal() throws Exception;

	public List<AnioFiscalDTO> getDataAnioFiscal() throws Exception;

	public List<Calendario> getCalendario() throws Exception;

	public void saveCalendario(Calendario entity) throws Exception;

	public void deleteCalendario(Calendario entity) throws Exception;

	public void updateCalendario(Calendario entity) throws Exception;

	public Calendario getCalendario(Long calendarId) throws Exception;

	public List<Calendario> findByCriteriaInCalendario(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Calendario> findPageCalendario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCalendario() throws Exception;

	public List<CalendarioDTO> getDataCalendario() throws Exception;

	public List<CentCost> getCentCost() throws Exception;

	public void saveCentCost(CentCost entity) throws Exception;

	public void deleteCentCost(CentCost entity) throws Exception;

	public void updateCentCost(CentCost entity) throws Exception;

	public CentCost getCentCost(Long centCostId) throws Exception;

	public List<CentCost> findByCriteriaInCentCost(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CentCost> findPageCentCost(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCentCost() throws Exception;

	public List<CentCostDTO> getDataCentCost() throws Exception;

//	public List<ClaseTextSuelo> getClaseTextSuelo() throws Exception;
//
//	public void saveClaseTextSuelo(ClaseTextSuelo entity) throws Exception;
//
//	public void deleteClaseTextSuelo(ClaseTextSuelo entity) throws Exception;
//
//	public void updateClaseTextSuelo(ClaseTextSuelo entity) throws Exception;
//
//	public ClaseTextSuelo getClaseTextSuelo(Long claseTextSueloId) throws Exception;
//
//	public List<ClaseTextSuelo> findByCriteriaInClaseTextSuelo(Object[] variables, Object[] variablesBetween,
//			Object[] variablesBetweenDates) throws Exception;
//
//	public List<ClaseTextSuelo> findPageClaseTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
//			int maxResults) throws Exception;
//
//	public Long findTotalNumberClaseTextSuelo() throws Exception;
//
//	public List<ClaseTextSueloDTO> getDataClaseTextSuelo() throws Exception;

	public List<Compania> getCompania() throws Exception;

	public void saveCompania(Compania entity) throws Exception;

	public void deleteCompania(Compania entity) throws Exception;

	public void updateCompania(Compania entity) throws Exception;

	public Compania getCompania(Long companiaId) throws Exception;

	public List<Compania> findByCriteriaInCompania(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Compania> findPageCompania(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCompania() throws Exception;

	public List<CompaniaDTO> getDataCompania() throws Exception;

	public List<ContBanco> getContBanco() throws Exception;

	public void saveContBanco(ContBanco entity) throws Exception;

	public void deleteContBanco(ContBanco entity) throws Exception;

	public void updateContBanco(ContBanco entity) throws Exception;

	public ContBanco getContBanco(Long contBancId) throws Exception;

	public List<ContBanco> findByCriteriaInContBanco(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ContBanco> findPageContBanco(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberContBanco() throws Exception;

	public List<ContBancoDTO> getDataContBanco() throws Exception;

	public List<Cultivo> getCultivo() throws Exception;

	public void saveCultivo(Cultivo entity) throws Exception;

	public void deleteCultivo(Cultivo entity) throws Exception;

	public void updateCultivo(Cultivo entity) throws Exception;

	public Cultivo getCultivo(Long cultivoId) throws Exception;

	public List<Cultivo> findByCriteriaInCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Cultivo> findPageCultivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCultivo() throws Exception;

	public List<CultivoDTO> getDataCultivo() throws Exception;

	public List<CultivoFitosanidad> getCultivoFitosanidad() throws Exception;

	public void saveCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	public void deleteCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	public void updateCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	public CultivoFitosanidad getCultivoFitosanidad(CultivoFitosanidadId id) throws Exception;

	public List<CultivoFitosanidad> findByCriteriaInCultivoFitosanidad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CultivoFitosanidad> findPageCultivoFitosanidad(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCultivoFitosanidad() throws Exception;

	public List<CultivoFitosanidadDTO> getDataCultivoFitosanidad() throws Exception;

	public List<DatClimat> getDatClimat() throws Exception;

	public void saveDatClimat(DatClimat entity) throws Exception;

	public void deleteDatClimat(DatClimat entity) throws Exception;

	public void updateDatClimat(DatClimat entity) throws Exception;

	public DatClimat getDatClimat(Long datsClimatoId) throws Exception;

	public List<DatClimat> findByCriteriaInDatClimat(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatClimat> findPageDatClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatClimat() throws Exception;

	public List<DatClimatDTO> getDataDatClimat() throws Exception;

	public List<DatEvaporimetro> getDatEvaporimetro() throws Exception;

	public void saveDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	public void deleteDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	public void updateDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	public DatEvaporimetro getDatEvaporimetro(Long datEvaporimetroId) throws Exception;

	public List<DatEvaporimetro> findByCriteriaInDatEvaporimetro(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatEvaporimetro> findPageDatEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatEvaporimetro() throws Exception;

	public List<DatEvaporimetroDTO> getDataDatEvaporimetro() throws Exception;

	public List<DatPluvio> getDatPluvio() throws Exception;

	public void saveDatPluvio(DatPluvio entity) throws Exception;

	public void deleteDatPluvio(DatPluvio entity) throws Exception;

	public void updateDatPluvio(DatPluvio entity) throws Exception;

	public DatPluvio getDatPluvio(Long datPluvioId) throws Exception;

	public List<DatPluvio> findByCriteriaInDatPluvio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPluvio> findPageDatPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatPluvio() throws Exception;

	public List<DatPluvioDTO> getDataDatPluvio() throws Exception;

	public List<DatSanVeg> getDatSanVeg() throws Exception;

	public void saveDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception;

	public void deleteDatSanVeg(DatSanVeg entity) throws Exception;

	public void updateDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception;

	public DatSanVeg getDatSanVeg(Long datSanVegId) throws Exception;

	public List<DatSanVeg> findByCriteriaInDatSanVeg(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatSanVeg> findPageDatSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatSanVeg() throws Exception;

	public List<DatSanVegDTO> getDataDatSanVeg(Long idAnalisis) throws Exception;

	public List<DificultadAcceso> getDificultadAcceso() throws Exception;

	public void saveDificultadAcceso(DificultadAcceso entity) throws Exception;

	public void deleteDificultadAcceso(DificultadAcceso entity) throws Exception;

	public void updateDificultadAcceso(DificultadAcceso entity) throws Exception;

	public DificultadAcceso getDificultadAcceso(Long dificultadAccesoId) throws Exception;

	public List<DificultadAcceso> findByCriteriaInDificultadAcceso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DificultadAcceso> findPageDificultadAcceso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDificultadAcceso() throws Exception;

	public List<DificultadAccesoDTO> getDataDificultadAcceso() throws Exception;

	public List<DistSiembra> getDistSiembra() throws Exception;

	public void saveDistSiembra(DistSiembra entity) throws Exception;

	public void deleteDistSiembra(DistSiembra entity) throws Exception;

	public void updateDistSiembra(DistSiembra entity) throws Exception;

	public DistSiembra getDistSiembra(Long distSiembraId) throws Exception;

	public List<DistSiembra> findByCriteriaInDistSiembra(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DistSiembra> findPageDistSiembra(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDistSiembra() throws Exception;

	public List<DistSiembraDTO> getDataDistSiembra() throws Exception;

	public List<EntBanc> getEntBanc() throws Exception;

	public void saveEntBanc(EntBanc entity) throws Exception;

	public void deleteEntBanc(EntBanc entity) throws Exception;

	public void updateEntBanc(EntBanc entity) throws Exception;

	public EntBanc getEntBanc(Long entBancId) throws Exception;

	public List<EntBanc> findByCriteriaInEntBanc(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EntBanc> findPageEntBanc(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEntBanc() throws Exception;

	public List<EntBancDTO> getDataEntBanc() throws Exception;

	public List<EquipoTrabajo> getEquipoTrabajo() throws Exception;

	public void saveEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	public void deleteEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	public void updateEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	public EquipoTrabajo getEquipoTrabajo(Long eqpTrabId) throws Exception;

	public List<EquipoTrabajo> findByCriteriaInEquipoTrabajo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EquipoTrabajo> findPageEquipoTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEquipoTrabajo() throws Exception;

	public List<EquipoTrabajoDTO> getDataEquipoTrabajo() throws Exception;

	public List<EstClimat> getEstClimat() throws Exception;

	public void saveEstClimat(EstClimat entity) throws Exception;

	public void deleteEstClimat(EstClimat entity) throws Exception;

	public void updateEstClimat(EstClimat entity) throws Exception;

	public EstClimat getEstClimat(Long estClimatId) throws Exception;

	public List<EstClimat> findByCriteriaInEstClimat(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstClimat> findPageEstClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstClimat() throws Exception;

	public List<EstClimatDTO> getDataEstClimat() throws Exception;

	public List<EstEvaporimetro> getEstEvaporimetro() throws Exception;

	public void saveEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	public void deleteEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	public void updateEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	public EstEvaporimetro getEstEvaporimetro(Long estEvaporimetroId) throws Exception;

	public List<EstEvaporimetro> findByCriteriaInEstEvaporimetro(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstEvaporimetro> findPageEstEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstEvaporimetro() throws Exception;

	public List<EstEvaporimetroDTO> getDataEstEvaporimetro() throws Exception;

	public List<EstPluvio> getEstPluvio() throws Exception;

	public void saveEstPluvio(EstPluvio entity) throws Exception;

	public void deleteEstPluvio(EstPluvio entity) throws Exception;

	public void updateEstPluvio(EstPluvio entity) throws Exception;

	public EstPluvio getEstPluvio(Long estPluvioId) throws Exception;

	public List<EstPluvio> findByCriteriaInEstPluvio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstPluvio> findPageEstPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstPluvio() throws Exception;

	public List<EstPluvioDTO> getDataEstPluvio() throws Exception;

	public List<EstructSiemb> getEstructSiemb() throws Exception;

	public void saveEstructSiemb(EstructSiemb entity) throws Exception;

	public void deleteEstructSiemb(EstructSiemb entity) throws Exception;

	public void updateEstructSiemb(EstructSiemb entity) throws Exception;

	public EstructSiemb getEstructSiemb(Long estrSiembId) throws Exception;

	public List<EstructSiemb> findByCriteriaInEstructSiemb(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstructSiemb> findPageEstructSiemb(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstructSiemb() throws Exception;

	public List<EstructSiembDTO> getDataEstructSiemb() throws Exception;

	public List<Etapa> getEtapa() throws Exception;

	public void saveEtapa(Etapa entity) throws Exception;

	public void deleteEtapa(Etapa entity) throws Exception;

	public void updateEtapa(Etapa entity) throws Exception;

	public Etapa getEtapa(Long etapaId) throws Exception;

	public List<Etapa> findByCriteriaInEtapa(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Etapa> findPageEtapa(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEtapa() throws Exception;

	public List<EtapaDTO> getDataEtapa() throws Exception;

	public List<FaseFenologica> getFaseFenologica() throws Exception;

	public void saveFaseFenologica(FaseFenologica entity) throws Exception;

	public void deleteFaseFenologica(FaseFenologica entity) throws Exception;

	public void updateFaseFenologica(FaseFenologica entity) throws Exception;

	public FaseFenologica getFaseFenologica(Long faseFenoId) throws Exception;

	public List<FaseFenologica> findByCriteriaInFaseFenologica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FaseFenologica> findPageFaseFenologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFaseFenologica() throws Exception;

	public List<FaseFenologicaDTO> getDataFaseFenologica() throws Exception;

	public List<Fitosanidad> getFitosanidad() throws Exception;

	public void saveFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception;

	public void deleteFitosanidad(Fitosanidad entity) throws Exception;

	public void updateFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception;

	public Fitosanidad getFitosanidad(Long fitosanidadId) throws Exception;

	public List<Fitosanidad> findByCriteriaInFitosanidad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Fitosanidad> findPageFitosanidad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFitosanidad() throws Exception;

	public List<FitosanidadDTO> getDataFitosanidad() throws Exception;

	public List<FliaTextSuelo> getFliaTextSuelo() throws Exception;

	public void saveFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	public void deleteFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	public void updateFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	public FliaTextSuelo getFliaTextSuelo(Long fliaTextSueloId) throws Exception;

	public List<FliaTextSuelo> findByCriteriaInFliaTextSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FliaTextSuelo> findPageFliaTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFliaTextSuelo() throws Exception;

	public List<FliaTextSueloDTO> getDataFliaTextSuelo() throws Exception;

	public List<FrenteCos> getFrenteCos() throws Exception;

	public void saveFrenteCos(FrenteCos entity) throws Exception;

	public void deleteFrenteCos(FrenteCos entity) throws Exception;

	public void updateFrenteCos(FrenteCos entity) throws Exception;

	public FrenteCos getFrenteCos(Long frtCosId) throws Exception;

	public List<FrenteCos> findByCriteriaInFrenteCos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FrenteCos> findPageFrenteCos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFrenteCos() throws Exception;

	public List<FrenteCosDTO> getDataFrenteCos() throws Exception;

	public List<GrpSuelo> getGrpSuelo() throws Exception;

	public void saveGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception;

	public void deleteGrpSuelo(GrpSuelo entity) throws Exception;

	public void updateGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception;

	public GrpSuelo getGrpSuelo(Long grupoSuelo) throws Exception;

	public List<GrpSuelo> findByCriteriaInGrpSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GrpSuelo> findPageGrpSuelo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpSuelo() throws Exception;

	public List<GrpSueloDTO> getDataGrpSuelo() throws Exception;

	public List<GrpTenen> getGrpTenen() throws Exception;

	public void saveGrpTenen(GrpTenen entity) throws Exception;

	public void deleteGrpTenen(GrpTenen entity) throws Exception;

	public void updateGrpTenen(GrpTenen entity) throws Exception;

	public GrpTenen getGrpTenen(Long grpTenId) throws Exception;

	public List<GrpTenen> findByCriteriaInGrpTenen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GrpTenen> findPageGrpTenen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpTenen() throws Exception;

	public List<GrpTenenDTO> getDataGrpTenen() throws Exception;

	public List<LaraEdad> getLaraEdad() throws Exception;

	public void saveLaraEdad(LaraEdad entity) throws Exception;

	public void deleteLaraEdad(LaraEdad entity) throws Exception;

	public void updateLaraEdad(LaraEdad entity) throws Exception;

	public LaraEdad getLaraEdad(Long laraEdadId) throws Exception;

	public List<LaraEdad> findByCriteriaInLaraEdad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaraEdad> findPageLaraEdad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLaraEdad() throws Exception;

	public List<LaraEdadDTO> getDataLaraEdad() throws Exception;

	public List<Larvas> getLarvas() throws Exception;

	public void saveLarvas(Larvas entity) throws Exception;

	public void deleteLarvas(Larvas entity) throws Exception;

	public void updateLarvas(Larvas entity) throws Exception;

	public Larvas getLarvas(Long larvasId) throws Exception;

	public List<Larvas> findByCriteriaInLarvas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Larvas> findPageLarvas(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLarvas() throws Exception;

	public List<LarvasDTO> getDataLarvas() throws Exception;

	public List<ListValor> getListValor() throws Exception;

	public void saveListValor(ListValor entity) throws Exception;

	public void deleteListValor(ListValor entity) throws Exception;

	public void updateListValor(ListValor entity) throws Exception;

	public ListValor getListValor(Long listValorId) throws Exception;

	public List<ListValor> findByCriteriaInListValor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ListValor> findPageListValor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberListValor() throws Exception;

	public List<ListValorDTO> getDataListValor() throws Exception;

	public List<Moneda> getMoneda() throws Exception;

	public void saveMoneda(Moneda entity) throws Exception;

	public void deleteMoneda(Moneda entity) throws Exception;

	public void updateMoneda(Moneda entity) throws Exception;

	public Moneda getMoneda(Long monedaId) throws Exception;

	public List<Moneda> findByCriteriaInMoneda(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Moneda> findPageMoneda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMoneda() throws Exception;

	public List<MonedaDTO> getDataMoneda() throws Exception;

	public List<MotElim> getMotElim() throws Exception;

	public void saveMotElim(MotElim entity) throws Exception;

	public void deleteMotElim(MotElim entity) throws Exception;

	public void updateMotElim(MotElim entity) throws Exception;

	public MotElim getMotElim(Long motElimId) throws Exception;

	public List<MotElim> findByCriteriaInMotElim(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MotElim> findPageMotElim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMotElim() throws Exception;

	public List<MotElimDTO> getDataMotElim() throws Exception;

	public List<MotEstim> getMotEstim() throws Exception;

	public void saveMotEstim(MotEstim entity) throws Exception;

	public void deleteMotEstim(MotEstim entity) throws Exception;

	public void updateMotEstim(MotEstim entity) throws Exception;

	public MotEstim getMotEstim(Long motEstimId) throws Exception;

	public List<MotEstim> findByCriteriaInMotEstim(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MotEstim> findPageMotEstim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMotEstim() throws Exception;

	public List<MotEstimDTO> getDataMotEstim() throws Exception;

	public List<N4Motivo> getN4Motivo() throws Exception;

	public void saveN4Motivo(N4Motivo entity) throws Exception;

	public void deleteN4Motivo(N4Motivo entity) throws Exception;

	public void updateN4Motivo(N4Motivo entity) throws Exception;

	public N4Motivo getN4Motivo(Long n4Mot) throws Exception;

	public List<N4Motivo> findByCriteriaInN4Motivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<N4Motivo> findPageN4Motivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberN4Motivo() throws Exception;

	public List<N4MotivoDTO> getDataN4Motivo() throws Exception;

	public List<Nivel1> getNivel1() throws Exception;

	public void saveNivel1(Nivel1 entity) throws Exception;

	public void deleteNivel1(Nivel1 entity) throws Exception;

	public void updateNivel1(Nivel1 entity) throws Exception;

	public Nivel1 getNivel1(Long nivel1Id) throws Exception;

	public List<Nivel1> findByCriteriaInNivel1(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel1> findPageNivel1(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel1() throws Exception;

	public List<Nivel1DTO> getDataNivel1() throws Exception;

	public List<Nivel2> getNivel2() throws Exception;

	public void saveNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception;

	public void updateNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception;

	public void deleteNivel2(Nivel2 entity) throws Exception;

	public Nivel2 getNivel2(Long nivel2Id) throws Exception;

	public List<Nivel2> findByCriteriaInNivel2(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel2> findPageNivel2(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel2() throws Exception;

	public List<Nivel2DTO> getDataNivel2() throws Exception;

	public List<Nivel3> getNivel3() throws Exception;

	public void saveNivel3(Nivel3 entity) throws Exception;

	public void deleteNivel3(Nivel3 entity) throws Exception;

	public void updateNivel3(Nivel3 entity) throws Exception;

	public Nivel3 getNivel3(Long nivel3Id) throws Exception;

	public List<Nivel3> findByCriteriaInNivel3(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel3> findPageNivel3(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel3() throws Exception;

	public List<Nivel3DTO> getDataNivel3() throws Exception;

	public List<Nivel4> getNivel4() throws Exception;

	public void saveNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception;

	public void deleteNivel4(Nivel4 entity) throws Exception;

	public void updateNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception;

	public Nivel4 getNivel4(Long nivel4Id) throws Exception;

	public List<Nivel4> findByCriteriaInNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel4> findPageNivel4(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel4() throws Exception;

	public List<Nivel4DTO> getDataNivel4() throws Exception;

	/*
	 * public List<NivelFertilidad> getNivelFertilidad() throws Exception;
	 * 
	 * public void saveNivelFertilidad(NivelFertilidad entity) throws Exception;
	 * 
	 * public void deleteNivelFertilidad(NivelFertilidad entity) throws Exception;
	 * 
	 * public void updateNivelFertilidad(NivelFertilidad entity) throws Exception;
	 * 
	 * public NivelFertilidad getNivelFertilidad(Long nivelFertilidadId) throws
	 * Exception;
	 * 
	 * public List<NivelFertilidad> findByCriteriaInNivelFertilidad(Object[]
	 * variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws
	 * Exception;
	 * 
	 * public List<NivelFertilidad> findPageNivelFertilidad(String sortColumnName,
	 * boolean sortAscending, int startRow, int maxResults) throws Exception;
	 * 
	 * public Long findTotalNumberNivelFertilidad() throws Exception;
	 * 
	 * public List<NivelFertilidadDTO> getDataNivelFertilidad() throws Exception;
	 */
	public List<Ocupacion> getOcupacion() throws Exception;

	public void saveOcupacion(Ocupacion entity) throws Exception;

	public void deleteOcupacion(Ocupacion entity) throws Exception;

	public void updateOcupacion(Ocupacion entity) throws Exception;

	public Ocupacion getOcupacion(Long ocupacionId) throws Exception;

	public List<Ocupacion> findByCriteriaInOcupacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Ocupacion> findPageOcupacion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberOcupacion() throws Exception;

	public List<OcupacionDTO> getDataOcupacion() throws Exception;

	public List<OrdenSuelo> getOrdenSuelo() throws Exception;

	public void saveOrdenSuelo(OrdenSuelo entity) throws Exception;

	public void deleteOrdenSuelo(OrdenSuelo entity) throws Exception;

	public void updateOrdenSuelo(OrdenSuelo entity) throws Exception;

	public OrdenSuelo getOrdenSuelo(Long ordenSuelo) throws Exception;

	public List<OrdenSuelo> findByCriteriaInOrdenSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<OrdenSuelo> findPageOrdenSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberOrdenSuelo() throws Exception;

	public List<OrdenSueloDTO> getDataOrdenSuelo() throws Exception;

	public List<Organizacion> getOrganizacion() throws Exception;

	public void saveOrganizacion(Organizacion entity) throws Exception;

	public void deleteOrganizacion(Organizacion entity) throws Exception;

	public void updateOrganizacion(Organizacion entity) throws Exception;

	public Organizacion getOrganizacion(Long organizId) throws Exception;

	public List<Organizacion> findByCriteriaInOrganizacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Organizacion> findPageOrganizacion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberOrganizacion() throws Exception;

	public List<OrganizacionDTO> getDataOrganizacion() throws Exception;

	public List<PersEmpr> getPersEmpr() throws Exception;

	public void savePersEmpr(PersEmpr entity) throws Exception;

	public void deletePersEmpr(PersEmpr entity) throws Exception;

	public void updatePersEmpr(PersEmpr entity) throws Exception;

	public PersEmpr getPersEmpr(Long persEmprId) throws Exception;

	public List<PersEmpr> findByCriteriaInPersEmpr(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PersEmpr> findPagePersEmpr(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPersEmpr() throws Exception;

	public List<PersEmprDTO> getDataPersEmpr() throws Exception;

	public List<Profesion> getProfesion() throws Exception;

	public void saveProfesion(Profesion entity) throws Exception;

	public void deleteProfesion(Profesion entity) throws Exception;

	public void updateProfesion(Profesion entity) throws Exception;

	public Profesion getProfesion(Long profId) throws Exception;

	public List<Profesion> findByCriteriaInProfesion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Profesion> findPageProfesion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProfesion() throws Exception;

	public List<ProfesionDTO> getDataProfesion() throws Exception;

	public List<RangoValor> getRangoValor() throws Exception;

	public void saveRangoValor(RangoValor entity) throws Exception;

	public void deleteRangoValor(RangoValor entity) throws Exception;

	public void updateRangoValor(RangoValor entity) throws Exception;

	public RangoValor getRangoValor(Long rangoValorId) throws Exception;

	public List<RangoValor> findByCriteriaInRangoValor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RangoValor> findPageRangoValor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRangoValor() throws Exception;

	public List<RangoValorDTO> getDataRangoValor() throws Exception;

	/*
	 * public List<RestriccionQuemaNivel4> getRestriccionQuemaNivel4() throws
	 * Exception;
	 * 
	 * public void saveRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws
	 * Exception;
	 * 
	 * public void deleteRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity)
	 * throws Exception;
	 * 
	 * public void updateRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity)
	 * throws Exception;
	 * 
	 * public RestriccionQuemaNivel4
	 * getRestriccionQuemaNivel4(RestriccionQuemaNivel4Id id) throws Exception;
	 * 
	 * public List<RestriccionQuemaNivel4>
	 * findByCriteriaInRestriccionQuemaNivel4(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception;
	 * 
	 * public List<RestriccionQuemaNivel4> findPageRestriccionQuemaNivel4(String
	 * sortColumnName, boolean sortAscending, int startRow, int maxResults) throws
	 * Exception;
	 * 
	 * public Long findTotalNumberRestriccionQuemaNivel4() throws Exception;
	 * 
	 * public List<RestriccionQuemaNivel4DTO> getDataRestriccionQuemaNivel4() throws
	 * Exception;
	 * 
	 * public List<RestriMaduranteNivel4> getRestriMaduranteNivel4() throws
	 * Exception;
	 * 
	 * public void saveRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws
	 * Exception;
	 * 
	 * public void deleteRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws
	 * Exception;
	 * 
	 * public void updateRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws
	 * Exception;
	 * 
	 * public RestriMaduranteNivel4 getRestriMaduranteNivel4(RestriMaduranteNivel4Id
	 * id) throws Exception;
	 * 
	 * public List<RestriMaduranteNivel4>
	 * findByCriteriaInRestriMaduranteNivel4(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception;
	 * 
	 * public List<RestriMaduranteNivel4> findPageRestriMaduranteNivel4(String
	 * sortColumnName, boolean sortAscending, int startRow, int maxResults) throws
	 * Exception;
	 * 
	 * public Long findTotalNumberRestriMaduranteNivel4() throws Exception;
	 * 
	 * public List<RestriMaduranteNivel4DTO> getDataRestriMaduranteNivel4() throws
	 * Exception;
	 * 
	 * public List<RestrMadurante> getRestrMadurante() throws Exception;
	 * 
	 * public void saveRestrMadurante(RestrMadurante entity) throws Exception;
	 * 
	 * public void deleteRestrMadurante(RestrMadurante entity) throws Exception;
	 * 
	 * public void updateRestrMadurante(RestrMadurante entity) throws Exception;
	 * 
	 * public RestrMadurante getRestrMadurante(Long restMaduId) throws Exception;
	 * 
	 * public List<RestrMadurante> findByCriteriaInRestrMadurante(Object[]
	 * variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws
	 * Exception;
	 * 
	 * public List<RestrMadurante> findPageRestrMadurante(String sortColumnName,
	 * boolean sortAscending, int startRow, int maxResults) throws Exception;
	 * 
	 * public Long findTotalNumberRestrMadurante() throws Exception;
	 * 
	 * public List<RestrMaduranteDTO> getDataRestrMadurante() throws Exception;
	 * 
	 * public List<RestrQuema> getRestrQuema() throws Exception;
	 * 
	 * public void saveRestrQuema(RestrQuema entity) throws Exception;
	 * 
	 * public void deleteRestrQuema(RestrQuema entity) throws Exception;
	 * 
	 * public void updateRestrQuema(RestrQuema entity) throws Exception;
	 * 
	 * public RestrQuema getRestrQuema(Long restQuema) throws Exception;
	 * 
	 * public List<RestrQuema> findByCriteriaInRestrQuema(Object[] variables,
	 * Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;
	 * 
	 * public List<RestrQuema> findPageRestrQuema(String sortColumnName, boolean
	 * sortAscending, int startRow, int maxResults) throws Exception;
	 * 
	 * public Long findTotalNumberRestrQuema() throws Exception;
	 * 
	 * public List<RestrQuemaDTO> getDataRestrQuema() throws Exception;
	 */
	public List<SerieSuelo> getSerieSuelo() throws Exception;

	public void saveSerieSuelo(SerieSuelo entity) throws Exception;

	public void deleteSerieSuelo(SerieSuelo entity) throws Exception;

	public void updateSerieSuelo(SerieSuelo entity) throws Exception;

	public SerieSuelo getSerieSuelo(Long serieSueloId) throws Exception;

	public List<SerieSuelo> findByCriteriaInSerieSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SerieSuelo> findPageSerieSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSerieSuelo() throws Exception;

	public List<SerieSueloDTO> getDataSerieSuelo() throws Exception;

	public List<TarifaContratista> getTarifaContratista() throws Exception;

	public void saveTarifaContratista(TarifaContratista entity) throws Exception;

	public void deleteTarifaContratista(TarifaContratista entity) throws Exception;

	public void updateTarifaContratista(TarifaContratista entity) throws Exception;

	public TarifaContratista getTarifaContratista(Long contratistaId) throws Exception;

	public List<TarifaContratista> findByCriteriaInTarifaContratista(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaContratista> findPageTarifaContratista(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaContratista() throws Exception;

	public List<TarifaContratistaDTO> getDataTarifaContratista() throws Exception;

	public List<TarifaEquipProp> getTarifaEquipProp() throws Exception;

	public void saveTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	public void deleteTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	public void updateTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	public TarifaEquipProp getTarifaEquipProp(Long tarifaEquipPropId) throws Exception;

	public List<TarifaEquipProp> findByCriteriaInTarifaEquipProp(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaEquipProp> findPageTarifaEquipProp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaEquipProp() throws Exception;

	public List<TarifaEquipPropDTO> getDataTarifaEquipProp() throws Exception;

	public List<TarifaProfesion> getTarifaProfesion() throws Exception;

	public void saveTarifaProfesion(TarifaProfesion entity) throws Exception;

	public void deleteTarifaProfesion(TarifaProfesion entity) throws Exception;

	public void updateTarifaProfesion(TarifaProfesion entity) throws Exception;

	public TarifaProfesion getTarifaProfesion(Long tarifaProfesiondId) throws Exception;

	public List<TarifaProfesion> findByCriteriaInTarifaProfesion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaProfesion> findPageTarifaProfesion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaProfesion() throws Exception;

	public List<TarifaProfesionDTO> getDataTarifaProfesion() throws Exception;

	public List<Tenencia> getTenencia() throws Exception;

	public void saveTenencia(Tenencia entity) throws Exception;

	public void deleteTenencia(Tenencia entity) throws Exception;

	public void updateTenencia(Tenencia entity) throws Exception;

	public Tenencia getTenencia(Long tenenId) throws Exception;

	public List<Tenencia> findByCriteriaInTenencia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Tenencia> findPageTenencia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTenencia() throws Exception;

	public List<TenenciaDTO> getDataTenencia() throws Exception;

	public List<TipCultivo> getTipCultivo() throws Exception;

	public void saveTipCultivo(TipCultivo entity) throws Exception;

	public void deleteTipCultivo(TipCultivo entity) throws Exception;

	public void updateTipCultivo(TipCultivo entity) throws Exception;

	public TipCultivo getTipCultivo(Long tipoCultivoId) throws Exception;

	public List<TipCultivo> findByCriteriaInTipCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipCultivo> findPageTipCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipCultivo() throws Exception;

	public List<TipCultivoDTO> getDataTipCultivo() throws Exception;

	public List<TipoDia> getTipoDia() throws Exception;

	public void saveTipoDia(TipoDia entity) throws Exception;

	public void deleteTipoDia(TipoDia entity) throws Exception;

	public void updateTipoDia(TipoDia entity) throws Exception;

	public TipoDia getTipoDia(Long tipDiaId) throws Exception;

	public List<TipoDia> findByCriteriaInTipoDia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoDia> findPageTipoDia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDia() throws Exception;

	public List<TipoDiaDTO> getDataTipoDia() throws Exception;

	public List<TipoDrenaje> getTipoDrenaje() throws Exception;

	public void saveTipoDrenaje(TipoDrenaje entity) throws Exception;

	public void deleteTipoDrenaje(TipoDrenaje entity) throws Exception;

	public void updateTipoDrenaje(TipoDrenaje entity) throws Exception;

	public TipoDrenaje getTipoDrenaje(Long tipoDrenajeId) throws Exception;

	public List<TipoDrenaje> findByCriteriaInTipoDrenaje(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoDrenaje> findPageTipoDrenaje(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoDrenaje() throws Exception;

	public List<TipoDrenajeDTO> getDataTipoDrenaje() throws Exception;

	public List<TipProvee> getTipProvee() throws Exception;

	public void saveTipProvee(TipProvee entity) throws Exception;

	public void deleteTipProvee(TipProvee entity) throws Exception;

	public void updateTipProvee(TipProvee entity) throws Exception;

	public TipProvee getTipProvee(Long tpProvId) throws Exception;

	public List<TipProvee> findByCriteriaInTipProvee(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipProvee> findPageTipProvee(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipProvee() throws Exception;

	public List<TipProveeDTO> getDataTipProvee() throws Exception;

//	public List<Topografia> getTopografia() throws Exception;

	public void saveTopografia(Topografia entity) throws Exception;

	public void deleteTopografia(Topografia entity) throws Exception;

	public void updateTopografia(Topografia entity) throws Exception;

	public Topografia getTopografia(Long topografiaId) throws Exception;

	public List<Topografia> findByCriteriaInTopografia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Topografia> findPageTopografia(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTopografia() throws Exception;

	public List<TopografiaDTO> getDataTopografia() throws Exception;

	public List<Trabajador> getTrabajador() throws Exception;

	public void saveTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception;

	public void deleteTrabajador(Trabajador entity) throws Exception;

	public void updateTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception;

	public Trabajador getTrabajador(Long trabId) throws Exception;

	public List<Trabajador> findByCriteriaInTrabajador(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Trabajador> findPageTrabajador(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTrabajador() throws Exception;

	public List<TrabajadorDTO> getDataTrabajador() throws Exception;

	public List<UdadMed> getUdadMed() throws Exception;

	public void saveUdadMed(UdadMed entity) throws Exception;

	public void deleteUdadMed(UdadMed entity) throws Exception;

	public void updateUdadMed(UdadMed entity) throws Exception;

	public UdadMed getUdadMed(Long udadMedId) throws Exception;

	public List<UdadMed> findByCriteriaInUdadMed(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<UdadMed> findPageUdadMed(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUdadMed() throws Exception;

	public List<UdadMedDTO> getDataUdadMed() throws Exception;

	public List<ValorVar> getValorVar() throws Exception;

	public void saveValorVar(ValorVar entity) throws Exception;

	public void deleteValorVar(ValorVar entity) throws Exception;

	public void updateValorVar(ValorVar entity) throws Exception;

	public ValorVar getValorVar(Long valorVarId) throws Exception;

	public List<ValorVar> findByCriteriaInValorVar(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ValorVar> findPageValorVar(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberValorVar() throws Exception;

	public List<ValorVarDTO> getDataValorVar() throws Exception;

	public List<Variable> getVariable() throws Exception;

	public void deleteVariable(Variable entity) throws Exception;

	public Variable getVariable(Long variableId) throws Exception;

	public List<Variable> findByCriteriaInVariable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Variable> findPageVariable(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVariable() throws Exception;

	public List<VariableDTO> getDataVariable() throws Exception;

	public List<Variedad> getVariedad() throws Exception;

	public void saveVariedad(Variedad entity) throws Exception;

	public void deleteVariedad(Variedad entity) throws Exception;

	public void updateVariedad(Variedad entity) throws Exception;

	public Variedad getVariedad(Long variedId) throws Exception;

	public List<Variedad> findByCriteriaInVariedad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Variedad> findPageVariedad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVariedad() throws Exception;

	public List<VariedadDTO> getDataVariedad() throws Exception;

	public List<VariedadNivel4> getVariedadNivel4() throws Exception;

	public void saveVariedadNivel4(VariedadNivel4 entity) throws Exception;

	public void deleteVariedadNivel4(VariedadNivel4 entity) throws Exception;

	public void updateVariedadNivel4(VariedadNivel4 entity) throws Exception;

	public VariedadNivel4 getVariedadNivel4(Long variedadNivel4Id) throws Exception;

	public List<VariedadNivel4> findByCriteriaInVariedadNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<VariedadNivel4> findPageVariedadNivel4(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberVariedadNivel4() throws Exception;

	public List<VariedadNivel4DTO> getDataVariedadNivel4() throws Exception;

	public List<ZonaGeografica> getZonaGeografica() throws Exception;

	public void saveZonaGeografica(ZonaGeografica entity) throws Exception;

	public void deleteZonaGeografica(ZonaGeografica entity) throws Exception;

	public void updateZonaGeografica(ZonaGeografica entity) throws Exception;

	public ZonaGeografica getZonaGeografica(Long zonaGeograficaId) throws Exception;

	public List<ZonaGeografica> findByCriteriaInZonaGeografica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ZonaGeografica> findPageZonaGeografica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberZonaGeografica() throws Exception;

	public List<ZonaGeograficaDTO> getDataZonaGeografica() throws Exception;

	public List<ZonAgroec> getZonAgroec() throws Exception;

	public void saveZonAgroec(ZonAgroec entity) throws Exception;

	public void deleteZonAgroec(ZonAgroec entity) throws Exception;

	public void updateZonAgroec(ZonAgroec entity) throws Exception;

	public ZonAgroec getZonAgroec(Long zonAgroec) throws Exception;

	public List<ZonAgroec> findByCriteriaInZonAgroec(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ZonAgroec> findPageZonAgroec(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberZonAgroec() throws Exception;

	public List<ZonAgroecDTO> getDataZonAgroec() throws Exception;

	public List<TarifaDeduccion> getTarifaDeduccion() throws Exception;

	public void saveTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	public void deleteTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	public void updateTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	public TarifaDeduccion getTarifaDeduccion(Long deduccionId) throws Exception;

	public List<TarifaDeduccion> findByCriteriaInTarifaDeduccion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaDeduccion> findPageTarifaDeduccion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaDeduccion() throws Exception;

	public List<TarifaDeduccionDTO> getDataTarifaDeduccion() throws Exception;

	public List<TarifaOtrosDevengos> getTarifaOtrosDevengos() throws Exception;

	public void saveTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	public void deleteTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	public void updateTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	public TarifaOtrosDevengos getTarifaOtrosDevengos(Long odevengosId) throws Exception;

	public List<TarifaOtrosDevengos> findByCriteriaInTarifaOtrosDevengos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaOtrosDevengos> findPageTarifaOtrosDevengos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaOtrosDevengos() throws Exception;

	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengos() throws Exception;

	public void saveVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception;

	public void updateVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception;

	public List<ListValorDTO> getDataValoresByVariableId(Long variableId) throws Exception;

	public List<RangoValorDTO> getDataRangoByVariableId(Long variableId) throws Exception;

	public List<VariedadNivel4DTO> getDataVariedadNivel4ByNivel4Id(Long variedadId) throws Exception;

	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad)
			throws Exception;

	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca) throws Exception;

	public void saveDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception;

	public void updateDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception;

	public List<DatAplicProdDetDTO> getDataDetProductosByDatAplicProdId(Long datAplicProdId) throws Exception;

	/*** Tarifas ***/
	public List<PrecioPromProdDTO> getDataProductosByPrecioPromProdId(Long productoId) throws Exception;

	public List<TarifaEquipPropDTO> getDataEquipoByTarifaEquipPropId(Long equipoId) throws Exception;

	public List<TarifaProfesionDTO> getDataProfesionByTarifaProfesionId(Long profesionId) throws Exception;

	public List<TarifaContratistaDTO> getDataContratistaByTarifaContratistaId(Long persEmprId) throws Exception;

	public List<TarifaLaborRendimientoDTO> getDataRendimientoByTarifaRendimientoId(Long laborId) throws Exception;

	public void saveLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, List<LaborCcontableDTO> dataCcontable

	) throws Exception;

	public void updateLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, List<LaborCcontableDTO> dataCcontable) throws Exception;

	public void saveProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion

	) throws Exception;

	public void updateProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception;

	public void saveEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception;

	public void updateEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception;

	public void saveProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception;

	public void updateProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception;


	public void savePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception;

	public void updatePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception;

	public List<TarifaLaborRendimiento> getTarifaLaborRendimiento() throws Exception;

	public void saveTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	public void deleteTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	public void updateTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	public TarifaLaborRendimiento getTarifaLaborRendimiento(Long tarifaLaborId) throws Exception;

	public List<TarifaLaborRendimiento> findByCriteriaInTarifaLaborRendimiento(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<TarifaLaborRendimiento> findPageTarifaLaborRendimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaLaborRendimiento() throws Exception;

	public List<TarifaLaborRendimientoDTO> getDataTarifaLaborRendimiento() throws Exception;

	/***/
	public void saveDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4, List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception;

	public void updateDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4, List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception;

	public List<DatTransProdDetDTO> getDataDetTransProductosByDatTransProdId(Long datTransProdId) throws Exception;

	public List<EstPluvioDTO> getDataPageEstPluvio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberEstPluvio(Map<String, Object> filters) throws Exception;

	public List<Nivel4DTO> getDataPageNivel4(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel4(Map<String, Object> filters) throws Exception;

	public List<Nivel2DTO> getDataPageNivel2(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel2(Map<String, Object> filters) throws Exception;

	public List<Nivel3DTO> getDataPageNivel3(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel3(Map<String, Object> filters) throws Exception;

	public List<TrabajadorDTO> getDataPageTrabajador(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) throws Exception;

	public Long findTotalNumberTrabajador(Map<String, Object> filters) throws Exception;

	public List<EquipoDTO> getDataPageEquipo(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) throws Exception;

	public Long findTotalNumberEquipo(Map<String, Object> filters) throws Exception;

	public List<PersEmprDTO> getDataPageEmpresa(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberEmpresa(Map<String, Object> filters) throws Exception;

	public List<FlotaTransporteDTO> getDataPageFlotaTransporte(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberFlotaTransporte(Map<String, Object> filters) throws Exception;

	public List<ProductoDTO> getDataPageProducto(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberProducto(Map<String, Object> filters) throws Exception;

	public List<DatPlanLaborDTO> getDataPagePlanLabor(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberPlanLabor(Map<String, Object> filters) throws Exception;

	public List<DatPlanillaNominaDTO> getDataPagePlanillaNomina(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberPlanillaNomina(Map<String, Object> filters) throws Exception;

	public List<DatServicioDTO> getDataPageServicio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberServicio(Map<String, Object> filters) throws Exception;

	public List<DatAplicProductoDTO> getDataPageAplicProducto(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberAplicProducto(Map<String, Object> filters) throws Exception;

	public List<DatRiegoDTO> getDataPageRiego(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberRiego(Map<String, Object> filters) throws Exception;

	public List<DatClimatDTO> getDataPageClima(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberClima(Map<String, Object> filters) throws Exception;

	public List<DatPluvioDTO> getDataPageDatPluvio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatPluvio(Map<String, Object> filters) throws Exception;

	public List<DatEstimCosechaDTO> getDataPageDatEstimCosecha(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatEstimCosecha(Map<String, Object> filters) throws Exception;

	public List<DatEvaporimetroDTO> getDataPageDatEvaporimetro(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatEvaporimetro(Map<String, Object> filters) throws Exception;

	public List<DatTransProdDTO> getDataPageDatTransProd(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatTransProd(Map<String, Object> filters) throws Exception;

	public List<ProgramacionLaboresDTO> consultarInformeProgramacionLabores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor,
			String supervisor, Long flagSupervisor) throws Exception;

	public List<DatosClimaticosDTO> consultarInformeDatosClimaticos(Long compania, Long estClima, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public List<DatosEvaporimetrosDTO> consultarInformeDatosEvaporimetros(Long estEvaporimetro, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public List<PluviometriaDTO> consultarInformePluviometria(Long estPluvio, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public List<ProntuarioLotesDTO> consultarInformeProntuarioLotes(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String tenencia,
			Long flagTenencia) throws Exception;

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

	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

	public List<DisponibilidadHidricaDTO> consultarInformeDisponibilidadHidrica(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura,
			Long flagInfraestructura, String sistemaRiego, Long flagSistemaRiego, Long numPlanilla) throws Exception;

	public List<IncidenciaEnfermedadDTO> consultarInformeIncidenciaEnfermedad(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception;

	public List<PrecipitacionAniosDTO> consultarInformePrecipitacionAnios(Long estPluvio) throws Exception;

	public List<HorasMaquinaDetalladoDTO> consultarInformeHorasMaquinaDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo,
			Long numPlanilla) throws Exception;

	/**** Consulta orden de trabajo *****/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) throws Exception;

	/***** Consulta valores posibles variables sanidad vegetal ***/
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorVariable, Long idAnalisis) throws Exception;

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

	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) throws Exception;

	public Long consultarFaseFenologicaId(Date idFechaDescanso) throws Exception;

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

	public List<DetalleInsumosLoteDTO> consultaDetalleInsumosLoteDTO(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception;

	/******************* CALCULAR EDAD LOTE **********/
	public Double calcularEdadLote(Date fechaActual, Long nivel4) throws Exception;

	/**************************
	 * CONSULTAS DE CONSECUTIVO TRANSACCIONALES
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

	/***************** tarifas ***********/
	public Double consultarPrecioPromProducto(Long idProducto, Long idAlmacen, Long idCompania, Date idFecha)
			throws Exception;

	public BigDecimal consultarTarifaProfesion(Long idCompania, Long idContratista, Long idProfesion,
			Long idCeptoNomina, Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborRendimiento(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborBonificacion(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarAuxSabado(Long idCompania, Long idTrabajador, Date idFecha) throws Exception;

	public Long consultarDiaSabado(Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborRendimientoBase(Long idCompania, Long idContratista, Long idLabor,
			Long idNivel2, Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaEquipProp(Long idCompania, Long idEquipo, Long idUdadMed, Date idFecha)
			throws Exception;

	public BigDecimal consultarTarifaContratista(Long idCompania, Long idContratista, Long idLabor, Long idServicio,
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc, Long nivel2Id, Long nivel4Id,
			String alturaMata) throws Exception;

	PrecioPromProd getPrecioPromProd(Long precioPromProdId) throws Exception;

	public List<GroupAuthorities> getGroupAuthorities() throws Exception;

	public void saveGroupAuthorities(GroupAuthorities entity) throws Exception;

	public void deleteGroupAuthorities(GroupAuthorities entity) throws Exception;

	public void updateGroupAuthorities(GroupAuthorities entity) throws Exception;

	public GroupAuthorities getGroupAuthorities(Long id) throws Exception;

	public List<GroupAuthorities> findByCriteriaInGroupAuthorities(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GroupAuthorities> findPageGroupAuthorities(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberGroupAuthorities() throws Exception;

	public List<GroupAuthoritiesDTO> getDataGroupAuthorities() throws Exception;

	public List<GroupMembers> getGroupMembers() throws Exception;

	public void saveGroupMembers(GroupMembers entity) throws Exception;

	public void deleteGroupMembers(GroupMembers entity) throws Exception;

	public void updateGroupMembers(GroupMembers entity) throws Exception;

	public GroupMembers getGroupMembers(Long id) throws Exception;

	public List<GroupMembers> findByCriteriaInGroupMembers(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GroupMembers> findPageGroupMembers(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberGroupMembers() throws Exception;

	public List<GroupMembersDTO> getDataGroupMembers() throws Exception;

	public List<Groups> getGroups() throws Exception;

	public void deleteGroups(Groups entity) throws Exception;

	public void saveGroups(Groups entity, GroupAuthorities entity2) throws Exception;

	public void updateGroups(Groups entity, GroupAuthorities entity2) throws Exception;

	public Groups getGroups(Long id) throws Exception;

	public List<Groups> findByCriteriaInGroups(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Groups> findPageGroups(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGroups() throws Exception;

	public List<GroupsDTO> getDataGroups() throws Exception;

	public List<Usuarios> getUsuarios() throws Exception;

	public void deleteUsuarios(Usuarios entity) throws Exception;

	public void saveUsuarios(Usuarios entity, List<String> grpUser) throws Exception;

	public void updateUsuarios(Usuarios entity, List<String> grpUser) throws Exception;

	public Usuarios getUsuarios(Long usuarioId) throws Exception;

	public List<Usuarios> findByCriteriaInUsuarios(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Usuarios> findPageUsuarios(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUsuarios() throws Exception;

	public List<UsuariosDTO> getDataUsuarios() throws Exception;

	public List<Vereda> getVereda() throws Exception;

	public void saveVereda(Vereda entity) throws Exception;

	public void deleteVereda(Vereda entity) throws Exception;

	public void updateVereda(Vereda entity) throws Exception;

	public Vereda getVereda(Long veredaId) throws Exception;

	public List<Vereda> findByCriteriaInVereda(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Vereda> findPageVereda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVereda() throws Exception;

	public List<VeredaDTO> getDataVereda() throws Exception;

	public List<String> consultarItemsPorModulo(String modulo);

	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengosByTrabajador(Long Trabajador) throws Exception;

	public List<TarifaDeduccionDTO> getDataTarifaDeduccionByTrabajador(Long Trabajador) throws Exception;

	public List<DatPlanillaNominaDet> getDatPlanillaNominaDet() throws Exception;

	public void saveDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	public void deleteDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	public void updateDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	public DatPlanillaNominaDet getDatPlanillaNominaDet(Long detPlanillaNominaId) throws Exception;

	public List<DatPlanillaNominaDet> findByCriteriaInDatPlanillaNominaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanillaNominaDet> findPageDatPlanillaNominaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanillaNominaDet() throws Exception;

	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDet() throws Exception;

	public List<DatServicioDet> getDatServicioDet() throws Exception;

	public void saveDatServicioDet(DatServicioDet entity) throws Exception;

	public void deleteDatServicioDet(DatServicioDet entity) throws Exception;

	public void updateDatServicioDet(DatServicioDet entity) throws Exception;

	public DatServicioDet getDatServicioDet(Long datServicioDetId) throws Exception;



	public List<DatServicioDet> findPageDatServicioDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatServicioDet() throws Exception;

	public List<DatServicioDetDTO> getDataDatServicioDet() throws Exception;

	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDetByNomina(Long planillaNominaId) throws Exception;

	public List<DatServicioDetDTO> getDataDatServicioDetByServicio(Long datServicioId) throws Exception;

	public List<ItemsMenu> getItemsMenu() throws Exception;

	public void saveItemsMenu(ItemsMenu entity) throws Exception;

	public void deleteItemsMenu(ItemsMenu entity) throws Exception;

	public void updateItemsMenu(ItemsMenu entity) throws Exception;

	public ItemsMenu getItemsMenu(Long id) throws Exception;

	public List<ItemsMenu> findByCriteriaInItemsMenu(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ItemsMenu> findPageItemsMenu(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberItemsMenu() throws Exception;

	public List<ItemsMenuDTO> getDataItemsMenu() throws Exception;

	public List<ItemsMenuDTO> getDataItemsMenuGlosario(String modulo) throws Exception;

	/**** Consulta a DTO de transaccionales ***/
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() throws Exception;

	public List<CronogramaLabores> getCronogramaLabores() throws Exception;

	public void saveCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception;

	public void deleteCronogramaLabores(CronogramaLabores entity) throws Exception;

	public void updateCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception;

	public CronogramaLabores getCronogramaLabores(Long cronogramaLaboresId) throws Exception;

	public List<CronogramaLabores> findByCriteriaInCronogramaLabores(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLabores> findPageCronogramaLabores(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLabores() throws Exception;

	public List<CronogramaLaboresDTO> getDataCronogramaLabores() throws Exception;

	public List<CronogramaLaboresLabores> getCronogramaLaboresLabores() throws Exception;

	public void saveCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	public void deleteCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	public void updateCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	public CronogramaLaboresLabores getCronogramaLaboresLabores(Long cronogramaLaboresLaboresId) throws Exception;

	public List<CronogramaLaboresLabores> findByCriteriaInCronogramaLaboresLabores(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLaboresLabores> findPageCronogramaLaboresLabores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLaboresLabores() throws Exception;

	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLabores() throws Exception;

	public List<CronogramaLaboresNivel4> getCronogramaLaboresNivel4() throws Exception;

	public void saveCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	public void deleteCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	public void updateCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	public CronogramaLaboresNivel4 getCronogramaLaboresNivel4(Long cronogramaLaboresNivel4Id) throws Exception;

	public List<CronogramaLaboresNivel4> findByCriteriaInCronogramaLaboresNivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLaboresNivel4> findPageCronogramaLaboresNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLaboresNivel4() throws Exception;

	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4() throws Exception;

	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLaboresByCronograma(Long cronogramaLaboresId)
			throws Exception;

	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4ByCronograma(Long cronogramaLaboresId)
			throws Exception;

	public List<AgenteCausadorParada> getAgenteCausadorParada() throws Exception;

	public void saveAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	public void deleteAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	public void updateAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	public AgenteCausadorParada getAgenteCausadorParada(Long agenteCausadorParadaId) throws Exception;

	public List<AgenteCausadorParada> findByCriteriaInAgenteCausadorParada(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<AgenteCausadorParada> findPageAgenteCausadorParada(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberAgenteCausadorParada() throws Exception;

	public List<AgenteCausadorParadaDTO> getDataAgenteCausadorParada() throws Exception;

	public List<BombaAbastecimiento> getBombaAbastecimiento() throws Exception;

	public void saveBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	public void deleteBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	public void updateBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	public BombaAbastecimiento getBombaAbastecimiento(Long bombaAbastecimientoId) throws Exception;

	public List<BombaAbastecimiento> findByCriteriaInBombaAbastecimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<BombaAbastecimiento> findPageBombaAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberBombaAbastecimiento() throws Exception;

	public List<BombaAbastecimientoDTO> getDataBombaAbastecimiento() throws Exception;

	public List<DatAbastCombustible> getDatAbastCombustible() throws Exception;

	public void saveDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	public void deleteDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	public void updateDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	public DatAbastCombustible getDatAbastCombustible(Long datAbastCombustibleId) throws Exception;

	public List<DatAbastCombustible> findByCriteriaInDatAbastCombustible(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAbastCombustible> findPageDatAbastCombustible(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatAbastCombustible() throws Exception;

	public List<DatAbastCombustibleDTO> getDataDatAbastCombustible() throws Exception;

	public List<DatMantenimientoEquipo> getDatMantenimientoEquipo() throws Exception;

	public void saveDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision,
			DatHorasTrabajoEquipo entity_hrt) throws Exception;

	public void deleteDatMantenimientoEquipo(DatMantenimientoEquipo entity) throws Exception;

	public void updateDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision)
			throws Exception;

	public DatMantenimientoEquipo getDatMantenimientoEquipo(Long datMantenimientoEquipoId) throws Exception;

	public List<DatMantenimientoEquipo> findByCriteriaInDatMantenimientoEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipo> findPageDatMantenimientoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipo() throws Exception;

	public List<DatMantenimientoEquipoDTO> getDataDatMantenimientoEquipo(String modulo) throws Exception;

	public List<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMec() throws Exception;

	public void saveDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	public void deleteDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	public void updateDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	public DatMantenimientoEquipoMec getDatMantenimientoEquipoMec(Long datMantenimientoEquipoMecId) throws Exception;

	public List<DatMantenimientoEquipoMec> findByCriteriaInDatMantenimientoEquipoMec(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipoMec> findPageDatMantenimientoEquipoMec(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipoMec() throws Exception;

	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMec() throws Exception;

	public List<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProd() throws Exception;

	public void saveDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	public void deleteDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	public void updateDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	public DatMantenimientoEquipoProd getDatMantenimientoEquipoProd(Long datMantenimientoEquipoProdId) throws Exception;

	public List<DatMantenimientoEquipoProd> findByCriteriaInDatMantenimientoEquipoProd(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipoProd> findPageDatMantenimientoEquipoProd(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipoProd() throws Exception;

	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProd() throws Exception;

	public List<MotivosEntradaTaller> getMotivosEntradaTaller() throws Exception;

	public void saveMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	public void deleteMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	public void updateMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	public MotivosEntradaTaller getMotivosEntradaTaller(Long motivosEntradaTallerId) throws Exception;

	public List<MotivosEntradaTaller> findByCriteriaInMotivosEntradaTaller(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<MotivosEntradaTaller> findPageMotivosEntradaTaller(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberMotivosEntradaTaller() throws Exception;

	public List<MotivosEntradaTallerDTO> getDataMotivosEntradaTaller() throws Exception;

	public List<PlanRevisionEquipo> getPlanRevisionEquipo() throws Exception;

	public void savePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception;

	public void deletePlanRevisionEquipo(PlanRevisionEquipo entity) throws Exception;

	public void updatePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception;

	public PlanRevisionEquipo getPlanRevisionEquipo(Long planRevisionEquipoId) throws Exception;

	public List<PlanRevisionEquipo> findByCriteriaInPlanRevisionEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipo> findPagePlanRevisionEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipo() throws Exception;

	public List<PlanRevisionEquipoDTO> getDataPlanRevisionEquipo(String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception;

	public List<PlanRevisionEquipoActiv> getPlanRevisionEquipoActiv() throws Exception;

	public void savePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	public void deletePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	public void updatePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	public PlanRevisionEquipoActiv getPlanRevisionEquipoActiv(Long planRevisionEquipoActivId) throws Exception;

	public List<PlanRevisionEquipoActiv> findByCriteriaInPlanRevisionEquipoActiv(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipoActiv> findPagePlanRevisionEquipoActiv(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipoActiv() throws Exception;

	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActiv() throws Exception;

	public List<PlanRevisionEquipoDet> getPlanRevisionEquipoDet() throws Exception;

	public void savePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception;

	public void deletePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception;

	public void updatePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception;

	public PlanRevisionEquipoDet getPlanRevisionEquipoDet(Long planRevisionEquipoDetId) throws Exception;

	public List<PlanRevisionEquipoDet> findByCriteriaInPlanRevisionEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipoDet> findPagePlanRevisionEquipoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipoDet() throws Exception;

	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDet() throws Exception;

	public List<TallerMecanico> getTallerMecanico() throws Exception;

	public void saveTallerMecanico(TallerMecanico entity) throws Exception;

	public void deleteTallerMecanico(TallerMecanico entity) throws Exception;

	public void updateTallerMecanico(TallerMecanico entity) throws Exception;

	public TallerMecanico getTallerMecanico(Long tallerMecanicoId) throws Exception;

	public List<TallerMecanico> findByCriteriaInTallerMecanico(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TallerMecanico> findPageTallerMecanico(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTallerMecanico() throws Exception;

	public List<TallerMecanicoDTO> getDataTallerMecanico() throws Exception;

	public List<TipoAbastecimiento> getTipoAbastecimiento() throws Exception;

	public void saveTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	public void deleteTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	public void updateTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	public TipoAbastecimiento getTipoAbastecimiento(Long tipoAbastecimientoId) throws Exception;

	public List<TipoAbastecimiento> findByCriteriaInTipoAbastecimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoAbastecimiento> findPageTipoAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoAbastecimiento() throws Exception;

	public List<TipoAbastecimientoDTO> getDataTipoAbastecimiento() throws Exception;

	public List<TipoMantenimiento> getTipoMantenimiento() throws Exception;

	public void saveTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	public void deleteTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	public void updateTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	public TipoMantenimiento getTipoMantenimiento(Long tipoMantenimientoId) throws Exception;

	public List<TipoMantenimiento> findByCriteriaInTipoMantenimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoMantenimiento> findPageTipoMantenimiento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoMantenimiento() throws Exception;

	public List<TipoMantenimientoDTO> getDataTipoMantenimiento() throws Exception;

	public List<DatTransProdNivel4> getDatTransProdNivel4() throws Exception;

	public void saveDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	public void deleteDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	public void updateDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	public DatTransProdNivel4 getDatTransProdNivel4(Long datTransProdNivel4Id) throws Exception;

	public List<DatTransProdNivel4> findByCriteriaInDatTransProdNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdNivel4> findPageDatTransProdNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdNivel4() throws Exception;

	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4() throws Exception;

	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4ByNivel4Id(Long datTransProdId) throws Exception;

	public List<ColorIdentProduccion> getColorIdentProduccion() throws Exception;

	public void saveColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	public void deleteColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	public void updateColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	public ColorIdentProduccion getColorIdentProduccion(Long colorIdentProdId) throws Exception;

	public List<ColorIdentProduccion> findByCriteriaInColorIdentProduccion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<ColorIdentProduccion> findPageColorIdentProduccion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberColorIdentProduccion() throws Exception;

	public List<ColorIdentProduccionDTO> getDataColorIdentProduccion() throws Exception;

	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActivByEquipo(Long planRevisionEquipoId)
			throws Exception;

	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipo(Long planRevisionEquipoId)
			throws Exception;

	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProdByProd(Long datMantenimientoEquipoId)
			throws Exception;

	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMecByMec(Long datMantenimientoEquipoId)
			throws Exception;

	public List<Nivel2Persempr> getNivel2Persempr() throws Exception;

	public void saveNivel2Persempr(Nivel2Persempr entity) throws Exception;

	public void deleteNivel2Persempr(Nivel2Persempr entity) throws Exception;

	public void updateNivel2Persempr(Nivel2Persempr entity) throws Exception;

	public Nivel2Persempr getNivel2Persempr(Long id) throws Exception;

	public List<Nivel2Persempr> findByCriteriaInNivel2Persempr(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel2Persempr> findPageNivel2Persempr(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivel2Persempr() throws Exception;

	public List<Nivel2PersemprDTO> getDataNivel2Persempr() throws Exception;

	public List<Nivel2PersemprDTO> getDataNivel2PersemprById(Long id) throws Exception;

	public List<Eventos> getEventos() throws Exception;

	public void saveEventos(Eventos entity) throws Exception;

	public void deleteEventos(Eventos entity) throws Exception;

	public void updateEventos(Eventos entity) throws Exception;

	public Eventos getEventos(Long eventosId) throws Exception;

	public List<Eventos> findByCriteriaInEventos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Eventos> findPageEventos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEventos() throws Exception;

	public List<EventosDTO> getDataEventos() throws Exception;

	public List<Semana> getSemana() throws Exception;

	public void saveSemana(Semana entity) throws Exception;

	public void deleteSemana(Semana entity) throws Exception;

	public void updateSemana(Semana entity) throws Exception;

	public Semana getSemana(Long semanaId) throws Exception;

	public List<Semana> findByCriteriaInSemana(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Semana> findPageSemana(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSemana() throws Exception;

	public List<SemanaDTO> getDataSemana() throws Exception;

	/**** interfaces ***/

	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception;

	/*********************/
	public List<DatProgramaRiego> getDatProgramaRiego() throws Exception;

	public void saveDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception;

	public void deleteDatProgramaRiego(DatProgramaRiego entity) throws Exception;

	public void updateDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception;

	public DatProgramaRiego getDatProgramaRiego(Long datProgramaRiegoId) throws Exception;

	public List<DatProgramaRiego> findByCriteriaInDatProgramaRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatProgramaRiego> findPageDatProgramaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatProgramaRiego() throws Exception;

	public List<DatProgramaRiegoDTO> getDataDatProgramaRiego() throws Exception;

	public List<DatProgramaRiegoDet> getDatProgramaRiegoDet() throws Exception;

	public void saveDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	public void deleteDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	public void updateDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	public DatProgramaRiegoDet getDatProgramaRiegoDet(Long datProgramaRiegoDetId) throws Exception;

	public List<DatProgramaRiegoDet> findByCriteriaInDatProgramaRiegoDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatProgramaRiegoDet> findPageDatProgramaRiegoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatProgramaRiegoDet() throws Exception;

	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDet() throws Exception;

	public List<ProgramaSiembraCosecha> getProgramaSiembraCosecha() throws Exception;

	public void saveProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception;

	public void deleteProgramaSiembraCosecha(ProgramaSiembraCosecha entity) throws Exception;

	public void updateProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception;

	public ProgramaSiembraCosecha getProgramaSiembraCosecha(Long programaSiembraCosechaId) throws Exception;

	public List<ProgramaSiembraCosecha> findByCriteriaInProgramaSiembraCosecha(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<ProgramaSiembraCosecha> findPageProgramaSiembraCosecha(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberProgramaSiembraCosecha() throws Exception;

	public List<ProgramaSiembraCosechaDTO> getDataProgramaSiembraCosecha() throws Exception;

	public List<ProgramaSiembraCosechaDet> getProgramaSiembraCosechaDet() throws Exception;

	public void saveProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	public void deleteProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	public void updateProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	public ProgramaSiembraCosechaDet getProgramaSiembraCosechaDet(Long programaSiembraCosechaDetId) throws Exception;

	public List<ProgramaSiembraCosechaDet> findByCriteriaInProgramaSiembraCosechaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<ProgramaSiembraCosechaDet> findPageProgramaSiembraCosechaDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberProgramaSiembraCosechaDet() throws Exception;

	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDet() throws Exception;

	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDetByPrograma(Long programaDetId)
			throws Exception;

	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDetByPrograma(Long programRiegoDet) throws Exception;

	/********* ACTUALIZACION INFORMES 29-01-2017 ****/

	public List<ProgramacionSiembraCosechaDTO> consultarInformeProgramacionSiembraCosecha(Long compania,
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

	public List<Bascula> getBascula() throws Exception;

	public void saveBascula(Bascula entity) throws Exception;

	public void deleteBascula(Bascula entity) throws Exception;

	public void updateBascula(Bascula entity) throws Exception;

	public Bascula getBascula(Long basculaId) throws Exception;

	public List<Bascula> findByCriteriaInBascula(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Bascula> findPageBascula(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBascula() throws Exception;

	public List<BasculaDTO> getDataBascula() throws Exception;

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

	/******* 14-02-2017 ****/

	public List<DatTransProdTrabajadores> getDatTransProdTrabajadores() throws Exception;

	public void saveDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	public void deleteDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	public void updateDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	public DatTransProdTrabajadores getDatTransProdTrabajadores(Long datTransProdTrabajadoresId) throws Exception;

	public List<DatTransProdTrabajadores> findByCriteriaInDatTransProdTrabajadores(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdTrabajadores> findPageDatTransProdTrabajadores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdTrabajadores() throws Exception;

	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadores() throws Exception;

	public List<DatNominaTrabajador> getDatNominaTrabajador() throws Exception;

	public void saveDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception;

	public void deleteDatNominaTrabajador(DatNominaTrabajador entity) throws Exception;

	public void updateDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception;

	public DatNominaTrabajador getDatNominaTrabajador(Long datNominaTrabajadorId) throws Exception;

	public List<DatNominaTrabajador> findByCriteriaInDatNominaTrabajador(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajador> findPageDatNominaTrabajador(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajador() throws Exception;

	public List<DatNominaTrabajadorDTO> getDataDatNominaTrabajador() throws Exception;

	public List<DatNominaTrabajadorDet> getDatNominaTrabajadorDet() throws Exception;

	public void saveDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	public void deleteDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	public void updateDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	public DatNominaTrabajadorDet getDatNominaTrabajadorDet(Long datNominaTrabajadorDetId) throws Exception;

	public List<DatNominaTrabajadorDet> findByCriteriaInDatNominaTrabajadorDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajadorDet> findPageDatNominaTrabajadorDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajadorDet() throws Exception;

	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDet() throws Exception;

	public List<DatOtrosCostos> getDatOtrosCostos() throws Exception;

	public void saveDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	public void deleteDatOtrosCostos(DatOtrosCostos entity) throws Exception;

	public void updateDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	public DatOtrosCostos getDatOtrosCostos(Long datOtrosCostosId) throws Exception;

	public List<DatOtrosCostos> findByCriteriaInDatOtrosCostos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostos> findPageDatOtrosCostos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostos() throws Exception;

	public List<DatOtrosCostosDTO> getDataDatOtrosCostos() throws Exception;

	public List<DatOtrosCostosNivel4> getDatOtrosCostosNivel4() throws Exception;

	public void saveDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	public void deleteDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	public void updateDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	public DatOtrosCostosNivel4 getDatOtrosCostosNivel4(Long datOtrosCostosNivel4Id) throws Exception;

	public List<DatOtrosCostosNivel4> findByCriteriaInDatOtrosCostosNivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosNivel4> findPageDatOtrosCostosNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosNivel4() throws Exception;

	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4() throws Exception;

	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDetByNomina(Long idNomina) throws Exception;

	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4ByNivel4(Long idOtrosCostos) throws Exception;

	/** 10-03-2017 ***/
	public long consultarConsecutivoOtrosCostos(Long compania) throws Exception;

	public long consultarConsecutivoConsolidadoNomina(Long compania) throws Exception;

	public List<ConsolidadoNominaDTO> consultarConsolidadoNomina(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String contratista, Long flagContratista) throws Exception;

	public List<CostosIndirectosDTO> consultarCostosIndirectos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor, String hacienda, Long flagHacienda,
			String lote, Long flagLote, String ccontable, Long flagCcontable) throws Exception;

	public List<DatPlanLaborDet> getDatPlanLaborDet() throws Exception;

	public void saveDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	public void deleteDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	public void updateDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	public DatPlanLaborDet getDatPlanLaborDet(Long planLaborDetId) throws Exception;

	public List<DatPlanLaborDet> findByCriteriaInDatPlanLaborDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanLaborDet> findPageDatPlanLaborDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanLaborDet() throws Exception;

	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDet() throws Exception;

	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDetByPlan(Long planLaborId) throws Exception;

	/** 18-03-2017 ***/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoEjecucionLabores(Long compania, Long ordenTrabajoDet)
			throws Exception;

	public List<TarifaInfraestructuraDTO> getDataInfraestructuraByTarifaId(Long Id) throws Exception;

	public List<TarifaInfraestructura> getTarifaInfraestructura() throws Exception;

	public void saveTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	public void deleteTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	public void updateTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	public TarifaInfraestructura getTarifaInfraestructura(Long tarInfraId) throws Exception;

	public List<TarifaInfraestructura> findByCriteriaInTarifaInfraestructura(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<TarifaInfraestructura> findPageTarifaInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaInfraestructura() throws Exception;

	public List<TarifaInfraestructuraDTO> getDataTarifaInfraestructura() throws Exception;

	public List<EquipoEvento> getEquipoEvento() throws Exception;

	public void saveEquipoEvento(EquipoEvento entity) throws Exception;

	public void deleteEquipoEvento(EquipoEvento entity) throws Exception;

	public void updateEquipoEvento(EquipoEvento entity) throws Exception;

	public EquipoEvento getEquipoEvento(Long id) throws Exception;

	public List<EquipoEvento> findByCriteriaInEquipoEvento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EquipoEvento> findPageEquipoEvento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEquipoEvento() throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEvento() throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoId(Long equipoId) throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoIdCompaniaId(Long equipoId, Long compania) throws Exception;

	/***** PRESUPUESTO ****/
	public List<LaborRecursos> getLaborRecursos() throws Exception;

	public void saveLaborRecursos(LaborRecursos entity) throws Exception;

	public void deleteLaborRecursos(LaborRecursos entity) throws Exception;

	public void updateLaborRecursos(LaborRecursos entity) throws Exception;

	public LaborRecursos getLaborRecursos(Long laborRecursosId) throws Exception;

	public List<LaborRecursos> findByCriteriaInLaborRecursos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborRecursos> findPageLaborRecursos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborRecursos() throws Exception;

	public List<LaborRecursosDTO> getDataLaborRecursos() throws Exception;

	public List<TipoRecursosEquipos> getTipoRecursosEquipos() throws Exception;

	public void saveTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	public void deleteTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	public void updateTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	public TipoRecursosEquipos getTipoRecursosEquipos(Long tipoRecursosEquiposId) throws Exception;

	public List<TipoRecursosEquipos> findByCriteriaInTipoRecursosEquipos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosEquipos> findPageTipoRecursosEquipos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosEquipos() throws Exception;

	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquipos() throws Exception;

	public List<TipoRecursosInsumos> getTipoRecursosInsumos() throws Exception;

	public void saveTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	public void deleteTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	public void updateTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	public TipoRecursosInsumos getTipoRecursosInsumos(Long tipoRecursosInsumosId) throws Exception;

	public List<TipoRecursosInsumos> findByCriteriaInTipoRecursosInsumos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosInsumos> findPageTipoRecursosInsumos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosInsumos() throws Exception;

	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumos() throws Exception;

	public List<TipoRecursosOtros> getTipoRecursosOtros() throws Exception;

	public void saveTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	public void deleteTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	public void updateTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	public TipoRecursosOtros getTipoRecursosOtros(Long tipoRecursosOtrosId) throws Exception;

	public List<TipoRecursosOtros> findByCriteriaInTipoRecursosOtros(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosOtros> findPageTipoRecursosOtros(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosOtros() throws Exception;

	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtros() throws Exception;

	public List<TipoRecursosProfesion> getTipoRecursosProfesion() throws Exception;

	public void saveTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	public void deleteTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	public void updateTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	public TipoRecursosProfesion getTipoRecursosProfesion(Long tipoRecursosProfesionId) throws Exception;

	public List<TipoRecursosProfesion> findByCriteriaInTipoRecursosProfesion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosProfesion> findPageTipoRecursosProfesion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosProfesion() throws Exception;

	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesion() throws Exception;

	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesionByProfesion(Long tipoRecursosProfesionId)
			throws Exception;

	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquiposByEquipos(Long tipoRecursosEquiposId)
			throws Exception;

	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumosByInsumos(Long tipoRecursosInsumosId)
			throws Exception;

	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtrosByOtros(Long tipoRecursosOtrosId) throws Exception;

	public List<LaborRecursosDTO> getDataLaborRecursosByLabor(Long laborRecursosId) throws Exception;

	/** 02-06-2017 PRESUPUESTO **/

	public List<ListadoRecursosDTO> consultaListadoRecursos(Long tipoRecursoId) throws Exception;

	/** 01-07_2017 **/
	public List<ValorVarDTO> getDataValorVarByValor(Long datSanVegId) throws Exception;

	public List<AnalisisEnfermedadVer2DTO> consultarAnalisisEnfermedadVer2(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception;

	public List<AnalisisPlagaVer2DTO> consultarAnalisisPlagaVer2(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String plaga, Long flagPlaga) throws Exception;

	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipoId(Long equipoId) throws Exception;

	public List<Tag> getTag() throws Exception;

	public void saveTag(Tag entity) throws Exception;

	public void deleteTag(Tag entity) throws Exception;

	public void updateTag(Tag entity) throws Exception;

	public Tag getTag(Long tagId) throws Exception;

	public List<Tag> findByCriteriaInTag(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Tag> findPageTag(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTag() throws Exception;

	public List<TagDTO> getDataTag() throws Exception;

	public List<ZonasFabrica> getZonasFabrica() throws Exception;

	public void saveZonasFabrica(ZonasFabrica entity) throws Exception;

	public void deleteZonasFabrica(ZonasFabrica entity) throws Exception;

	public void updateZonasFabrica(ZonasFabrica entity) throws Exception;

	public ZonasFabrica getZonasFabrica(Long zonasFabricaId) throws Exception;

	public List<ZonasFabrica> findByCriteriaInZonasFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ZonasFabrica> findPageZonasFabrica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberZonasFabrica() throws Exception;

	public List<ZonasFabricaDTO> getDataZonasFabrica() throws Exception;

	public List<DatOtrosCostosMq> getDatOtrosCostosMq() throws Exception;

	public void saveDatOtrosCostosMq(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr) throws Exception;

	public void deleteDatOtrosCostosMq(DatOtrosCostosMq entity) throws Exception;

	public void updateDatOtrosCostosMq(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr) throws Exception;

	public DatOtrosCostosMq getDatOtrosCostosMq(Long datOtrosCostosMqId) throws Exception;

	public List<DatOtrosCostosMq> findByCriteriaInDatOtrosCostosMq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosMq> findPageDatOtrosCostosMq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosMq() throws Exception;

	public List<DatOtrosCostosMqDTO> getDataDatOtrosCostosMq() throws Exception;

	public List<DatOtrosCostosMqdet> getDatOtrosCostosMqdet() throws Exception;

	public void saveDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception;

	public void deleteDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception;

	public void updateDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception;

	public DatOtrosCostosMqdet getDatOtrosCostosMqdet(Long datOtrosCostosMqdetId) throws Exception;

	public List<DatOtrosCostosMqdet> findByCriteriaInDatOtrosCostosMqdet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosMqdet> findPageDatOtrosCostosMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosMqdet() throws Exception;

	public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdet() throws Exception;

	public List<CostosInsumosDetalladoDTO> consultarInformeCostosInsumosDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, Long numPlanilla) throws Exception;

	public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdetByMaquinaria(Long idOtrosCostosMq) throws Exception;

	public List<ConsultaEventosPorPagarDTO> consultarEventosPorPagar(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String propietario, Long flagPropietario, String evento, Long flagEvento)
			throws Exception;

	public long consultarConsecutivoOtrosCostosMq(Long compania) throws Exception;

	public List<DatHorasTrabajoEquipo> getDatHorasTrabajoEquipo() throws Exception;

	public void saveDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception;

	public void deleteDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception;

	public void updateDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception;

	public DatHorasTrabajoEquipo getDatHorasTrabajoEquipo(Long datHorasTrabajoEquipoId) throws Exception;

	public List<DatHorasTrabajoEquipo> findByCriteriaInDatHorasTrabajoEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatHorasTrabajoEquipo> findPageDatHorasTrabajoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatHorasTrabajoEquipo() throws Exception;

	public List<DatHorasTrabajoEquipoDTO> getDataDatHorasTrabajoEquipo(String modulo) throws Exception;

	public List<DatRiegoDTO> getDataDatRiegoByPlanillaNomina(Long planillaNominaId) throws Exception;

	public List<DatServicioDetDTO> getDataDatServicioDetByPlanillaNomina(Long planillaNominaId) throws Exception;

	public List<DatAplicProdDetDTO> getDataDetProductosByPlanillaNomina(Long planillaNominaId) throws Exception;

	public List<DatServRealizadosEquipo> getDatServRealizadosEquipo() throws Exception;

	public void saveDatServRealizadosEquipo(DatServRealizadosEquipo entity,
			List<DatServRealizadosEquipoDetDTO> dataServDet, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception;

	public void deleteDatServRealizadosEquipo(DatServRealizadosEquipo entity) throws Exception;

	public void updateDatServRealizadosEquipo(DatServRealizadosEquipo entity,
			List<DatServRealizadosEquipoDetDTO> dataServDet, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception;

	public DatServRealizadosEquipo getDatServRealizadosEquipo(Long datServRealizadosEquipoId) throws Exception;

	public List<DatServRealizadosEquipo> findByCriteriaInDatServRealizadosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatServRealizadosEquipo> findPageDatServRealizadosEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatServRealizadosEquipo() throws Exception;

	public List<DatServRealizadosEquipoDTO> getDataDatServRealizadosEquipo() throws Exception;

	public List<DatServRealizadosEquipoDet> getDatServRealizadosEquipoDet() throws Exception;

	public void saveDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception;

	public void deleteDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception;

	public void updateDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception;

	public DatServRealizadosEquipoDet getDatServRealizadosEquipoDet(Long datServRealizadosEquipoDetId) throws Exception;

	public List<DatServRealizadosEquipoDet> findByCriteriaInDatServRealizadosEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatServRealizadosEquipoDet> findPageDatServRealizadosEquipoDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatServRealizadosEquipoDet() throws Exception;

	public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDet() throws Exception;

	public List<CompartimientosEquipo> getCompartimientosEquipo() throws Exception;

	public void saveCompartimientosEquipo(CompartimientosEquipo entity) throws Exception;

	public void deleteCompartimientosEquipo(CompartimientosEquipo entity) throws Exception;

	public void updateCompartimientosEquipo(CompartimientosEquipo entity) throws Exception;

	public CompartimientosEquipo getCompartimientosEquipo(Long compartimientosEquipoId) throws Exception;

	public List<CompartimientosEquipo> findByCriteriaInCompartimientosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<CompartimientosEquipo> findPageCompartimientosEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCompartimientosEquipo() throws Exception;

	public List<CompartimientosEquipoDTO> getDataCompartimientosEquipo() throws Exception;

	public List<SistemasEquipo> getSistemasEquipo() throws Exception;

	public void saveSistemasEquipo(SistemasEquipo entity) throws Exception;

	public void deleteSistemasEquipo(SistemasEquipo entity) throws Exception;

	public void updateSistemasEquipo(SistemasEquipo entity) throws Exception;

	public SistemasEquipo getSistemasEquipo(Long sistemasEquipoId) throws Exception;

	public List<SistemasEquipo> findByCriteriaInSistemasEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SistemasEquipo> findPageSistemasEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSistemasEquipo() throws Exception;

	public List<SistemasEquipoDTO> getDataSistemasEquipo() throws Exception;

	public List<DatReporteFallas> getDatReporteFallas() throws Exception;

	public void saveDatReporteFallas(DatReporteFallas entity) throws Exception;

	public void deleteDatReporteFallas(DatReporteFallas entity) throws Exception;

	public void updateDatReporteFallas(DatReporteFallas entity) throws Exception;

	public DatReporteFallas getDatReporteFallas(Long datReporteFallasId) throws Exception;

	public List<DatReporteFallas> findByCriteriaInDatReporteFallas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatReporteFallas> findPageDatReporteFallas(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatReporteFallas() throws Exception;

	public List<DatReporteFallasDTO> getDataDatReporteFallas(String modulo) throws Exception;

	public List<DatPlanAnualFabrica> getDatPlanAnualFabrica() throws Exception;

	public void saveDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception;

	public void deleteDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception;

	public void updateDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception;

	public DatPlanAnualFabrica getDatPlanAnualFabrica(Long datPlanAnualFabricaId) throws Exception;

	public List<DatPlanAnualFabrica> findByCriteriaInDatPlanAnualFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanAnualFabrica> findPageDatPlanAnualFabrica(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanAnualFabrica() throws Exception;

	public List<DatPlanAnualFabricaDTO> getDataDatPlanAnualFabrica() throws Exception;

	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) throws Exception;

	public long consultarConsecutivoRegistroHorasEquipo(Long compania) throws Exception;

	public long consultarConsecutivoPlanAnualFabrica(Long compania) throws Exception;

	public long consultarConsecutivoCheckListEquipo(Long compania) throws Exception;

	public long consultarConsecutivoReporteFallasEquipo(Long compania) throws Exception;

	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String labor, Long flagLabor) throws Exception;

	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote) throws Exception;;

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

	long consultarConsecutivoDatSolicitudesMtto(Long compania) throws Exception;

	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception;

	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid, Long planrevisionid,
			Double horasmtto, Double kmmtto) throws Exception;

	/*********
	 * 14-02-2018
	 * 
	 * @throws Exception
	 ***/
	public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDetByServ(Long datServId) throws Exception;

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

	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto) throws Exception;

	public List<DatPlanillaNominaOnivel4> getDatPlanillaNominaOnivel4() throws Exception;

	public void saveDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception;

	public void deleteDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception;

	public void updateDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception;

	public DatPlanillaNominaOnivel4 getDatPlanillaNominaOnivel4(Long detPlanillaNominaOnivel4Id) throws Exception;

	public List<DatPlanillaNominaOnivel4> findByCriteriaInDatPlanillaNominaOnivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanillaNominaOnivel4> findPageDatPlanillaNominaOnivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanillaNominaOnivel4() throws Exception;

	public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4() throws Exception;

	public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4ByNomina(Long planillaNominaId)
			throws Exception;

	public List<DatParadasFabrica> getDatParadasFabrica() throws Exception;

	public void saveDatParadasFabrica(DatParadasFabrica entity) throws Exception;

	public void deleteDatParadasFabrica(DatParadasFabrica entity) throws Exception;

	public void updateDatParadasFabrica(DatParadasFabrica entity) throws Exception;

	public DatParadasFabrica getDatParadasFabrica(Long datParadasFabricaId) throws Exception;

	public List<DatParadasFabrica> findByCriteriaInDatParadasFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatParadasFabrica> findPageDatParadasFabrica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatParadasFabrica() throws Exception;

	public List<DatParadasFabricaDTO> getDataDatParadasFabrica() throws Exception;

	public List<PlanRevisionEquipoRecursos> getPlanRevisionEquipoRecursos() throws Exception;

	public void savePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception;

	public void deletePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception;

	public void updatePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception;

	public PlanRevisionEquipoRecursos getPlanRevisionEquipoRecursos(Long planRevisionEquipoRecursosId) throws Exception;

	public List<PlanRevisionEquipoRecursos> findByCriteriaInPlanRevisionEquipoRecursos(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipoRecursos> findPagePlanRevisionEquipoRecursos(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipoRecursos() throws Exception;

	public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursos() throws Exception;

	public long consultarConsecutivoParadasFabrica(Long compania) throws Exception;

	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tag, Long flagTag) throws Exception;

	public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursosByRecursos(Long equipoRcursosId)
			throws Exception;

	/** 20-032018 **/
	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadoresByTrabajador(Long datTransProdId)
			throws Exception;

	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) throws Exception;

	public List<AnaLaboratorio> getAnaLaboratorio() throws Exception;

	public void saveAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
			throws Exception;

	public void deleteAnaLaboratorio(AnaLaboratorio entity) throws Exception;

	public void updateAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
			throws Exception;

	public AnaLaboratorio getAnaLaboratorio(Long anaLabId) throws Exception;

	public List<AnaLaboratorio> findByCriteriaInAnaLaboratorio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnaLaboratorio> findPageAnaLaboratorio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnaLaboratorio() throws Exception;

	public List<AnaLaboratorioDTO> getDataAnaLaboratorio() throws Exception;

	public List<AnaLaboratorioVariable> getAnaLaboratorioVariable() throws Exception;

	public void saveAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception;

	public void deleteAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception;

	public void updateAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception;

	public AnaLaboratorioVariable getAnaLaboratorioVariable(Long anaLaboratorioVariableId) throws Exception;

	public List<AnaLaboratorioVariable> findByCriteriaInAnaLaboratorioVariable(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<AnaLaboratorioVariable> findPageAnaLaboratorioVariable(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberAnaLaboratorioVariable() throws Exception;

	public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariable() throws Exception;

	public List<DatAnaLaboratorio> getDatAnaLaboratorio() throws Exception;

	public void saveDatAnaLaboratorio(DatAnaLaboratorio entity,
			List<ListaVariablesAnaLaboratorioDTO> dataAnalisisLabDet) throws Exception;

	public void deleteDatAnaLaboratorio(DatAnaLaboratorio entity) throws Exception;

	public void updateDatAnaLaboratorio(DatAnaLaboratorio entity, List<DatAnaLaboratorioDetDTO> dataAnalisisLabDet,
			List<ListaVariablesAnaLaboratorioDTO> dataVariables) throws Exception;

	public DatAnaLaboratorio getDatAnaLaboratorio(Long datAnaLabId) throws Exception;

	public List<DatAnaLaboratorio> findByCriteriaInDatAnaLaboratorio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAnaLaboratorio> findPageDatAnaLaboratorio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAnaLaboratorio() throws Exception;

	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorio() throws Exception;

	public List<DatAnaLaboratorioDet> getDatAnaLaboratorioDet() throws Exception;

	public void saveDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception;

	public void deleteDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception;

	public void updateDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception;

	public DatAnaLaboratorioDet getDatAnaLaboratorioDet(Long datAnaLaboratorioDetId) throws Exception;

	public List<DatAnaLaboratorioDet> findByCriteriaInDatAnaLaboratorioDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatAnaLaboratorioDet> findPageDatAnaLaboratorioDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatAnaLaboratorioDet() throws Exception;

	public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDet() throws Exception;

	public List<VariableLab> getVariableLab() throws Exception;

	public void saveVariableLab(VariableLab entity) throws Exception;

	public void deleteVariableLab(VariableLab entity) throws Exception;

	public void updateVariableLab(VariableLab entity) throws Exception;

	public VariableLab getVariableLab(Long variableLabId) throws Exception;

	public List<VariableLab> findByCriteriaInVariableLab(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<VariableLab> findPageVariableLab(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberVariableLab() throws Exception;

	public List<VariableLabDTO> getDataVariableLab() throws Exception;

	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis)
			throws Exception;

	public long consultarIdUnicoDatSanVeg(Long compania) throws Exception;

	public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariableByVariable(Long idAnalisis) throws Exception;

	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania) throws Exception;

	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) throws Exception;

	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania, Long tipoAnalisis)
			throws Exception;

	public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDetByAnalisis(Long idDatAnaLaboratorio)
			throws Exception;

	public List<LogBascula> getLogBascula() throws Exception;

	public void saveLogBascula(LogBascula entity) throws Exception;

	public void deleteLogBascula(LogBascula entity) throws Exception;

	public void updateLogBascula(LogBascula entity) throws Exception;

	public LogBascula getLogBascula(Long logBasculaId) throws Exception;

	public List<LogBascula> findByCriteriaInLogBascula(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LogBascula> findPageLogBascula(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLogBascula() throws Exception;

	public List<LogBasculaDTO> getDataLogBascula() throws Exception;

	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorioByTipoAnalisis(Long idAnalisis) throws Exception;

	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania)
			throws Exception;

	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(
			Long compania, Long tiquete) throws Exception;

	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis) throws Exception;

	// public long consultarConsec_dat_pluvio(Long compania) throws Exception;
	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) throws Exception;

	public double calcularHoras(Date fechaFinal, Date fechaInicial) throws Exception;

	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) throws Exception;

	public void saveDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	public void updateDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) throws Exception;

	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String trabajador, Long flagTrabajador,
			String conceptonomina, Long flagconceptonomina) throws Exception;

	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania,
			Date fechaInicial, Date fechaFinal, String contratista, Long flagContratista, String trabajador,
			Long flagTrabajador, String conceptonomina, Long flagconceptonomina) throws Exception;

	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet) throws Exception;

	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet) throws Exception;

	/**** Consulta orden de trabajo aprobacion *****/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) throws Exception;

	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) throws Exception;

	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

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

	public List<DatNominaTrabajadorMq> getDatNominaTrabajadorMq() throws Exception;

	public void saveDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador) throws Exception;

	public void deleteDatNominaTrabajadorMq(DatNominaTrabajadorMq entity) throws Exception;

	public void updateDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador) throws Exception;

	public DatNominaTrabajadorMq getDatNominaTrabajadorMq(Long datNominaTrabajadorMqId) throws Exception;

	public List<DatNominaTrabajadorMq> findByCriteriaInDatNominaTrabajadorMq(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajadorMq> findPageDatNominaTrabajadorMq(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajadorMq() throws Exception;

	public List<DatNominaTrabajadorMqDTO> getDataDatNominaTrabajadorMq() throws Exception;

	public List<DatNominaTrabajadorMqdet> getDatNominaTrabajadorMqdet() throws Exception;

	public void saveDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception;

	public void deleteDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception;

	public void updateDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception;

	public DatNominaTrabajadorMqdet getDatNominaTrabajadorMqdet(Long datNominaTrabajadorMqdetId) throws Exception;

	public List<DatNominaTrabajadorMqdet> findByCriteriaInDatNominaTrabajadorMqdet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajadorMqdet> findPageDatNominaTrabajadorMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajadorMqdet() throws Exception;

	public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdet() throws Exception;

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

	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto)
			throws Exception;

	public long consultarUltimaPlanillaNomina(Long compania, Date fecha) throws Exception;
	public List<DatServicioDet> findByCriteriaInDatServicioDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;
	
	
}
