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

import co.com.arcosoft.dataaccess.dao.IPlanAsignarRecursoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.PlanAsignarRecurso;
import co.com.arcosoft.modelo.PlanAsignarRecursoId;
import co.com.arcosoft.modelo.dto.PlanAsignarRecursoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PlanAsignarRecursoLogic")
public class PlanAsignarRecursoLogic implements IPlanAsignarRecursoLogic {
	private static final Logger log = LoggerFactory.getLogger(PlanAsignarRecursoLogic.class);

	/**
	 * DAO injected by Spring that manages PlanAsignarRecurso entities
	 *
	 */
	@Autowired
	private IPlanAsignarRecursoDAO planAsignarRecursoDAO;

	/**
	 * Logic injected by Spring that manages DatPlanLabor entities
	 *
	 */
	@Autowired
	IDatPlanLaborLogic logicDatPlanLabor1;

	/**
	 * Logic injected by Spring that manages Recurso entities
	 *
	 */
	@Autowired
	IRecursoLogic logicRecurso2;

	/**
	 * Logic injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	ITipoRecursoLogic logicTipoRecurso3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<PlanAsignarRecurso> getPlanAsignarRecurso() throws Exception {
		log.debug("finding all PlanAsignarRecurso instances");

		List<PlanAsignarRecurso> list = new ArrayList<PlanAsignarRecurso>();

		try {
			list = planAsignarRecursoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PlanAsignarRecurso failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "PlanAsignarRecurso");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		log.debug("saving PlanAsignarRecurso instance");

		try {
			if (entity.getDatPlanLabor() == null) {
				throw new ZMessManager().new ForeignException("datPlanLabor");
			}

			if (entity.getRecurso() == null) {
				throw new ZMessManager().new ForeignException("recurso");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if (entity.getId().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId");
			}

			if ((entity.getId().getPlanLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getPlanLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planLaborId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId");
			}

			if ((entity.getId().getTpRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId");
			}

			if (entity.getId().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getId().getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getId().getUdadMedRecurso() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedRecurso");
			}

			if ((entity.getId().getUdadMedRecurso() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getUdadMedRecurso(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedRecurso");
			}

			if (entity.getId().getRendimiento() == null) {
				throw new ZMessManager().new EmptyFieldException("rendimiento");
			}

			if ((entity.getId().getRendimiento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRendimiento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("rendimiento");
			}

			if (entity.getId().getCantidad() == null) {
				throw new ZMessManager().new EmptyFieldException("cantidad");
			}

			if ((entity.getId().getCantidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCantidad(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if (entity.getId().getValorUnitEst() == null) {
				throw new ZMessManager().new EmptyFieldException("valorUnitEst");
			}

			if ((entity.getId().getValorUnitEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getValorUnitEst(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitEst");
			}

			if (entity.getId().getCostoTotalEstimado() == null) {
				throw new ZMessManager().new EmptyFieldException("costoTotalEstimado");
			}

			if ((entity.getId().getCostoTotalEstimado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCostoTotalEstimado(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotalEstimado");
			}

			if (entity.getId().getInfoAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional");
			}

			if ((entity.getId().getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if (entity.getId().getInfoAdicional2() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional2");
			}

			if ((entity.getId().getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getId().getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaCreacion");
			}

			if (entity.getId().getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaModificacion");
			}

			if (entity.getId().getDocumetoErp() == null) {
				throw new ZMessManager().new EmptyFieldException("documetoErp");
			}

			if ((entity.getId().getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if (entity.getDatPlanLabor().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId_DatPlanLabor");
			}

			if ((entity.getDatPlanLabor().getPlanLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatPlanLabor().getPlanLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planLaborId_DatPlanLabor");
			}

			if (entity.getRecurso().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId_Recurso");
			}

			if ((entity.getRecurso().getRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecurso().getRecursoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId_Recurso");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if ((entity.getTipoRecurso().getTpRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoRecurso().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (getPlanAsignarRecurso(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			planAsignarRecursoDAO.save(entity);

			log.debug("save PlanAsignarRecurso successful");
		} catch (Exception e) {
			log.error("save PlanAsignarRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		log.debug("deleting PlanAsignarRecurso instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PlanAsignarRecurso");
		}

		if (entity.getId().getPlanLaborId() == null) {
			throw new ZMessManager().new EmptyFieldException("planLaborId");
		}

		if (entity.getId().getCompania() == null) {
			throw new ZMessManager().new EmptyFieldException("compania");
		}

		if (entity.getId().getTpRecursoId() == null) {
			throw new ZMessManager().new EmptyFieldException("tpRecursoId");
		}

		if (entity.getId().getRecursoId() == null) {
			throw new ZMessManager().new EmptyFieldException("recursoId");
		}

		if (entity.getId().getUdadMedRecurso() == null) {
			throw new ZMessManager().new EmptyFieldException("udadMedRecurso");
		}

		if (entity.getId().getRendimiento() == null) {
			throw new ZMessManager().new EmptyFieldException("rendimiento");
		}

		if (entity.getId().getCantidad() == null) {
			throw new ZMessManager().new EmptyFieldException("cantidad");
		}

		if (entity.getId().getValorUnitEst() == null) {
			throw new ZMessManager().new EmptyFieldException("valorUnitEst");
		}

		if (entity.getId().getCostoTotalEstimado() == null) {
			throw new ZMessManager().new EmptyFieldException("costoTotalEstimado");
		}

		if (entity.getId().getInfoAdicional() == null) {
			throw new ZMessManager().new EmptyFieldException("infoAdicional");
		}

		if (entity.getId().getInfoAdicional2() == null) {
			throw new ZMessManager().new EmptyFieldException("infoAdicional2");
		}

		if (entity.getId().getDocumetoErp() == null) {
			throw new ZMessManager().new EmptyFieldException("documetoErp");
		}

		try {
			planAsignarRecursoDAO.delete(entity);

			log.debug("delete PlanAsignarRecurso successful");
		} catch (Exception e) {
			log.error("delete PlanAsignarRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		log.debug("updating PlanAsignarRecurso instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("PlanAsignarRecurso");
			}

			if (entity.getDatPlanLabor() == null) {
				throw new ZMessManager().new ForeignException("datPlanLabor");
			}

			if (entity.getRecurso() == null) {
				throw new ZMessManager().new ForeignException("recurso");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if (entity.getId().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId");
			}

			if ((entity.getId().getPlanLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getPlanLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planLaborId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId");
			}

			if ((entity.getId().getTpRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId");
			}

			if (entity.getId().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getId().getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getId().getUdadMedRecurso() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedRecurso");
			}

			if ((entity.getId().getUdadMedRecurso() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getUdadMedRecurso(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedRecurso");
			}

			if (entity.getId().getRendimiento() == null) {
				throw new ZMessManager().new EmptyFieldException("rendimiento");
			}

			if ((entity.getId().getRendimiento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRendimiento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("rendimiento");
			}

			if (entity.getId().getCantidad() == null) {
				throw new ZMessManager().new EmptyFieldException("cantidad");
			}

			if ((entity.getId().getCantidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCantidad(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if (entity.getId().getValorUnitEst() == null) {
				throw new ZMessManager().new EmptyFieldException("valorUnitEst");
			}

			if ((entity.getId().getValorUnitEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getValorUnitEst(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitEst");
			}

			if (entity.getId().getCostoTotalEstimado() == null) {
				throw new ZMessManager().new EmptyFieldException("costoTotalEstimado");
			}

			if ((entity.getId().getCostoTotalEstimado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCostoTotalEstimado(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotalEstimado");
			}

			if (entity.getId().getInfoAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional");
			}

			if ((entity.getId().getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if (entity.getId().getInfoAdicional2() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional2");
			}

			if ((entity.getId().getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getId().getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaCreacion");
			}

			if (entity.getId().getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaModificacion");
			}

			if (entity.getId().getDocumetoErp() == null) {
				throw new ZMessManager().new EmptyFieldException("documetoErp");
			}

			if ((entity.getId().getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if (entity.getDatPlanLabor().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId_DatPlanLabor");
			}

			if ((entity.getDatPlanLabor().getPlanLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatPlanLabor().getPlanLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planLaborId_DatPlanLabor");
			}

			if (entity.getRecurso().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId_Recurso");
			}

			if ((entity.getRecurso().getRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecurso().getRecursoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId_Recurso");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if ((entity.getTipoRecurso().getTpRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoRecurso().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			planAsignarRecursoDAO.update(entity);

			log.debug("update PlanAsignarRecurso successful");
		} catch (Exception e) {
			log.error("update PlanAsignarRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanAsignarRecursoDTO> getDataPlanAsignarRecurso() throws Exception {
		try {
			List<PlanAsignarRecurso> planAsignarRecurso = planAsignarRecursoDAO.findAll();

			List<PlanAsignarRecursoDTO> planAsignarRecursoDTO = new ArrayList<PlanAsignarRecursoDTO>();

			for (PlanAsignarRecurso planAsignarRecursoTmp : planAsignarRecurso) {
				PlanAsignarRecursoDTO planAsignarRecursoDTO2 = new PlanAsignarRecursoDTO();

				planAsignarRecursoDTO2.setPlanLaborId(planAsignarRecursoTmp.getId().getPlanLaborId());
				planAsignarRecursoDTO2.setCompania(planAsignarRecursoTmp.getId().getCompania());
				planAsignarRecursoDTO2.setTpRecursoId(planAsignarRecursoTmp.getId().getTpRecursoId());
				planAsignarRecursoDTO2.setRecursoId(planAsignarRecursoTmp.getId().getRecursoId());
				planAsignarRecursoDTO2.setUdadMedRecurso(planAsignarRecursoTmp.getId().getUdadMedRecurso());
				planAsignarRecursoDTO2.setRendimiento(planAsignarRecursoTmp.getId().getRendimiento());
				planAsignarRecursoDTO2.setCantidad(planAsignarRecursoTmp.getId().getCantidad());
				planAsignarRecursoDTO2.setValorUnitEst(planAsignarRecursoTmp.getId().getValorUnitEst());
				planAsignarRecursoDTO2.setCostoTotalEstimado(planAsignarRecursoTmp.getId().getCostoTotalEstimado());
				planAsignarRecursoDTO2.setInfoAdicional(planAsignarRecursoTmp.getId().getInfoAdicional());
				planAsignarRecursoDTO2.setInfoAdicional2(planAsignarRecursoTmp.getId().getInfoAdicional2());
				planAsignarRecursoDTO2.setFechaCreacion(planAsignarRecursoTmp.getId().getFechaCreacion());
				planAsignarRecursoDTO2.setFechaModificacion(planAsignarRecursoTmp.getId().getFechaModificacion());
				planAsignarRecursoDTO2.setDocumetoErp(planAsignarRecursoTmp.getId().getDocumetoErp());
				planAsignarRecursoDTO2
						.setPlanLaborId_DatPlanLabor((planAsignarRecursoTmp.getDatPlanLabor().getPlanLaborId() != null)
								? planAsignarRecursoTmp.getDatPlanLabor().getPlanLaborId() : null);
				planAsignarRecursoDTO2.setRecursoId_Recurso((planAsignarRecursoTmp.getRecurso().getRecursoId() != null)
						? planAsignarRecursoTmp.getRecurso().getRecursoId() : null);
				planAsignarRecursoDTO2
						.setTpRecursoId_TipoRecurso((planAsignarRecursoTmp.getTipoRecurso().getTpRecursoId() != null)
								? planAsignarRecursoTmp.getTipoRecurso().getTpRecursoId() : null);
				planAsignarRecursoDTO2.setUdadMedId_UdadMed((planAsignarRecursoTmp.getUdadMed().getUdadMedId() != null)
						? planAsignarRecursoTmp.getUdadMed().getUdadMedId() : null);
				planAsignarRecursoDTO.add(planAsignarRecursoDTO2);
			}

			return planAsignarRecursoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PlanAsignarRecurso getPlanAsignarRecurso(PlanAsignarRecursoId id) throws Exception {
		log.debug("getting PlanAsignarRecurso instance");

		PlanAsignarRecurso entity = null;

		try {
			entity = planAsignarRecursoDAO.findById(id);
		} catch (Exception e) {
			log.error("get PlanAsignarRecurso failed", e);
			throw new ZMessManager().new FindingException("PlanAsignarRecurso");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanAsignarRecurso> findPagePlanAsignarRecurso(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<PlanAsignarRecurso> entity = null;

		try {
			entity = planAsignarRecursoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanAsignarRecurso Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPlanAsignarRecurso() throws Exception {
		Long entity = null;

		try {
			entity = planAsignarRecursoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanAsignarRecurso Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PlanAsignarRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<PlanAsignarRecurso> list = new ArrayList<PlanAsignarRecurso>();
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
			list = planAsignarRecursoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
