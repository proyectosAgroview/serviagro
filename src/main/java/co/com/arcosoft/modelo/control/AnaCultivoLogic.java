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

import co.com.arcosoft.dataaccess.dao.IAnaCultivoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaCultivo;
import co.com.arcosoft.modelo.dto.AnaCultivoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AnaCultivoLogic")
public class AnaCultivoLogic implements IAnaCultivoLogic {
	private static final Logger log = LoggerFactory.getLogger(AnaCultivoLogic.class);

	/**
	 * DAO injected by Spring that manages AnaCultivo entities
	 *
	 */
	@Autowired
	private IAnaCultivoDAO anaCultivoDAO;

	/**
	 * Logic injected by Spring that manages AnaSanVeg entities
	 *
	 */
	@Autowired
	IAnaSanVegLogic logicAnaSanVeg1;

	/**
	 * Logic injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	ICultivoLogic logicCultivo2;

	@Override
	@Transactional(readOnly = true)
	public List<AnaCultivo> getAnaCultivo() throws Exception {
		log.debug("finding all AnaCultivo instances");

		List<AnaCultivo> list = new ArrayList<AnaCultivo>();

		try {
			list = anaCultivoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all AnaCultivo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "AnaCultivo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAnaCultivo(AnaCultivo entity) throws Exception {
		log.debug("saving AnaCultivo instance");

		try {
			if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if (entity.getAnaCultId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaCultId");
			}

			if ((entity.getAnaCultId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaCultId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaCultId");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}


			anaCultivoDAO.save(entity);

			log.debug("save AnaCultivo successful");
		} catch (Exception e) {
			log.error("save AnaCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAnaCultivo(AnaCultivo entity) throws Exception {
		log.debug("deleting AnaCultivo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("AnaCultivo");
		}

		if (entity.getAnaCultId() == null) {
			throw new ZMessManager().new EmptyFieldException("anaCultId");
		}

		try {
			anaCultivoDAO.delete(entity);

			log.debug("delete AnaCultivo successful");
		} catch (Exception e) {
			log.error("delete AnaCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAnaCultivo(AnaCultivo entity) throws Exception {
		log.debug("updating AnaCultivo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("AnaCultivo");
			}

			if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if (entity.getAnaCultId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaCultId");
			}

			if ((entity.getAnaCultId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaCultId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaCultId");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			anaCultivoDAO.update(entity);

			log.debug("update AnaCultivo successful");
		} catch (Exception e) {
			log.error("update AnaCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaCultivoDTO> getDataAnaCultivo() throws Exception {
		try {
			List<AnaCultivo> anaCultivo = anaCultivoDAO.findAll();

			List<AnaCultivoDTO> anaCultivoDTO = new ArrayList<AnaCultivoDTO>();

			for (AnaCultivo anaCultivoTmp : anaCultivo) {
				AnaCultivoDTO anaCultivoDTO2 = new AnaCultivoDTO();

				anaCultivoDTO2.setAnaCultId(anaCultivoTmp.getAnaCultId());
				anaCultivoDTO2.setCompania((anaCultivoTmp.getCompania() != null) ? anaCultivoTmp.getCompania() : null);
				anaCultivoDTO2.setFechaCreacion(anaCultivoTmp.getFechaCreacion());
				anaCultivoDTO2.setFechaModificacion(anaCultivoTmp.getFechaModificacion());
				anaCultivoDTO2.setAnaSanVegId_AnaSanVeg((anaCultivoTmp.getAnaSanVeg().getAnaSanVegId() != null)
						? anaCultivoTmp.getAnaSanVeg().getAnaSanVegId() : null);

				if (anaCultivoTmp.getCultivo() != null) {
					anaCultivoDTO2.setCultivoId_Cultivo(anaCultivoTmp.getCultivo().getCultivoId());
				} else {
					anaCultivoDTO2.setCultivoId_Cultivo(null);
				}

				anaCultivoDTO.add(anaCultivoDTO2);
			}

			return anaCultivoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public AnaCultivo getAnaCultivo(Long anaCultId) throws Exception {
		log.debug("getting AnaCultivo instance");

		AnaCultivo entity = null;

		try {
			entity = anaCultivoDAO.findById(anaCultId);
		} catch (Exception e) {
			log.error("get AnaCultivo failed", e);
			throw new ZMessManager().new FindingException("AnaCultivo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaCultivo> findPageAnaCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<AnaCultivo> entity = null;

		try {
			entity = anaCultivoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaCultivo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAnaCultivo() throws Exception {
		Long entity = null;

		try {
			entity = anaCultivoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaCultivo Count");
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
	public List<AnaCultivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<AnaCultivo> list = new ArrayList<AnaCultivo>();
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
			list = anaCultivoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
