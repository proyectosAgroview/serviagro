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

import co.com.arcosoft.dataaccess.dao.ICronogramaLaboresNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CronogramaLaboresNivel4;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CronogramaLaboresNivel4Logic")
public class CronogramaLaboresNivel4Logic implements ICronogramaLaboresNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages CronogramaLaboresNivel4 entities
	 *
	 */
	@Autowired
	private ICronogramaLaboresNivel4DAO cronogramaLaboresNivel4DAO;

	/**
	 * Logic injected by Spring that manages CronogramaLabores entities
	 *
	 */
	@Autowired
	ICronogramaLaboresLogic logicCronogramaLabores1;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel42;

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresNivel4> getCronogramaLaboresNivel4() throws Exception {
		log.debug("finding all CronogramaLaboresNivel4 instances");

		List<CronogramaLaboresNivel4> list = new ArrayList<CronogramaLaboresNivel4>();

		try {
			list = cronogramaLaboresNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all CronogramaLaboresNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "CronogramaLaboresNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		log.debug("saving CronogramaLaboresNivel4 instance");

		try {
			if (entity.getCronogramaLabores() == null) {
				throw new ZMessManager().new ForeignException("cronogramaLabores");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getCronogramaLaboresNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresNivel4Id");
			}

			if ((entity.getCronogramaLaboresNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCronogramaLaboresNivel4Id(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresNivel4Id");
			}

			if (entity.getCronogramaLabores().getCronogramaLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId_CronogramaLabores");
			}

			if ((entity.getCronogramaLabores().getCronogramaLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCronogramaLabores().getCronogramaLaboresId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresId_CronogramaLabores");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (getCronogramaLaboresNivel4(entity.getCronogramaLaboresNivel4Id()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			cronogramaLaboresNivel4DAO.save(entity);

			log.debug("save CronogramaLaboresNivel4 successful");
		} catch (Exception e) {
			log.error("save CronogramaLaboresNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		log.debug("deleting CronogramaLaboresNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CronogramaLaboresNivel4");
		}

		if (entity.getCronogramaLaboresNivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("cronogramaLaboresNivel4Id");
		}

		try {
			cronogramaLaboresNivel4DAO.delete(entity);

			log.debug("delete CronogramaLaboresNivel4 successful");
		} catch (Exception e) {
			log.error("delete CronogramaLaboresNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		log.debug("updating CronogramaLaboresNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("CronogramaLaboresNivel4");
			}

			if (entity.getCronogramaLabores() == null) {
				throw new ZMessManager().new ForeignException("cronogramaLabores");
			}

			if (entity.getCronogramaLaboresNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresNivel4Id");
			}

			if ((entity.getCronogramaLaboresNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCronogramaLaboresNivel4Id(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresNivel4Id");
			}

			if (entity.getCronogramaLabores().getCronogramaLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId_CronogramaLabores");
			}

			if ((entity.getCronogramaLabores().getCronogramaLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCronogramaLabores().getCronogramaLaboresId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresId_CronogramaLabores");
			}

			cronogramaLaboresNivel4DAO.update(entity);

			log.debug("update CronogramaLaboresNivel4 successful");
		} catch (Exception e) {
			log.error("update CronogramaLaboresNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4() throws Exception {
		try {
			List<CronogramaLaboresNivel4> cronogramaLaboresNivel4 = cronogramaLaboresNivel4DAO.findAll();

			List<CronogramaLaboresNivel4DTO> cronogramaLaboresNivel4DTO = new ArrayList<CronogramaLaboresNivel4DTO>();

			for (CronogramaLaboresNivel4 cronogramaLaboresNivel4Tmp : cronogramaLaboresNivel4) {
				CronogramaLaboresNivel4DTO cronogramaLaboresNivel4DTO2 = new CronogramaLaboresNivel4DTO();

				cronogramaLaboresNivel4DTO2
						.setCronogramaLaboresNivel4Id(cronogramaLaboresNivel4Tmp.getCronogramaLaboresNivel4Id());
				cronogramaLaboresNivel4DTO2.setCronogramaLaboresId_CronogramaLabores(
						(cronogramaLaboresNivel4Tmp.getCronogramaLabores().getCronogramaLaboresId() != null)
								? cronogramaLaboresNivel4Tmp.getCronogramaLabores().getCronogramaLaboresId() : null);

				if (cronogramaLaboresNivel4Tmp.getNivel4() != null) {
					cronogramaLaboresNivel4DTO2.setNivel4Id_Nivel4(cronogramaLaboresNivel4Tmp.getNivel4());
				} else {
					cronogramaLaboresNivel4DTO2.setNivel4Id_Nivel4(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel4() != null) {
					cronogramaLaboresNivel4DTO2.setNombreNivel4(cronogramaLaboresNivel4Tmp.getNivel4().getNombre());
				} else {
					cronogramaLaboresNivel4DTO2.setNombreNivel4(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel2Id() != null) {
					cronogramaLaboresNivel4DTO2.setNombreNivel2(cronogramaLaboresNivel4Tmp.getNivel2Id().getNombre());
				} else {
					cronogramaLaboresNivel4DTO2.setNombreNivel2(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel2Id() != null) {
					cronogramaLaboresNivel4DTO2.setNivel2Id(cronogramaLaboresNivel4Tmp.getNivel2Id());
				} else {
					cronogramaLaboresNivel4DTO2.setNivel2Id(null);
				}
				
				cronogramaLaboresNivel4DTO2
				.setFechaStart(cronogramaLaboresNivel4Tmp.getFechaStart());

				
				cronogramaLaboresNivel4DTO.add(cronogramaLaboresNivel4DTO2);
			}
				
			return cronogramaLaboresNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CronogramaLaboresNivel4 getCronogramaLaboresNivel4(Long cronogramaLaboresNivel4Id) throws Exception {
		log.debug("getting CronogramaLaboresNivel4 instance");

		CronogramaLaboresNivel4 entity = null;

		try {
			entity = cronogramaLaboresNivel4DAO.findById(cronogramaLaboresNivel4Id);
		} catch (Exception e) {
			log.error("get CronogramaLaboresNivel4 failed", e);
			throw new ZMessManager().new FindingException("CronogramaLaboresNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresNivel4> findPageCronogramaLaboresNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<CronogramaLaboresNivel4> entity = null;

		try {
			entity = cronogramaLaboresNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLaboresNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCronogramaLaboresNivel4() throws Exception {
		Long entity = null;

		try {
			entity = cronogramaLaboresNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLaboresNivel4 Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<CronogramaLaboresNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<CronogramaLaboresNivel4> list = new ArrayList<CronogramaLaboresNivel4>();
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
			list = cronogramaLaboresNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4ByCronograma(Long cronogramaLaboresId)
			throws Exception {
		try {
			List<CronogramaLaboresNivel4> cronogramaLaboresNivel4 = cronogramaLaboresNivel4DAO
					.findByCriteria("cronogramaLabores.cronogramaLaboresId= " + cronogramaLaboresId);
			List<CronogramaLaboresNivel4DTO> cronogramaLaboresNivel4DTO = new ArrayList<CronogramaLaboresNivel4DTO>();

			for (CronogramaLaboresNivel4 cronogramaLaboresNivel4Tmp : cronogramaLaboresNivel4) {
				CronogramaLaboresNivel4DTO cronogramaLaboresNivel4DTO2 = new CronogramaLaboresNivel4DTO();

				cronogramaLaboresNivel4DTO2
						.setCronogramaLaboresNivel4Id(cronogramaLaboresNivel4Tmp.getCronogramaLaboresNivel4Id());
				cronogramaLaboresNivel4DTO2.setCronogramaLaboresId_CronogramaLabores(
						(cronogramaLaboresNivel4Tmp.getCronogramaLabores().getCronogramaLaboresId() != null)
								? cronogramaLaboresNivel4Tmp.getCronogramaLabores().getCronogramaLaboresId() : null);

				if (cronogramaLaboresNivel4Tmp.getNivel4() != null) {
					cronogramaLaboresNivel4DTO2.setNivel4Id_Nivel4(cronogramaLaboresNivel4Tmp.getNivel4());
				} else {
					cronogramaLaboresNivel4DTO2.setNivel4Id_Nivel4(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel4() != null) {
					cronogramaLaboresNivel4DTO2.setNombreNivel4(cronogramaLaboresNivel4Tmp.getNivel4().getNombre());
				} else {
					cronogramaLaboresNivel4DTO2.setNombreNivel4(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel2Id() != null) {
					cronogramaLaboresNivel4DTO2.setNombreNivel2(cronogramaLaboresNivel4Tmp.getNivel2Id().getNombre());
				} else {
					cronogramaLaboresNivel4DTO2.setNombreNivel2(null);
				}

				if (cronogramaLaboresNivel4Tmp.getNivel2Id() != null) {
					cronogramaLaboresNivel4DTO2.setNivel2Id(cronogramaLaboresNivel4Tmp.getNivel2Id());
				} else {
					cronogramaLaboresNivel4DTO2.setNivel2Id(null);
				}
				cronogramaLaboresNivel4DTO2.setAreaNeta(cronogramaLaboresNivel4Tmp.getAreaNeta());
				cronogramaLaboresNivel4DTO2.setNumeroPlantas(cronogramaLaboresNivel4Tmp.getNumeroPlantas());
				cronogramaLaboresNivel4DTO2.setFechaStart(cronogramaLaboresNivel4Tmp.getFechaStart());

				cronogramaLaboresNivel4DTO.add(cronogramaLaboresNivel4DTO2);
			}

			return cronogramaLaboresNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
