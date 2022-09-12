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

import co.com.arcosoft.dataaccess.dao.IRestriMaduranteNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.RestriMaduranteNivel4;
import co.com.arcosoft.modelo.RestriMaduranteNivel4Id;
import co.com.arcosoft.modelo.dto.RestriMaduranteNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("RestriMaduranteNivel4Logic")
public class RestriMaduranteNivel4Logic implements IRestriMaduranteNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(RestriMaduranteNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages RestriMaduranteNivel4 entities
	 *
	 */
	@Autowired
	private IRestriMaduranteNivel4DAO restriMaduranteNivel4DAO;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel41;

	/**
	 * Logic injected by Spring that manages RestrMadurante entities
	 *
	 */
	@Autowired
	IRestrMaduranteLogic logicRestrMadurante2;

	@Override
	@Transactional(readOnly = true)
	public List<RestriMaduranteNivel4> getRestriMaduranteNivel4() throws Exception {
		log.debug("finding all RestriMaduranteNivel4 instances");

		List<RestriMaduranteNivel4> list = new ArrayList<RestriMaduranteNivel4>();

		try {
			list = restriMaduranteNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all RestriMaduranteNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "RestriMaduranteNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception {
		log.debug("saving RestriMaduranteNivel4 instance");

		try {
			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getRestrMadurante() == null) {
				throw new ZMessManager().new ForeignException("restrMadurante");
			}

			if (entity.getId().getRestrMaduranteRestMaduId() == null) {
				throw new ZMessManager().new EmptyFieldException("restrMaduranteRestMaduId");
			}

			if ((entity.getId().getRestrMaduranteRestMaduId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getId().getRestrMaduranteRestMaduId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restrMaduranteRestMaduId");
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

			if (entity.getRestrMadurante().getRestMaduId() == null) {
				throw new ZMessManager().new EmptyFieldException("restMaduId_RestrMadurante");
			}

			if ((entity.getRestrMadurante().getRestMaduId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getRestrMadurante().getRestMaduId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restMaduId_RestrMadurante");
			}

			if (getRestriMaduranteNivel4(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			restriMaduranteNivel4DAO.save(entity);

			log.debug("save RestriMaduranteNivel4 successful");
		} catch (Exception e) {
			log.error("save RestriMaduranteNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception {
		log.debug("deleting RestriMaduranteNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("RestriMaduranteNivel4");
		}

		if (entity.getId().getRestrMaduranteRestMaduId() == null) {
			throw new ZMessManager().new EmptyFieldException("restrMaduranteRestMaduId");
		}

		if (entity.getId().getNivel4Nivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel4Nivel4Id");
		}

		try {
			restriMaduranteNivel4DAO.delete(entity);

			log.debug("delete RestriMaduranteNivel4 successful");
		} catch (Exception e) {
			log.error("delete RestriMaduranteNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception {
		log.debug("updating RestriMaduranteNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("RestriMaduranteNivel4");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getRestrMadurante() == null) {
				throw new ZMessManager().new ForeignException("restrMadurante");
			}

			if (entity.getId().getRestrMaduranteRestMaduId() == null) {
				throw new ZMessManager().new EmptyFieldException("restrMaduranteRestMaduId");
			}

			if ((entity.getId().getRestrMaduranteRestMaduId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getId().getRestrMaduranteRestMaduId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restrMaduranteRestMaduId");
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

			if (entity.getRestrMadurante().getRestMaduId() == null) {
				throw new ZMessManager().new EmptyFieldException("restMaduId_RestrMadurante");
			}

			if ((entity.getRestrMadurante().getRestMaduId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getRestrMadurante().getRestMaduId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restMaduId_RestrMadurante");
			}

			restriMaduranteNivel4DAO.update(entity);

			log.debug("update RestriMaduranteNivel4 successful");
		} catch (Exception e) {
			log.error("update RestriMaduranteNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<RestriMaduranteNivel4DTO> getDataRestriMaduranteNivel4() throws Exception {
		try {
			List<RestriMaduranteNivel4> restriMaduranteNivel4 = restriMaduranteNivel4DAO.findAll();

			List<RestriMaduranteNivel4DTO> restriMaduranteNivel4DTO = new ArrayList<RestriMaduranteNivel4DTO>();

			for (RestriMaduranteNivel4 restriMaduranteNivel4Tmp : restriMaduranteNivel4) {
				RestriMaduranteNivel4DTO restriMaduranteNivel4DTO2 = new RestriMaduranteNivel4DTO();

				restriMaduranteNivel4DTO2
						.setRestrMaduranteRestMaduId(restriMaduranteNivel4Tmp.getId().getRestrMaduranteRestMaduId());
				restriMaduranteNivel4DTO2.setNivel4Nivel4Id(restriMaduranteNivel4Tmp.getId().getNivel4Nivel4Id());
				restriMaduranteNivel4DTO2
						.setNivel4Id_Nivel4((restriMaduranteNivel4Tmp.getNivel4().getNivel4Id() != null)
								? restriMaduranteNivel4Tmp.getNivel4().getNivel4Id() : null);
				restriMaduranteNivel4DTO2.setRestMaduId_RestrMadurante(
						(restriMaduranteNivel4Tmp.getRestrMadurante().getRestMaduId() != null)
								? restriMaduranteNivel4Tmp.getRestrMadurante().getRestMaduId() : null);
				restriMaduranteNivel4DTO.add(restriMaduranteNivel4DTO2);
			}

			return restriMaduranteNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RestriMaduranteNivel4 getRestriMaduranteNivel4(RestriMaduranteNivel4Id id) throws Exception {
		log.debug("getting RestriMaduranteNivel4 instance");

		RestriMaduranteNivel4 entity = null;

		try {
			entity = restriMaduranteNivel4DAO.findById(id);
		} catch (Exception e) {
			log.error("get RestriMaduranteNivel4 failed", e);
			throw new ZMessManager().new FindingException("RestriMaduranteNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RestriMaduranteNivel4> findPageRestriMaduranteNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<RestriMaduranteNivel4> entity = null;

		try {
			entity = restriMaduranteNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("RestriMaduranteNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberRestriMaduranteNivel4() throws Exception {
		Long entity = null;

		try {
			entity = restriMaduranteNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("RestriMaduranteNivel4 Count");
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
	public List<RestriMaduranteNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<RestriMaduranteNivel4> list = new ArrayList<RestriMaduranteNivel4>();
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
			list = restriMaduranteNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
