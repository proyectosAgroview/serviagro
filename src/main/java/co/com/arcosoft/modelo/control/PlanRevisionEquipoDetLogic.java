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

import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PlanRevisionEquipoDetLogic")
public class PlanRevisionEquipoDetLogic implements IPlanRevisionEquipoDetLogic {
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoDetLogic.class);

	/**
	 * DAO injected by Spring that manages PlanRevisionEquipoDet entities
	 *
	 */
	@Autowired
	private IPlanRevisionEquipoDetDAO planRevisionEquipoDetDAO;

	/**
	 * Logic injected by Spring that manages PlanRevisionEquipo entities
	 *
	 */
	@Autowired
	IPlanRevisionEquipoLogic logicPlanRevisionEquipo1;

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDet> getPlanRevisionEquipoDet() throws Exception {
		log.debug("finding all PlanRevisionEquipoDet instances");

		List<PlanRevisionEquipoDet> list = new ArrayList<PlanRevisionEquipoDet>();

		try {
			list = planRevisionEquipoDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PlanRevisionEquipoDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "PlanRevisionEquipoDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		log.debug("saving PlanRevisionEquipoDet instance");

		try {
			if (entity.getPlanRevisionEquipo() == null) {
				throw new ZMessManager().new ForeignException("planRevisionEquipo");
			}

			if ((entity.getEquipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipo");
			}

			if ((entity.getPeriocidadDias() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPeriocidadDias(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("periocidadDias");
			}

			if ((entity.getPeriocidadHora() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPeriocidadHora(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("periocidadHora");
			}

			if ((entity.getPeriocidadKm() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPeriocidadKm(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("periocidadKm");
			}

			if (entity.getPlanRevisionEquipoDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("planRevisionEquipoDetId");
			}

			if ((entity.getPlanRevisionEquipoDetId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPlanRevisionEquipoDetId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planRevisionEquipoDetId");
			}

			if (entity.getPlanRevisionEquipo().getPlanRevisionEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("planRevisionEquipoId_PlanRevisionEquipo");
			}

			if ((entity.getPlanRevisionEquipo().getPlanRevisionEquipoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getPlanRevisionEquipo().getPlanRevisionEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planRevisionEquipoId_PlanRevisionEquipo");
			}

			if (getPlanRevisionEquipoDet(entity.getPlanRevisionEquipoDetId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			planRevisionEquipoDetDAO.save(entity);

			log.debug("save PlanRevisionEquipoDet successful");
		} catch (Exception e) {
			log.error("save PlanRevisionEquipoDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		log.debug("deleting PlanRevisionEquipoDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PlanRevisionEquipoDet");
		}

		if (entity.getPlanRevisionEquipoDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("planRevisionEquipoDetId");
		}

		try {
			planRevisionEquipoDetDAO.delete(entity);

			log.debug("delete PlanRevisionEquipoDet successful");
		} catch (Exception e) {
			log.error("delete PlanRevisionEquipoDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		log.debug("updating PlanRevisionEquipoDet instance");

		try {
			planRevisionEquipoDetDAO.update(entity);

			log.debug("update PlanRevisionEquipoDet successful");
		} catch (Exception e) {
			log.error("update PlanRevisionEquipoDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDet() throws Exception {
		try {
			List<PlanRevisionEquipoDet> planRevisionEquipoDet = planRevisionEquipoDetDAO.findAll();

			List<PlanRevisionEquipoDetDTO> planRevisionEquipoDetDTO = new ArrayList<PlanRevisionEquipoDetDTO>();

			for (PlanRevisionEquipoDet planRevisionEquipoDetTmp : planRevisionEquipoDet) {
				PlanRevisionEquipoDetDTO planRevisionEquipoDetDTO2 = new PlanRevisionEquipoDetDTO();

				planRevisionEquipoDetDTO2
						.setPlanRevisionEquipoDetId(planRevisionEquipoDetTmp.getPlanRevisionEquipoDetId());
				planRevisionEquipoDetDTO2.setEquipo(
						(planRevisionEquipoDetTmp.getEquipo() != null) ? planRevisionEquipoDetTmp.getEquipo() : null);
				planRevisionEquipoDetDTO2
						.setCompartimientosEquipo((planRevisionEquipoDetTmp.getCompartimientosEquipo() != null)
								? planRevisionEquipoDetTmp.getCompartimientosEquipo()
								: null);
				planRevisionEquipoDetDTO2.setSistemasEquipo((planRevisionEquipoDetTmp.getSistemasEquipo() != null)
						? planRevisionEquipoDetTmp.getSistemasEquipo()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadDias((planRevisionEquipoDetTmp.getPeriocidadDias() != null)
						? planRevisionEquipoDetTmp.getPeriocidadDias()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadHora((planRevisionEquipoDetTmp.getPeriocidadHora() != null)
						? planRevisionEquipoDetTmp.getPeriocidadHora()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadKm((planRevisionEquipoDetTmp.getPeriocidadKm() != null)
						? planRevisionEquipoDetTmp.getPeriocidadKm()
						: null);
				planRevisionEquipoDetDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(
						(planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId() != null)
								? planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId()
								: null);
				if (planRevisionEquipoDetTmp.getInfoAdicional() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional(planRevisionEquipoDetTmp.getInfoAdicional());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional(null);
				}

				if (planRevisionEquipoDetTmp.getInfoAdicional2() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional2(planRevisionEquipoDetTmp.getInfoAdicional2());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional2(null);
				}

				
				if (planRevisionEquipoDetTmp.getObservacion() != null) {
					planRevisionEquipoDetDTO2
							.setObservacion(planRevisionEquipoDetTmp.getObservacion());
				} else {
					planRevisionEquipoDetDTO2.setObservacion(null);
				}
				planRevisionEquipoDetDTO.add(planRevisionEquipoDetDTO2);
			}

			return planRevisionEquipoDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PlanRevisionEquipoDet getPlanRevisionEquipoDet(Long planRevisionEquipoDetId) throws Exception {
		log.debug("getting PlanRevisionEquipoDet instance");

		PlanRevisionEquipoDet entity = null;

		try {
			entity = planRevisionEquipoDetDAO.findById(planRevisionEquipoDetId);
		} catch (Exception e) {
			log.error("get PlanRevisionEquipoDet failed", e);
			throw new ZMessManager().new FindingException("PlanRevisionEquipoDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDet> findPagePlanRevisionEquipoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<PlanRevisionEquipoDet> entity = null;

		try {
			entity = planRevisionEquipoDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanRevisionEquipoDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPlanRevisionEquipoDet() throws Exception {
		Long entity = null;

		try {
			entity = planRevisionEquipoDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanRevisionEquipoDet Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles         este arreglo debera tener:
	 *
	 *                         [0] = String variable = (String) varibles[i];
	 *                         representa como se llama la variable en el pojo
	 *
	 *                         [1] = Boolean booVariable = (Boolean) varibles[i +
	 *                         1]; representa si el valor necesita o no ''(comillas
	 *                         simples)usado para campos de tipo string
	 *
	 *                         [2] = Object value = varibles[i + 2]; representa el
	 *                         valor que se va a buscar en la BD
	 *
	 *                         [3] = String comparator = (String) varibles[i + 3];
	 *                         representa que tipo de busqueda voy a hacer..,
	 *                         ejemplo: where nombre=william o where
	 *                         nombre<>william, en este campo iria el tipo de
	 *                         comparador que quiero si es = o <>
	 *
	 *                         Se itera de 4 en 4..., entonces 4 registros del
	 *                         arreglo representan 1 busqueda en un campo, si se
	 *                         ponen mas pues el continuara buscando en lo que se le
	 *                         ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                         la diferencia son estas dos posiciones
	 *
	 *                         [0] = String variable = (String) varibles[j]; la
	 *                         variable ne la BD que va a ser buscada en un rango
	 *
	 *                         [1] = Object value = varibles[j + 1]; valor 1 para
	 *                         buscar en un rango
	 *
	 *                         [2] = Object value2 = varibles[j + 2]; valor 2 para
	 *                         buscar en un rango ejempolo: a > 1 and a < 5 --> 1
	 *                         seria value y 5 seria value2
	 *
	 *                         [3] = String comparator1 = (String) varibles[j + 3];
	 *                         comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *                         [4] = String comparator2 = (String) varibles[j + 4];
	 *                         comparador 2 ejemplo: a comparador1>1 and a
	 *                         comparador2<5 (el original: a > 1 and a < 5) *
	 * @param                  variablesBetweenDates(en este caso solo para mysql)
	 *                         [0] = String variable = (String) varibles[k]; el
	 *                         nombre de la variable que hace referencia a una fecha
	 *
	 *                         [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *                         comparar(deben ser dates)
	 *
	 *                         [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *                         comparar(deben ser dates)
	 *
	 *                         esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<PlanRevisionEquipoDet> list = new ArrayList<PlanRevisionEquipoDet>();
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
			list = planRevisionEquipoDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipo(Long planRevisionEquipoId)
			throws Exception {
		try {
			List<PlanRevisionEquipoDet> planRevisionEquipoDet = planRevisionEquipoDetDAO
					.findByCriteria("planRevisionEquipo.planRevisionEquipoId= " + planRevisionEquipoId);

			List<PlanRevisionEquipoDetDTO> planRevisionEquipoDetDTO = new ArrayList<PlanRevisionEquipoDetDTO>();

			for (PlanRevisionEquipoDet planRevisionEquipoDetTmp : planRevisionEquipoDet) {
				PlanRevisionEquipoDetDTO planRevisionEquipoDetDTO2 = new PlanRevisionEquipoDetDTO();

				planRevisionEquipoDetDTO2
						.setPlanRevisionEquipoDetId(planRevisionEquipoDetTmp.getPlanRevisionEquipoDetId());
				planRevisionEquipoDetDTO2.setEquipo(
						(planRevisionEquipoDetTmp.getEquipo() != null) ? planRevisionEquipoDetTmp.getEquipo() : null);
				planRevisionEquipoDetDTO2
						.setCompartimientosEquipo((planRevisionEquipoDetTmp.getCompartimientosEquipo() != null)
								? planRevisionEquipoDetTmp.getCompartimientosEquipo()
								: null);
				planRevisionEquipoDetDTO2.setSistemasEquipo((planRevisionEquipoDetTmp.getSistemasEquipo() != null)
						? planRevisionEquipoDetTmp.getSistemasEquipo()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadDias((planRevisionEquipoDetTmp.getPeriocidadDias() != null)
						? planRevisionEquipoDetTmp.getPeriocidadDias()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadHora((planRevisionEquipoDetTmp.getPeriocidadHora() != null)
						? planRevisionEquipoDetTmp.getPeriocidadHora()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadKm((planRevisionEquipoDetTmp.getPeriocidadKm() != null)
						? planRevisionEquipoDetTmp.getPeriocidadKm()
						: null);
				planRevisionEquipoDetDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(
						(planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId() != null)
								? planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId()
								: null);

			
				if (planRevisionEquipoDetTmp.getCompartimientosEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreCompartimiento(planRevisionEquipoDetTmp.getCompartimientosEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreCompartimiento(null);
				}

				if (planRevisionEquipoDetTmp.getSistemasEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreSistema(planRevisionEquipoDetTmp.getSistemasEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreSistema(null);
				}

				if (planRevisionEquipoDetTmp.getAlertaMin() != null) {

					planRevisionEquipoDetDTO2.setAlertaMin(planRevisionEquipoDetTmp.getAlertaMin());

				} else {

					planRevisionEquipoDetDTO2.setAlertaMin(null);
				}

				if (planRevisionEquipoDetTmp.getAlertaMax() != null) {

					planRevisionEquipoDetDTO2.setAlertaMax(planRevisionEquipoDetTmp.getAlertaMax());

				} else {

					planRevisionEquipoDetDTO2.setAlertaMax(null);
				}

				if (planRevisionEquipoDetTmp.getFechaUltimoServicio() != null) {

					planRevisionEquipoDetDTO2.setFechaUltimoServicio(planRevisionEquipoDetTmp.getFechaUltimoServicio());

				} else {

					planRevisionEquipoDetDTO2.setFechaUltimoServicio(null);
				}

				if (planRevisionEquipoDetTmp.getHorasUltimoServicio() != null) {

					planRevisionEquipoDetDTO2.setHorasUltimoServicio(planRevisionEquipoDetTmp.getHorasUltimoServicio());

				} else {

					planRevisionEquipoDetDTO2.setHorasUltimoServicio(null);
				}

				if (planRevisionEquipoDetTmp.getKmUltimoServicio() != null) {

					planRevisionEquipoDetDTO2.setKmUltimoServicio(planRevisionEquipoDetTmp.getKmUltimoServicio());

				} else {

					planRevisionEquipoDetDTO2.setKmUltimoServicio(null);
				}

				if (planRevisionEquipoDetTmp.getEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreEquipo(planRevisionEquipoDetTmp.getEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreEquipo(null);
				}

				if (planRevisionEquipoDetTmp.getEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setCodEquipo(planRevisionEquipoDetTmp.getEquipo().getCodigo());
				} else {
					planRevisionEquipoDetDTO2.setCodEquipo(null);
				}

				if (planRevisionEquipoDetTmp.getInfoAdicional() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional(planRevisionEquipoDetTmp.getInfoAdicional());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional(null);
				}

				if (planRevisionEquipoDetTmp.getInfoAdicional2() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional2(planRevisionEquipoDetTmp.getInfoAdicional2());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional2(null);
				}

				if (planRevisionEquipoDetTmp.getObservacion() != null) {
					planRevisionEquipoDetDTO2
							.setObservacion(planRevisionEquipoDetTmp.getObservacion());
				} else {
					planRevisionEquipoDetDTO2.setObservacion(null);
				}

				planRevisionEquipoDetDTO.add(planRevisionEquipoDetDTO2);
			}

			return planRevisionEquipoDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipoId(Long equipoId) throws Exception {
		try {
			List<PlanRevisionEquipoDet> planRevisionEquipoDet = planRevisionEquipoDetDAO
					.findByCriteria("equipo.equipoId= " + equipoId);

			List<PlanRevisionEquipoDetDTO> planRevisionEquipoDetDTO = new ArrayList<PlanRevisionEquipoDetDTO>();

			for (PlanRevisionEquipoDet planRevisionEquipoDetTmp : planRevisionEquipoDet) {
				PlanRevisionEquipoDetDTO planRevisionEquipoDetDTO2 = new PlanRevisionEquipoDetDTO();

				planRevisionEquipoDetDTO2
						.setPlanRevisionEquipoDetId(planRevisionEquipoDetTmp.getPlanRevisionEquipoDetId());
				planRevisionEquipoDetDTO2.setEquipo(
						(planRevisionEquipoDetTmp.getEquipo() != null) ? planRevisionEquipoDetTmp.getEquipo() : null);
				planRevisionEquipoDetDTO2.setPeriocidadDias((planRevisionEquipoDetTmp.getPeriocidadDias() != null)
						? planRevisionEquipoDetTmp.getPeriocidadDias()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadHora((planRevisionEquipoDetTmp.getPeriocidadHora() != null)
						? planRevisionEquipoDetTmp.getPeriocidadHora()
						: null);
				planRevisionEquipoDetDTO2.setPeriocidadKm((planRevisionEquipoDetTmp.getPeriocidadKm() != null)
						? planRevisionEquipoDetTmp.getPeriocidadKm()
						: null);
				planRevisionEquipoDetDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(
						(planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId() != null)
								? planRevisionEquipoDetTmp.getPlanRevisionEquipo().getPlanRevisionEquipoId()
								: null);
				
				
				
				if (planRevisionEquipoDetTmp.getEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreEquipo(planRevisionEquipoDetTmp.getEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreEquipo(null);
				}

				if (planRevisionEquipoDetTmp.getEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setCodEquipo(planRevisionEquipoDetTmp.getEquipo().getCodigo());
				} else {
					planRevisionEquipoDetDTO2.setCodEquipo(null);
				}

				
				if (planRevisionEquipoDetTmp.getCompartimientosEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setCompartimientosEquipo(planRevisionEquipoDetTmp.getCompartimientosEquipo());
				} else {
					planRevisionEquipoDetDTO2.setCompartimientosEquipo(null);
				}

				if (planRevisionEquipoDetTmp.getCompartimientosEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreCompartimiento(planRevisionEquipoDetTmp.getCompartimientosEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreCompartimiento(null);
				}

				if (planRevisionEquipoDetTmp.getSistemasEquipo() != null) {
					planRevisionEquipoDetDTO2.setSistemasEquipo(planRevisionEquipoDetTmp.getSistemasEquipo());
				} else {
					planRevisionEquipoDetDTO2.setSistemasEquipo(null);
				}

				if (planRevisionEquipoDetTmp.getSistemasEquipo() != null) {
					planRevisionEquipoDetDTO2
							.setNombreSistema(planRevisionEquipoDetTmp.getSistemasEquipo().getNombre());
				} else {
					planRevisionEquipoDetDTO2.setNombreSistema(null);
				}

				if (planRevisionEquipoDetTmp.getInfoAdicional() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional(planRevisionEquipoDetTmp.getInfoAdicional());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional(null);
				}

				if (planRevisionEquipoDetTmp.getInfoAdicional2() != null) {
					planRevisionEquipoDetDTO2
							.setInfoAdicional2(planRevisionEquipoDetTmp.getInfoAdicional2());
				} else {
					planRevisionEquipoDetDTO2.setInfoAdicional2(null);
				}

				
				if (planRevisionEquipoDetTmp.getObservacion() != null) {
					planRevisionEquipoDetDTO2
							.setObservacion(planRevisionEquipoDetTmp.getObservacion());
				} else {
					planRevisionEquipoDetDTO2.setObservacion(null);
				}

				
				planRevisionEquipoDetDTO.add(planRevisionEquipoDetDTO2);
			}

			return planRevisionEquipoDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
