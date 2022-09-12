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

import co.com.arcosoft.dataaccess.dao.IRestriccionQuemaNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4Id;
import co.com.arcosoft.modelo.dto.RestriccionQuemaNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("RestriccionQuemaNivel4Logic")
public class RestriccionQuemaNivel4Logic implements IRestriccionQuemaNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(RestriccionQuemaNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages RestriccionQuemaNivel4 entities
	 *
	 */
	@Autowired
	private IRestriccionQuemaNivel4DAO restriccionQuemaNivel4DAO;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel41;

	/**
	 * Logic injected by Spring that manages RestrQuema entities
	 *
	 */
	@Autowired
	IRestrQuemaLogic logicRestrQuema2;

	@Override
	@Transactional(readOnly = true)
	public List<RestriccionQuemaNivel4> getRestriccionQuemaNivel4() throws Exception {
		log.debug("finding all RestriccionQuemaNivel4 instances");

		List<RestriccionQuemaNivel4> list = new ArrayList<RestriccionQuemaNivel4>();

		try {
			list = restriccionQuemaNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all RestriccionQuemaNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "RestriccionQuemaNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception {
		log.debug("saving RestriccionQuemaNivel4 instance");

		try {
			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getRestrQuema() == null) {
				throw new ZMessManager().new ForeignException("restrQuema");
			}

			if (entity.getId().getRestrQuemaRestQuema() == null) {
				throw new ZMessManager().new EmptyFieldException("restrQuemaRestQuema");
			}

			if ((entity.getId().getRestrQuemaRestQuema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRestrQuemaRestQuema(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restrQuemaRestQuema");
			}

			if (entity.getId().getNivel4Nivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Nivel4Id");
			}

			if ((entity.getId().getNivel4Nivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNivel4Nivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Nivel4Id");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (entity.getRestrQuema().getRestQuema() == null) {
				throw new ZMessManager().new EmptyFieldException("restQuema_RestrQuema");
			}

			if ((entity.getRestrQuema().getRestQuema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestrQuema().getRestQuema(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restQuema_RestrQuema");
			}

			if (getRestriccionQuemaNivel4(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			restriccionQuemaNivel4DAO.save(entity);

			log.debug("save RestriccionQuemaNivel4 successful");
		} catch (Exception e) {
			log.error("save RestriccionQuemaNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception {
		log.debug("deleting RestriccionQuemaNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("RestriccionQuemaNivel4");
		}

		if (entity.getId().getRestrQuemaRestQuema() == null) {
			throw new ZMessManager().new EmptyFieldException("restrQuemaRestQuema");
		}

		if (entity.getId().getNivel4Nivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel4Nivel4Id");
		}

		try {
			restriccionQuemaNivel4DAO.delete(entity);

			log.debug("delete RestriccionQuemaNivel4 successful");
		} catch (Exception e) {
			log.error("delete RestriccionQuemaNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception {
		log.debug("updating RestriccionQuemaNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("RestriccionQuemaNivel4");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getRestrQuema() == null) {
				throw new ZMessManager().new ForeignException("restrQuema");
			}

			if (entity.getId().getRestrQuemaRestQuema() == null) {
				throw new ZMessManager().new EmptyFieldException("restrQuemaRestQuema");
			}

			if ((entity.getId().getRestrQuemaRestQuema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRestrQuemaRestQuema(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restrQuemaRestQuema");
			}

			if (entity.getId().getNivel4Nivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Nivel4Id");
			}

			if ((entity.getId().getNivel4Nivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNivel4Nivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Nivel4Id");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (entity.getRestrQuema().getRestQuema() == null) {
				throw new ZMessManager().new EmptyFieldException("restQuema_RestrQuema");
			}

			if ((entity.getRestrQuema().getRestQuema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestrQuema().getRestQuema(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restQuema_RestrQuema");
			}

			restriccionQuemaNivel4DAO.update(entity);

			log.debug("update RestriccionQuemaNivel4 successful");
		} catch (Exception e) {
			log.error("update RestriccionQuemaNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<RestriccionQuemaNivel4DTO> getDataRestriccionQuemaNivel4() throws Exception {
		try {
			List<RestriccionQuemaNivel4> restriccionQuemaNivel4 = restriccionQuemaNivel4DAO.findAll();

			List<RestriccionQuemaNivel4DTO> restriccionQuemaNivel4DTO = new ArrayList<RestriccionQuemaNivel4DTO>();

			for (RestriccionQuemaNivel4 restriccionQuemaNivel4Tmp : restriccionQuemaNivel4) {
				RestriccionQuemaNivel4DTO restriccionQuemaNivel4DTO2 = new RestriccionQuemaNivel4DTO();

				restriccionQuemaNivel4DTO2
						.setRestrQuemaRestQuema(restriccionQuemaNivel4Tmp.getId().getRestrQuemaRestQuema());
				restriccionQuemaNivel4DTO2.setNivel4Nivel4Id(restriccionQuemaNivel4Tmp.getId().getNivel4Nivel4Id());
				restriccionQuemaNivel4DTO2
						.setNivel4Id_Nivel4((restriccionQuemaNivel4Tmp.getNivel4().getNivel4Id() != null)
								? restriccionQuemaNivel4Tmp.getNivel4().getNivel4Id() : null);
				restriccionQuemaNivel4DTO2
						.setRestQuema_RestrQuema((restriccionQuemaNivel4Tmp.getRestrQuema().getRestQuema() != null)
								? restriccionQuemaNivel4Tmp.getRestrQuema().getRestQuema() : null);
				restriccionQuemaNivel4DTO.add(restriccionQuemaNivel4DTO2);
			}

			return restriccionQuemaNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RestriccionQuemaNivel4 getRestriccionQuemaNivel4(RestriccionQuemaNivel4Id id) throws Exception {
		log.debug("getting RestriccionQuemaNivel4 instance");

		RestriccionQuemaNivel4 entity = null;

		try {
			entity = restriccionQuemaNivel4DAO.findById(id);
		} catch (Exception e) {
			log.error("get RestriccionQuemaNivel4 failed", e);
			throw new ZMessManager().new FindingException("RestriccionQuemaNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RestriccionQuemaNivel4> findPageRestriccionQuemaNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<RestriccionQuemaNivel4> entity = null;

		try {
			entity = restriccionQuemaNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("RestriccionQuemaNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberRestriccionQuemaNivel4() throws Exception {
		Long entity = null;

		try {
			entity = restriccionQuemaNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("RestriccionQuemaNivel4 Count");
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
	public List<RestriccionQuemaNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<RestriccionQuemaNivel4> list = new ArrayList<RestriccionQuemaNivel4>();
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
			list = restriccionQuemaNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
