package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatHorasTrabajoEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoMecDAO;
import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoPlanRevisionDAO;
import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.DatMantenimientoEquipoPlanRevision;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoPlanRevisionDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatMantenimientoEquipoLogic")
public class DatMantenimientoEquipoLogic implements IDatMantenimientoEquipoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoLogic.class);

	/**
	 * DAO injected by Spring that manages DatMantenimientoEquipo entities
	 *
	 */
	@Autowired
	private IDatMantenimientoEquipoDAO datMantenimientoEquipoDAO;

	/**
	 * DAO injected by Spring that manages DatMantenimientoEquipoMec entities
	 *
	 */
	@Autowired
	private IDatMantenimientoEquipoMecDAO datMantenimientoEquipoMecDAO;

	/**
	 * DAO injected by Spring that manages DatMantenimientoEquipoProd entities
	 *
	 */
	@Autowired
	private IDatMantenimientoEquipoProdDAO datMantenimientoEquipoProdDAO;

	/**
	 * Logic injected by Spring that manages AgenteCausadorParada entities
	 *
	 */
	@Autowired
	IAgenteCausadorParadaLogic logicAgenteCausadorParada1;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost2;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo3;

	/**
	 * Logic injected by Spring that manages MotivosEntradaTaller entities
	 *
	 */
	@Autowired
	IMotivosEntradaTallerLogic logicMotivosEntradaTaller4;

	/**
	 * Logic injected by Spring that manages PlanRevisionEquipo entities
	 *
	 */
	@Autowired
	IPlanRevisionEquipoLogic logicPlanRevisionEquipo5;

	@Autowired
	IPlanRevisionEquipoDetLogic logicPlanRevisionEquipoDetLogic;

	/**
	 * Logic injected by Spring that manages TallerMecanico entities
	 *
	 */
	@Autowired
	ITallerMecanicoLogic logicTallerMecanico6;

	/**
	 * Logic injected by Spring that manages TipoMantenimiento entities
	 *
	 */
	@Autowired
	ITipoMantenimientoLogic logicTipoMantenimiento7;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador8;

	@Autowired
	IEquipoEventoLogic logicEquipo;

	@Autowired
	private IDatHorasTrabajoEquipoDAO datHorasTrabajoEquipoDAO;

	@Autowired
	private IDatMantenimientoEquipoPlanRevisionDAO datMantenimientoEquipoPlanRevisionDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DatMantenimientoEquipo> getDatMantenimientoEquipo() throws Exception {
		log.debug("finding all DatMantenimientoEquipo instances");

		List<DatMantenimientoEquipo> list = new ArrayList<DatMantenimientoEquipo>();

		try {
			list = datMantenimientoEquipoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatMantenimientoEquipo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatMantenimientoEquipo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatMantenimientoEquipo(DatMantenimientoEquipo entity,
			List<DatMantenimientoEquipoMecDTO> DataEquipoMec, List<DatMantenimientoEquipoProdDTO> DataEquipoProd,
			List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision, DatHorasTrabajoEquipo entity_hrt)
			throws Exception {
		log.debug("saving DatMantenimientoEquipo instance");

		try {

			datMantenimientoEquipoDAO.save(entity);

			if (DataEquipoMec != null) {

				for (DatMantenimientoEquipoMecDTO valorDto : DataEquipoMec) {

					if (valorDto.getDatMantenimientoEquipoMecId() == null) {

						DatMantenimientoEquipoMec valor = new DatMantenimientoEquipoMec();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setCompartimientosEquipo(valorDto.getCompartimiento());
						valor.setSistemasEquipo(valorDto.getSistema());
						valor.setHoraIniMec(valorDto.getHoraIniMec());
						valor.setHoraFinMec(valorDto.getHoraFinMec());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTipoPersonal(valorDto.getTipoPersonal());
						valor.setObservacion(valorDto.getObservacion());
						valor.setNumFactura(valorDto.getNumFactura());
						valor.setDatMantenimientoEquipo(entity);

						datMantenimientoEquipoMecDAO.save(valor);
					}

				}
			}
			if (DataEquipoProd != null) {

				for (DatMantenimientoEquipoProdDTO valorDto : DataEquipoProd) {

					if (valorDto.getDatMantenimientoEquipoProdId() == null) {

						DatMantenimientoEquipoProd valor = new DatMantenimientoEquipoProd();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setTipoSuministro(valorDto.getTipoSuministro());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setPendienteImportacion(valorDto.getPendienteImportacion());
						valor.setDatMantenimientoEquipo(entity);
						valor.setDescargaInventario(valorDto.getDescargaInventario());
						datMantenimientoEquipoProdDAO.save(valor);
					}

				}
			}

			if (dataPlanRevision != null) {

				for (DatMantenimientoEquipoPlanRevisionDTO valorDto : dataPlanRevision) {

					if (valorDto.getDatManPlanRevivionId() == null) {

						DatMantenimientoEquipoPlanRevision valor = new DatMantenimientoEquipoPlanRevision();

						valor.setPlanRevisionEquipo(valorDto.getPlanRevisionEquipoId_PlanRevisionEquipo());

						valor.setDatMantenimientoEquipo(entity);

						datMantenimientoEquipoPlanRevisionDAO.save(valor);
					}

				}
			}

			if (entity_hrt != null) {

				datHorasTrabajoEquipoDAO.save(entity_hrt);

			}

			log.debug("save DatMantenimientoEquipo successful");
		} catch (Exception e) {
			log.error("save DatMantenimientoEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatMantenimientoEquipo(DatMantenimientoEquipo entity) throws Exception {
		log.debug("deleting DatMantenimientoEquipo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatMantenimientoEquipo");
		}

		if (entity.getDatMantenimientoEquipoId() == null) {
			throw new ZMessManager().new EmptyFieldException("datMantenimientoEquipoId");
		}

		List<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs = null;
		List<DatMantenimientoEquipoProd> datMantenimientoEquipoProds = null;

		try {
			datMantenimientoEquipoMecs = datMantenimientoEquipoMecDAO.findByProperty(
					"datMantenimientoEquipo.datMantenimientoEquipoId", entity.getDatMantenimientoEquipoId());

			if (Utilities.validationsList(datMantenimientoEquipoMecs) == true) {
				throw new ZMessManager().new DeletingException("datMantenimientoEquipoMecs");
			}

			datMantenimientoEquipoProds = datMantenimientoEquipoProdDAO.findByProperty(
					"datMantenimientoEquipo.datMantenimientoEquipoId", entity.getDatMantenimientoEquipoId());

			if (Utilities.validationsList(datMantenimientoEquipoProds) == true) {
				throw new ZMessManager().new DeletingException("datMantenimientoEquipoProds");
			}

			datMantenimientoEquipoDAO.delete(entity);

			log.debug("delete DatMantenimientoEquipo successful");
		} catch (Exception e) {
			log.error("delete DatMantenimientoEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatMantenimientoEquipo(DatMantenimientoEquipo entity,
			List<DatMantenimientoEquipoMecDTO> DataEquipoMec, List<DatMantenimientoEquipoProdDTO> DataEquipoProd,
			List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision) throws Exception {
		log.debug("updating DatMantenimientoEquipo instance");

		try {

			datMantenimientoEquipoDAO.update(entity);

			if (DataEquipoMec != null) {
				for (DatMantenimientoEquipoMecDTO valorDto : DataEquipoMec) {

					if (valorDto.getDatMantenimientoEquipoMecId() == null) {

						DatMantenimientoEquipoMec valor = new DatMantenimientoEquipoMec();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setHoraIniMec(valorDto.getHoraIniMec());
						valor.setHoraFinMec(valorDto.getHoraFinMec());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTipoPersonal(valorDto.getTipoPersonal());
						valor.setNumFactura(valorDto.getNumFactura());
						valor.setDatMantenimientoEquipo(entity);
						valor.setObservacion(valorDto.getObservacion());
						datMantenimientoEquipoMecDAO.save(valor);
					} else {
						DatMantenimientoEquipoMec valor = datMantenimientoEquipoMecDAO
								.findById(valorDto.getDatMantenimientoEquipoMecId());

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setHoraIniMec(valorDto.getHoraIniMec());
						valor.setHoraFinMec(valorDto.getHoraFinMec());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTipoPersonal(valorDto.getTipoPersonal());
						valor.setNumFactura(valorDto.getNumFactura());
						valor.setDatMantenimientoEquipo(entity);
						valor.setObservacion(valorDto.getObservacion());
						datMantenimientoEquipoMecDAO.update(valor);
					}

				}
			}

			if (DataEquipoProd != null) {
				for (DatMantenimientoEquipoProdDTO valorDto : DataEquipoProd) {

					if (valorDto.getDatMantenimientoEquipoProdId() == null) {

						DatMantenimientoEquipoProd valor = new DatMantenimientoEquipoProd();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setTipoSuministro(valorDto.getTipoSuministro());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setPendienteImportacion(valorDto.getPendienteImportacion());
						valor.setDatMantenimientoEquipo(entity);

						valor.setDescargaInventario(valorDto.getDescargaInventario());
						datMantenimientoEquipoProdDAO.save(valor);
					} else {
						DatMantenimientoEquipoProd valor = datMantenimientoEquipoProdDAO
								.findById(valorDto.getDatMantenimientoEquipoProdId());

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setTipoSuministro(valorDto.getTipoSuministro());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setFechaRegistro(valorDto.getFechaRegistro());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setPendienteImportacion(valorDto.getPendienteImportacion());
						valor.setDatMantenimientoEquipo(entity);

						valor.setDescargaInventario(valorDto.getDescargaInventario());
						datMantenimientoEquipoProdDAO.update(valor);
					}
				}
			}

			if (dataPlanRevision != null) {

				for (DatMantenimientoEquipoPlanRevisionDTO valorDto : dataPlanRevision) {

					if (valorDto.getDatManPlanRevivionId() == null) {

						DatMantenimientoEquipoPlanRevision valor = new DatMantenimientoEquipoPlanRevision();

						valor.setPlanRevisionEquipo(valorDto.getPlanRevisionEquipoId_PlanRevisionEquipo());

						valor.setDatMantenimientoEquipo(entity);

						datMantenimientoEquipoPlanRevisionDAO.save(valor);
					}

				}
			}

			if (dataPlanRevision != null) {
				for (DatMantenimientoEquipoPlanRevisionDTO valorDto : dataPlanRevision) {

					if (valorDto.getDatManPlanRevivionId() == null) {

						DatMantenimientoEquipoPlanRevision valor = new DatMantenimientoEquipoPlanRevision();
						valor.setPlanRevisionEquipo(valorDto.getPlanRevisionEquipoId_PlanRevisionEquipo());

						valor.setDatMantenimientoEquipo(entity);

						datMantenimientoEquipoPlanRevisionDAO.save(valor);
					} else {
						DatMantenimientoEquipoPlanRevision valor = datMantenimientoEquipoPlanRevisionDAO
								.findById(valorDto.getDatManPlanRevivionId());

						valor.setPlanRevisionEquipo(valorDto.getPlanRevisionEquipoId_PlanRevisionEquipo());

						valor.setDatMantenimientoEquipo(entity);

						datMantenimientoEquipoPlanRevisionDAO.update(valor);
					}
				}
			}

			log.debug("update DatMantenimientoEquipo successful");
		} catch (Exception e) {
			log.error("update DatMantenimientoEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatMantenimientoEquipoDTO> getDataDatMantenimientoEquipo(String modulo) throws Exception {
		try {

			List<DatMantenimientoEquipo> datMantenimientoEquipo = datMantenimientoEquipoDAO
					.findByCriteria("origenDatos = " + "'" + modulo + "'");

			List<DatMantenimientoEquipoDTO> datMantenimientoEquipoDTO = new ArrayList<DatMantenimientoEquipoDTO>();

			for (DatMantenimientoEquipo datMantenimientoEquipoTmp : datMantenimientoEquipo) {

				DatMantenimientoEquipoDTO datMantenimientoEquipoDTO2 = new DatMantenimientoEquipoDTO();

				datMantenimientoEquipoDTO2
						.setDatMantenimientoEquipoId(datMantenimientoEquipoTmp.getDatMantenimientoEquipoId());
				datMantenimientoEquipoDTO2.setCierreOt(
						(datMantenimientoEquipoTmp.getCierreOt() != null) ? datMantenimientoEquipoTmp.getCierreOt()
								: null);
				datMantenimientoEquipoDTO2.setCompania(
						(datMantenimientoEquipoTmp.getCompania() != null) ? datMantenimientoEquipoTmp.getCompania()
								: null);
				datMantenimientoEquipoDTO2.setConductor(
						(datMantenimientoEquipoTmp.getConductor() != null) ? datMantenimientoEquipoTmp.getConductor()
								: null);
				datMantenimientoEquipoDTO2.setConsecutivo((datMantenimientoEquipoTmp.getConsecutivo() != null)
						? datMantenimientoEquipoTmp.getConsecutivo()
						: null);
				datMantenimientoEquipoDTO2.setDuracion(datMantenimientoEquipoTmp.getDuracion());
				datMantenimientoEquipoDTO2.setEstado(
						(datMantenimientoEquipoTmp.getEstado() != null) ? datMantenimientoEquipoTmp.getEstado() : null);
				datMantenimientoEquipoDTO2.setFechaAnulacion(datMantenimientoEquipoTmp.getFechaAnulacion());
				datMantenimientoEquipoDTO2.setFechaCierreOt(datMantenimientoEquipoTmp.getFechaCierreOt());
				datMantenimientoEquipoDTO2.setFechaCreacion(datMantenimientoEquipoTmp.getFechaCreacion());
				datMantenimientoEquipoDTO2.setFechaEntradaTaller(datMantenimientoEquipoTmp.getFechaEntradaTaller());
				datMantenimientoEquipoDTO2.setFechaModificacion(datMantenimientoEquipoTmp.getFechaModificacion());
				datMantenimientoEquipoDTO2.setFechaReaperturaOt(datMantenimientoEquipoTmp.getFechaReaperturaOt());

				datMantenimientoEquipoDTO2
						.setObservacionAnularReg((datMantenimientoEquipoTmp.getObservacionAnularReg() != null)
								? datMantenimientoEquipoTmp.getObservacionAnularReg()
								: null);

				datMantenimientoEquipoDTO2.setOrderTrabajo((datMantenimientoEquipoTmp.getOrderTrabajo() != null)
						? datMantenimientoEquipoTmp.getOrderTrabajo()
						: null);

				datMantenimientoEquipoDTO2.setReporteTecnico((datMantenimientoEquipoTmp.getReporteTecnico() != null)
						? datMantenimientoEquipoTmp.getReporteTecnico()
						: null);

				datMantenimientoEquipoDTO2
						.setUsuarioDigitacion((datMantenimientoEquipoTmp.getUsuarioDigitacion() != null)
								? datMantenimientoEquipoTmp.getUsuarioDigitacion()
								: null);

				datMantenimientoEquipoDTO2.setVidaHoras(
						(datMantenimientoEquipoTmp.getVidaHoras() != null) ? datMantenimientoEquipoTmp.getVidaHoras()
								: null);

				datMantenimientoEquipoDTO2.setVidaKm(
						(datMantenimientoEquipoTmp.getVidaKm() != null) ? datMantenimientoEquipoTmp.getVidaKm() : null);

				datMantenimientoEquipoDTO2.setAgenteCausadorParadaId_AgenteCausadorParada(
						(datMantenimientoEquipoTmp.getAgenteCausadorParada() != null)
								? datMantenimientoEquipoTmp.getAgenteCausadorParada().getAgenteCausadorParadaId()
								: null);
				datMantenimientoEquipoDTO2.setCentCostId_CentCost((datMantenimientoEquipoTmp.getCentCost() != null)
						? datMantenimientoEquipoTmp.getCentCost().getCentCostId()
						: null);

				if (datMantenimientoEquipoTmp.getEquipo() != null) {
					datMantenimientoEquipoDTO2.setEquipoId_Equipo(datMantenimientoEquipoTmp.getEquipo());
				} else {
					datMantenimientoEquipoDTO2.setEquipoId_Equipo(null);
				}

				datMantenimientoEquipoDTO2.setVidaDias(
						(datMantenimientoEquipoTmp.getVidaDias() != null) ? datMantenimientoEquipoTmp.getVidaDias()
								: null);

				datMantenimientoEquipoDTO2.setMotivosEntradaTallerId_MotivosEntradaTaller(
						(datMantenimientoEquipoTmp.getMotivosEntradaTaller() != null)
								? datMantenimientoEquipoTmp.getMotivosEntradaTaller().getMotivosEntradaTallerId()
								: null);

				if (datMantenimientoEquipoTmp.getPlanRevisionEquipo() != null) {
					datMantenimientoEquipoDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(
							datMantenimientoEquipoTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId());
				} else {
					datMantenimientoEquipoDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(null);
				}

				if (datMantenimientoEquipoTmp.getPlanRevisionEquipo() != null) {
					datMantenimientoEquipoDTO2
							.setNombrePlanRevision(datMantenimientoEquipoTmp.getPlanRevisionEquipo().getNombre());
				} else {
					datMantenimientoEquipoDTO2.setNombrePlanRevision(null);
				}

				if (datMantenimientoEquipoTmp.getTallerMecanico() != null) {
					datMantenimientoEquipoDTO2.setTallerMecanicoId_TallerMecanico(
							datMantenimientoEquipoTmp.getTallerMecanico().getTallerMecanicoId());
				} else {
					datMantenimientoEquipoDTO2.setTallerMecanicoId_TallerMecanico(null);
				}

				/*
				 * datMantenimientoEquipoDTO2.setTallerMecanicoId_TallerMecanico(
				 * (datMantenimientoEquipoTmp.getTallerMecanico().getTallerMecanicoId() != null)
				 * ? datMantenimientoEquipoTmp.getTallerMecanico().getTallerMecanicoId() :
				 * null);
				 */

				datMantenimientoEquipoDTO2.setTipoMantenimientoId_TipoMantenimiento(
						(datMantenimientoEquipoTmp.getTipoMantenimiento() != null)
								? datMantenimientoEquipoTmp.getTipoMantenimiento().getTipoMantenimientoId()
								: null);

				if (datMantenimientoEquipoTmp.getTipoMantenimiento() != null) {
					datMantenimientoEquipoDTO2
							.setNombreTipoMantenimiento(datMantenimientoEquipoTmp.getTipoMantenimiento().getNombre());
				} else {
					datMantenimientoEquipoDTO2.setNombreTipoMantenimiento(null);
				}

				datMantenimientoEquipoDTO2
						.setFechaSalidaTaller((datMantenimientoEquipoTmp.getFechaSalidaTaller() != null)
								? datMantenimientoEquipoTmp.getFechaSalidaTaller()
								: null);

				if (datMantenimientoEquipoTmp.getZonasFabrica() != null) {
					datMantenimientoEquipoDTO2.setZonasFabricaId_ZonasFabrica(
							datMantenimientoEquipoTmp.getZonasFabrica().getZonasFabricaId());
				} else {

					datMantenimientoEquipoDTO2.setZonasFabricaId_ZonasFabrica(null);

				}

				if (datMantenimientoEquipoTmp.getAreaTrabajo() != null) {

					datMantenimientoEquipoDTO2.setAreaTrabajoId_AreaTrabajo(
							datMantenimientoEquipoTmp.getAreaTrabajo().getAreaTrabajoId());

				} else {

					datMantenimientoEquipoDTO2.setAreaTrabajoId_AreaTrabajo(null);
				}

				if (datMantenimientoEquipoTmp.getTag() != null) {
					datMantenimientoEquipoDTO2.setTagId_Tag(datMantenimientoEquipoTmp.getTag().getTagId());
				} else {
					datMantenimientoEquipoDTO2.setTagId_Tag(null);
				}

				if (datMantenimientoEquipoTmp.getNivelPrioridad() != null) {
					datMantenimientoEquipoDTO2.setNivelPrioridadId_NivelPrioridad(
							datMantenimientoEquipoTmp.getNivelPrioridad().getNivelPrioridadId());
				} else {
					datMantenimientoEquipoDTO2.setNivelPrioridadId_NivelPrioridad(null);
				}

				if (datMantenimientoEquipoTmp.getRequiereParadaFabrica() != null) {
					datMantenimientoEquipoDTO2
							.setRequiereParadaFabrica(datMantenimientoEquipoTmp.getRequiereParadaFabrica());
				} else {
					datMantenimientoEquipoDTO2.setRequiereParadaFabrica(null);
				}

				if (datMantenimientoEquipoTmp.getTrabajador() != null) {
					datMantenimientoEquipoDTO2
							.setTrabId_Trabajador(datMantenimientoEquipoTmp.getTrabajador().getTrabId());
				} else {
					datMantenimientoEquipoDTO2.setTrabId_Trabajador(null);
				}

				String estadoEstrue = "false";
				if (datMantenimientoEquipoTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datMantenimientoEquipoDTO2.setEstadoTrue(estadoEstrue);
					datMantenimientoEquipoDTO2.setEstadoTrue2(estadoEstrue);
				}
				datMantenimientoEquipoDTO2.setEstadoTrue(estadoEstrue);

				String tituloCierreOt = "Esta seguro que desea cerrar la O.T ?";
				String icon = "ui-icon-unlocked";

				if (datMantenimientoEquipoTmp.getCierreOt() != null) {

					if (datMantenimientoEquipoTmp.getCierreOt().equals("C")) {
						tituloCierreOt = "Esta seguro que desea reabrir la O.T ?";
						icon = "ui-icon-locked";
						estadoEstrue = "true";
						datMantenimientoEquipoDTO2.setEstadoTrue2(estadoEstrue);
						datMantenimientoEquipoDTO2.setTituloCierreOt(tituloCierreOt);
						datMantenimientoEquipoDTO2.setIconCierreOt(icon);
					}
					datMantenimientoEquipoDTO2.setTituloCierreOt(tituloCierreOt);
					datMantenimientoEquipoDTO2.setIconCierreOt(icon);
					datMantenimientoEquipoDTO2.setEstadoTrue2(estadoEstrue);

				} else {

					estadoEstrue = "true";
					datMantenimientoEquipoDTO2.setEstadoTrue(estadoEstrue);
				}

				datMantenimientoEquipoDTO2.setOrigenDatos((datMantenimientoEquipoTmp.getOrigenDatos() != null)
						? datMantenimientoEquipoTmp.getOrigenDatos()
						: null);

				if (datMantenimientoEquipoTmp.getDescripcionSolicitud() != null) {

					datMantenimientoEquipoDTO2
							.setDescripcionSolicitud(datMantenimientoEquipoTmp.getDescripcionSolicitud());

				} else {

					datMantenimientoEquipoDTO2.setDescripcionSolicitud(null);

				}

				if (datMantenimientoEquipoTmp.getEquipo() != null) {

					datMantenimientoEquipoDTO2.setEquipoNombre(datMantenimientoEquipoTmp.getEquipo().getNombre());

				} else {

					datMantenimientoEquipoDTO2.setEquipoNombre(null);

				}

				if (datMantenimientoEquipoTmp.getEquipo() != null) {

					if (datMantenimientoEquipoTmp.getEquipo().getCategoriaEquipo().getFuncion() != null) {
						if (datMantenimientoEquipoTmp.getEquipo().getCategoriaEquipo().getFuncion().equals("Camioneta")
								|| datMantenimientoEquipoTmp.getEquipo().getCategoriaEquipo().getFuncion()
										.equals("Camion")) {
							datMantenimientoEquipoDTO2
									.setEquipoCodigo(datMantenimientoEquipoTmp.getEquipo().getPlaca());
						} else {
							datMantenimientoEquipoDTO2
									.setEquipoCodigo(datMantenimientoEquipoTmp.getEquipo().getCodigo());
						}

					} else {
						datMantenimientoEquipoDTO2.setEquipoCodigo(datMantenimientoEquipoTmp.getEquipo().getCodigo());
					}

				} else {
					datMantenimientoEquipoDTO2.setEquipoCodigo(null);
				}

				if (datMantenimientoEquipoTmp.getResponsableMttoId() != null) {

					datMantenimientoEquipoDTO2
							.setResponsableMttoId(datMantenimientoEquipoTmp.getResponsableMttoId().getTrabId());

				} else {

					datMantenimientoEquipoDTO2.setResponsableMttoId(null);

				}

				if (datMantenimientoEquipoTmp.getResponsableMttoId() != null) {

					datMantenimientoEquipoDTO2
							.setNombreResponsableMtto(datMantenimientoEquipoTmp.getResponsableMttoId().getNombre());

				} else {

					datMantenimientoEquipoDTO2.setNombreResponsableMtto(null);

				}

				if (datMantenimientoEquipoTmp.getDifTiempoMttoAnteriorActual() != null) {

					datMantenimientoEquipoDTO2
							.setDifTiempoMttoAnteriorActual(datMantenimientoEquipoTmp.getDifTiempoMttoAnteriorActual());

				} else {

					datMantenimientoEquipoDTO2.setDifTiempoMttoAnteriorActual(null);

				}

				if (datMantenimientoEquipoTmp.getTipoOrdenMtto() != null) {

					datMantenimientoEquipoDTO2.setTipoOrdenMtto(datMantenimientoEquipoTmp.getTipoOrdenMtto());

				} else {

					datMantenimientoEquipoDTO2.setTipoOrdenMtto(null);

				}
				
				
				if (datMantenimientoEquipoTmp.getAgenteCausadorDescripcion() != null) {

					datMantenimientoEquipoDTO2.setAgenteCausadorDescripcion(datMantenimientoEquipoTmp.getAgenteCausadorDescripcion());

				} else {

					datMantenimientoEquipoDTO2.setAgenteCausadorDescripcion(null);

				}
				if (datMantenimientoEquipoTmp.getTipoFallaDescripcion() != null) {

					datMantenimientoEquipoDTO2.setTipoFallaDescripcion(datMantenimientoEquipoTmp.getTipoFallaDescripcion());

				} else {

					datMantenimientoEquipoDTO2.setTipoFallaDescripcion(null);

				}
				if (datMantenimientoEquipoTmp.getTallerMecanicoDescripcion() != null) {

					datMantenimientoEquipoDTO2.setTallerMecanicoDescripcion(datMantenimientoEquipoTmp.getTallerMecanicoDescripcion());

				} else {

					datMantenimientoEquipoDTO2.setTallerMecanicoDescripcion(null);

				}
				if (datMantenimientoEquipoTmp.getHorOdoSalida() != null) {

					datMantenimientoEquipoDTO2.setHorOdoSalida(datMantenimientoEquipoTmp.getHorOdoSalida());

				} else {

					datMantenimientoEquipoDTO2.setHorOdoSalida(null);

				}
				datMantenimientoEquipoDTO.add(datMantenimientoEquipoDTO2);

				// }
				// }

			}

			return datMantenimientoEquipoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatMantenimientoEquipo getDatMantenimientoEquipo(Long datMantenimientoEquipoId) throws Exception {
		log.debug("getting DatMantenimientoEquipo instance");

		DatMantenimientoEquipo entity = null;

		try {
			entity = datMantenimientoEquipoDAO.findById(datMantenimientoEquipoId);
		} catch (Exception e) {
			log.error("get DatMantenimientoEquipo failed", e);
			throw new ZMessManager().new FindingException("DatMantenimientoEquipo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatMantenimientoEquipo> findPageDatMantenimientoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatMantenimientoEquipo> entity = null;

		try {
			entity = datMantenimientoEquipoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatMantenimientoEquipo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatMantenimientoEquipo() throws Exception {
		Long entity = null;

		try {
			entity = datMantenimientoEquipoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatMantenimientoEquipo Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles                 este arreglo debera tener:
	 *
	 *                                 [0] = String variable = (String) varibles[i];
	 *                                 representa como se llama la variable en el
	 *                                 pojo
	 *
	 *                                 [1] = Boolean booVariable = (Boolean)
	 *                                 varibles[i + 1]; representa si el valor
	 *                                 necesita o no ''(comillas simples)usado para
	 *                                 campos de tipo string
	 *
	 *                                 [2] = Object value = varibles[i + 2];
	 *                                 representa el valor que se va a buscar en la
	 *                                 BD
	 *
	 *                                 [3] = String comparator = (String) varibles[i
	 *                                 + 3]; representa que tipo de busqueda voy a
	 *                                 hacer.., ejemplo: where nombre=william o
	 *                                 where nombre<>william, en este campo iria el
	 *                                 tipo de comparador que quiero si es = o <>
	 *
	 *                                 Se itera de 4 en 4..., entonces 4 registros
	 *                                 del arreglo representan 1 busqueda en un
	 *                                 campo, si se ponen mas pues el continuara
	 *                                 buscando en lo que se le ingresen en los
	 *                                 otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                                 la diferencia son estas dos posiciones
	 *
	 *                                 [0] = String variable = (String) varibles[j];
	 *                                 la variable ne la BD que va a ser buscada en
	 *                                 un rango
	 *
	 *                                 [1] = Object value = varibles[j + 1]; valor 1
	 *                                 para buscar en un rango
	 *
	 *                                 [2] = Object value2 = varibles[j + 2]; valor
	 *                                 2 para buscar en un rango ejempolo: a > 1 and
	 *                                 a < 5 --> 1 seria value y 5 seria value2
	 *
	 *                                 [3] = String comparator1 = (String)
	 *                                 varibles[j + 3]; comparador 1 ejemplo: a
	 *                                 comparator1 1 and a < 5
	 *
	 *                                 [4] = String comparator2 = (String)
	 *                                 varibles[j + 4]; comparador 2 ejemplo: a
	 *                                 comparador1>1 and a comparador2<5 (el
	 *                                 original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en este caso solo para mysql) [0] = String
	 *                                 variable = (String) varibles[k]; el nombre de
	 *                                 la variable que hace referencia a una fecha
	 *
	 *                                 [1] = Object object1 = varibles[k + 2]; fecha
	 *                                 1 a comparar(deben ser dates)
	 *
	 *                                 [2] = Object object2 = varibles[k + 3]; fecha
	 *                                 2 a comparar(deben ser dates)
	 *
	 *                                 esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatMantenimientoEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatMantenimientoEquipo> list = new ArrayList<DatMantenimientoEquipo>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = datMantenimientoEquipoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

}
