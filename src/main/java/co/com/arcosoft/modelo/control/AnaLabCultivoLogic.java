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

import co.com.arcosoft.dataaccess.dao.IAnaLabCultivoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLabCultivo;
import co.com.arcosoft.modelo.dto.AnaLabCultivoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AnaLabCultivoLogic")
public class AnaLabCultivoLogic implements IAnaLabCultivoLogic {
	private static final Logger log = LoggerFactory.getLogger(AnaLabCultivoLogic.class);

	/**
	 * DAO injected by Spring that manages AnaLabCultivo entities
	 *
	 */
	@Autowired
	private IAnaLabCultivoDAO anaLabCultivoDAO;

	/**
	 * Logic injected by Spring that manages AnaLaboratorio entities
	 *
	 */
	@Autowired
	IAnaLaboratorioLogic logicAnaLaboratorio1;

	/**
	 * Logic injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	ICultivoLogic logicCultivo2;

	@Override
	@Transactional(readOnly = true)
	public List<AnaLabCultivo> getAnaLabCultivo() throws Exception {
		log.debug("finding all AnaLabCultivo instances");

		List<AnaLabCultivo> list = new ArrayList<AnaLabCultivo>();

		try {
			list = anaLabCultivoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all AnaLabCultivo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "AnaLabCultivo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAnaLabCultivo(AnaLabCultivo entity) throws Exception {
		log.debug("saving AnaLabCultivo instance");

		try {
			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if (entity.getAnaLabCultId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabCultId");
			}

			if ((entity.getAnaLabCultId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaLabCultId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabCultId");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			if ((entity.getAnaLaboratorio().getAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnaLaboratorio().getAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabId_AnaLaboratorio");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			if (getAnaLabCultivo(entity.getAnaLabCultId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			anaLabCultivoDAO.save(entity);

			log.debug("save AnaLabCultivo successful");
		} catch (Exception e) {
			log.error("save AnaLabCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAnaLabCultivo(AnaLabCultivo entity) throws Exception {
		log.debug("deleting AnaLabCultivo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("AnaLabCultivo");
		}

		if (entity.getAnaLabCultId() == null) {
			throw new ZMessManager().new EmptyFieldException("anaLabCultId");
		}

		try {
			anaLabCultivoDAO.delete(entity);

			log.debug("delete AnaLabCultivo successful");
		} catch (Exception e) {
			log.error("delete AnaLabCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAnaLabCultivo(AnaLabCultivo entity) throws Exception {
		log.debug("updating AnaLabCultivo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("AnaLabCultivo");
			}

			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if (entity.getAnaLabCultId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabCultId");
			}

			if ((entity.getAnaLabCultId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaLabCultId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabCultId");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			if ((entity.getAnaLaboratorio().getAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnaLaboratorio().getAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabId_AnaLaboratorio");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			anaLabCultivoDAO.update(entity);

			log.debug("update AnaLabCultivo successful");
		} catch (Exception e) {
			log.error("update AnaLabCultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaLabCultivoDTO> getDataAnaLabCultivo() throws Exception {
		try {
			List<AnaLabCultivo> anaLabCultivo = anaLabCultivoDAO.findAll();

			List<AnaLabCultivoDTO> anaLabCultivoDTO = new ArrayList<AnaLabCultivoDTO>();

			for (AnaLabCultivo anaLabCultivoTmp : anaLabCultivo) {
				AnaLabCultivoDTO anaLabCultivoDTO2 = new AnaLabCultivoDTO();

				anaLabCultivoDTO2.setAnaLabCultId(anaLabCultivoTmp.getAnaLabCultId());
				anaLabCultivoDTO2
						.setCompania((anaLabCultivoTmp.getCompania() != null) ? anaLabCultivoTmp.getCompania() : null);
				anaLabCultivoDTO2.setFechaCreacion(anaLabCultivoTmp.getFechaCreacion());
				anaLabCultivoDTO2.setFechaModificacion(anaLabCultivoTmp.getFechaModificacion());
				anaLabCultivoDTO2
						.setAnaLabId_AnaLaboratorio((anaLabCultivoTmp.getAnaLaboratorio().getAnaLabId() != null)
								? anaLabCultivoTmp.getAnaLaboratorio().getAnaLabId() : null);

				if (anaLabCultivoTmp.getCultivo() != null) {
					anaLabCultivoDTO2.setCultivoId_Cultivo(anaLabCultivoTmp.getCultivo().getCultivoId());
				} else {
					anaLabCultivoDTO2.setCultivoId_Cultivo(null);
				}

				anaLabCultivoDTO.add(anaLabCultivoDTO2);
			}

			return anaLabCultivoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public AnaLabCultivo getAnaLabCultivo(Long anaLabCultId) throws Exception {
		log.debug("getting AnaLabCultivo instance");

		AnaLabCultivo entity = null;

		try {
			entity = anaLabCultivoDAO.findById(anaLabCultId);
		} catch (Exception e) {
			log.error("get AnaLabCultivo failed", e);
			throw new ZMessManager().new FindingException("AnaLabCultivo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaLabCultivo> findPageAnaLabCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<AnaLabCultivo> entity = null;

		try {
			entity = anaLabCultivoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaLabCultivo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAnaLabCultivo() throws Exception {
		Long entity = null;

		try {
			entity = anaLabCultivoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaLabCultivo Count");
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
	public List<AnaLabCultivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<AnaLabCultivo> list = new ArrayList<AnaLabCultivo>();
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
			list = anaLabCultivoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
