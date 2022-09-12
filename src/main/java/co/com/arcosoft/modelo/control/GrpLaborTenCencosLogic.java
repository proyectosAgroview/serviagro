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

import co.com.arcosoft.dataaccess.dao.IGrpLaborTenCencosDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.GrpLaborTenCencos;
import co.com.arcosoft.modelo.GrpLaborTenCencosId;
import co.com.arcosoft.modelo.dto.GrpLaborTenCencosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("GrpLaborTenCencosLogic")
public class GrpLaborTenCencosLogic implements IGrpLaborTenCencosLogic {
	private static final Logger log = LoggerFactory.getLogger(GrpLaborTenCencosLogic.class);

	/**
	 * DAO injected by Spring that manages GrpLaborTenCencos entities
	 *
	 */
	@Autowired
	private IGrpLaborTenCencosDAO grpLaborTenCencosDAO;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost1;

	/**
	 * Logic injected by Spring that manages GrpLabor entities
	 *
	 */
	@Autowired
	IGrpLaborLogic logicGrpLabor2;

	/**
	 * Logic injected by Spring that manages Tenencia entities
	 *
	 */
	@Autowired
	ITenenciaLogic logicTenencia3;

	@Override
	@Transactional(readOnly = true)
	public List<GrpLaborTenCencos> getGrpLaborTenCencos() throws Exception {
		log.debug("finding all GrpLaborTenCencos instances");

		List<GrpLaborTenCencos> list = new ArrayList<GrpLaborTenCencos>();

		try {
			list = grpLaborTenCencosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all GrpLaborTenCencos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "GrpLaborTenCencos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception {
		log.debug("saving GrpLaborTenCencos instance");

		try {
			if (entity.getCentCost() == null) {
				throw new ZMessManager().new ForeignException("centCost");
			}

			if (entity.getGrpLabor() == null) {
				throw new ZMessManager().new ForeignException("grpLabor");
			}

			if (entity.getTenencia() == null) {
				throw new ZMessManager().new ForeignException("tenencia");
			}

			if (entity.getId().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId");
			}

			if ((entity.getId().getGrpLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getGrpLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId");
			}

			if (entity.getId().getCentCostId() == null) {
				throw new ZMessManager().new EmptyFieldException("centCostId");
			}

			if ((entity.getId().getCentCostId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCentCostId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId");
			}

			if (entity.getId().getTenenId() == null) {
				throw new ZMessManager().new EmptyFieldException("tenenId");
			}

			if ((entity.getId().getTenenId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getTenenId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tenenId");
			}

			if (entity.getCentCost().getCentCostId() == null) {
				throw new ZMessManager().new EmptyFieldException("centCostId_CentCost");
			}

			if ((entity.getCentCost().getCentCostId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost().getCentCostId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			if (entity.getGrpLabor().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId_GrpLabor");
			}

			if ((entity.getGrpLabor().getGrpLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpLabor().getGrpLaborId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId_GrpLabor");
			}

			if (entity.getTenencia().getTenenId() == null) {
				throw new ZMessManager().new EmptyFieldException("tenenId_Tenencia");
			}

			if ((entity.getTenencia().getTenenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTenencia().getTenenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tenenId_Tenencia");
			}

			if (getGrpLaborTenCencos(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			grpLaborTenCencosDAO.save(entity);

			log.debug("save GrpLaborTenCencos successful");
		} catch (Exception e) {
			log.error("save GrpLaborTenCencos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception {
		log.debug("deleting GrpLaborTenCencos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("GrpLaborTenCencos");
		}

		if (entity.getId().getGrpLaborId() == null) {
			throw new ZMessManager().new EmptyFieldException("grpLaborId");
		}

		if (entity.getId().getCentCostId() == null) {
			throw new ZMessManager().new EmptyFieldException("centCostId");
		}

		if (entity.getId().getTenenId() == null) {
			throw new ZMessManager().new EmptyFieldException("tenenId");
		}

		try {
			grpLaborTenCencosDAO.delete(entity);

			log.debug("delete GrpLaborTenCencos successful");
		} catch (Exception e) {
			log.error("delete GrpLaborTenCencos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception {
		log.debug("updating GrpLaborTenCencos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("GrpLaborTenCencos");
			}

			if (entity.getCentCost() == null) {
				throw new ZMessManager().new ForeignException("centCost");
			}

			if (entity.getGrpLabor() == null) {
				throw new ZMessManager().new ForeignException("grpLabor");
			}

			if (entity.getTenencia() == null) {
				throw new ZMessManager().new ForeignException("tenencia");
			}

			if (entity.getId().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId");
			}

			if ((entity.getId().getGrpLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getGrpLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId");
			}

			if (entity.getId().getCentCostId() == null) {
				throw new ZMessManager().new EmptyFieldException("centCostId");
			}

			if ((entity.getId().getCentCostId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCentCostId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId");
			}

			if (entity.getId().getTenenId() == null) {
				throw new ZMessManager().new EmptyFieldException("tenenId");
			}

			if ((entity.getId().getTenenId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getTenenId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tenenId");
			}

			if (entity.getCentCost().getCentCostId() == null) {
				throw new ZMessManager().new EmptyFieldException("centCostId_CentCost");
			}

			if ((entity.getCentCost().getCentCostId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost().getCentCostId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			if (entity.getGrpLabor().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId_GrpLabor");
			}

			if ((entity.getGrpLabor().getGrpLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpLabor().getGrpLaborId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId_GrpLabor");
			}

			if (entity.getTenencia().getTenenId() == null) {
				throw new ZMessManager().new EmptyFieldException("tenenId_Tenencia");
			}

			if ((entity.getTenencia().getTenenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTenencia().getTenenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tenenId_Tenencia");
			}

			grpLaborTenCencosDAO.update(entity);

			log.debug("update GrpLaborTenCencos successful");
		} catch (Exception e) {
			log.error("update GrpLaborTenCencos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<GrpLaborTenCencosDTO> getDataGrpLaborTenCencos() throws Exception {
		try {
			List<GrpLaborTenCencos> grpLaborTenCencos = grpLaborTenCencosDAO.findAll();

			List<GrpLaborTenCencosDTO> grpLaborTenCencosDTO = new ArrayList<GrpLaborTenCencosDTO>();

			for (GrpLaborTenCencos grpLaborTenCencosTmp : grpLaborTenCencos) {
				GrpLaborTenCencosDTO grpLaborTenCencosDTO2 = new GrpLaborTenCencosDTO();

				grpLaborTenCencosDTO2.setGrpLaborId(grpLaborTenCencosTmp.getId().getGrpLaborId());
				grpLaborTenCencosDTO2.setCentCostId(grpLaborTenCencosTmp.getId().getCentCostId());
				grpLaborTenCencosDTO2.setTenenId(grpLaborTenCencosTmp.getId().getTenenId());
				grpLaborTenCencosDTO2
						.setCentCostId_CentCost((grpLaborTenCencosTmp.getCentCost().getCentCostId() != null)
								? grpLaborTenCencosTmp.getCentCost().getCentCostId() : null);
				grpLaborTenCencosDTO2
						.setGrpLaborId_GrpLabor((grpLaborTenCencosTmp.getGrpLabor().getGrpLaborId() != null)
								? grpLaborTenCencosTmp.getGrpLabor().getGrpLaborId() : null);
				grpLaborTenCencosDTO2.setTenenId_Tenencia((grpLaborTenCencosTmp.getTenencia().getTenenId() != null)
						? grpLaborTenCencosTmp.getTenencia().getTenenId() : null);
				grpLaborTenCencosDTO.add(grpLaborTenCencosDTO2);
			}

			return grpLaborTenCencosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public GrpLaborTenCencos getGrpLaborTenCencos(GrpLaborTenCencosId id) throws Exception {
		log.debug("getting GrpLaborTenCencos instance");

		GrpLaborTenCencos entity = null;

		try {
			entity = grpLaborTenCencosDAO.findById(id);
		} catch (Exception e) {
			log.error("get GrpLaborTenCencos failed", e);
			throw new ZMessManager().new FindingException("GrpLaborTenCencos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<GrpLaborTenCencos> findPageGrpLaborTenCencos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<GrpLaborTenCencos> entity = null;

		try {
			entity = grpLaborTenCencosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("GrpLaborTenCencos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberGrpLaborTenCencos() throws Exception {
		Long entity = null;

		try {
			entity = grpLaborTenCencosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("GrpLaborTenCencos Count");
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
	public List<GrpLaborTenCencos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<GrpLaborTenCencos> list = new ArrayList<GrpLaborTenCencos>();
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
			list = grpLaborTenCencosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
