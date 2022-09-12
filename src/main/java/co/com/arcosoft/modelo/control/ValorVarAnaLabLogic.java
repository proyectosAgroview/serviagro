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

import co.com.arcosoft.dataaccess.dao.IValorVarAnaLabDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ValorVarAnaLab;
import co.com.arcosoft.modelo.dto.ValorVarAnaLabDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ValorVarAnaLabLogic")
public class ValorVarAnaLabLogic implements IValorVarAnaLabLogic {
	private static final Logger log = LoggerFactory.getLogger(ValorVarAnaLabLogic.class);

	/**
	 * DAO injected by Spring that manages ValorVarAnaLab entities
	 *
	 */
	@Autowired
	private IValorVarAnaLabDAO valorVarAnaLabDAO;

	/**
	 * Logic injected by Spring that manages DatAnaLaboratorio entities
	 *
	 */
	@Autowired
	IDatAnaLaboratorioLogic logicDatAnaLaboratorio1;

	/**
	 * Logic injected by Spring that manages VariableLab entities
	 *
	 */
	@Autowired
	IVariableLabLogic logicVariableLab2;

	@Override
	@Transactional(readOnly = true)
	public List<ValorVarAnaLab> getValorVarAnaLab() throws Exception {
		log.debug("finding all ValorVarAnaLab instances");

		List<ValorVarAnaLab> list = new ArrayList<ValorVarAnaLab>();

		try {
			list = valorVarAnaLabDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ValorVarAnaLab failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ValorVarAnaLab");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveValorVarAnaLab(ValorVarAnaLab entity) throws Exception {
		log.debug("saving ValorVarAnaLab instance");

		try {
			if (entity.getDatAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("datAnaLaboratorio");
			}

			if (entity.getVariableLab() == null) {
				throw new ZMessManager().new ForeignException("variableLab");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValor(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getValorVarAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("valorVarAnaLabId");
			}

			if ((entity.getValorVarAnaLabId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorVarAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorVarAnaLabId");
			}

			if (entity.getDatAnaLaboratorio().getDatAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("datAnaLabId_DatAnaLaboratorio");
			}

			if ((entity.getDatAnaLaboratorio().getDatAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatAnaLaboratorio().getDatAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datAnaLabId_DatAnaLaboratorio");
			}

			if (entity.getVariableLab().getVariableLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableLabId_VariableLab");
			}

			if ((entity.getVariableLab().getVariableLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getVariableLab().getVariableLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableLabId_VariableLab");
			}

			if (getValorVarAnaLab(entity.getValorVarAnaLabId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			valorVarAnaLabDAO.save(entity);

			log.debug("save ValorVarAnaLab successful");
		} catch (Exception e) {
			log.error("save ValorVarAnaLab failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteValorVarAnaLab(ValorVarAnaLab entity) throws Exception {
		log.debug("deleting ValorVarAnaLab instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ValorVarAnaLab");
		}

		if (entity.getValorVarAnaLabId() == null) {
			throw new ZMessManager().new EmptyFieldException("valorVarAnaLabId");
		}

		try {
			valorVarAnaLabDAO.delete(entity);

			log.debug("delete ValorVarAnaLab successful");
		} catch (Exception e) {
			log.error("delete ValorVarAnaLab failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateValorVarAnaLab(ValorVarAnaLab entity) throws Exception {
		log.debug("updating ValorVarAnaLab instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ValorVarAnaLab");
			}

			if (entity.getDatAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("datAnaLaboratorio");
			}

			if (entity.getVariableLab() == null) {
				throw new ZMessManager().new ForeignException("variableLab");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValor(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getValorVarAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("valorVarAnaLabId");
			}

			if ((entity.getValorVarAnaLabId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorVarAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorVarAnaLabId");
			}

			if (entity.getDatAnaLaboratorio().getDatAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("datAnaLabId_DatAnaLaboratorio");
			}

			if ((entity.getDatAnaLaboratorio().getDatAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatAnaLaboratorio().getDatAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datAnaLabId_DatAnaLaboratorio");
			}

			if (entity.getVariableLab().getVariableLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableLabId_VariableLab");
			}

			if ((entity.getVariableLab().getVariableLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getVariableLab().getVariableLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableLabId_VariableLab");
			}

			valorVarAnaLabDAO.update(entity);

			log.debug("update ValorVarAnaLab successful");
		} catch (Exception e) {
			log.error("update ValorVarAnaLab failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ValorVarAnaLabDTO> getDataValorVarAnaLab() throws Exception {
		try {
			List<ValorVarAnaLab> valorVarAnaLab = valorVarAnaLabDAO.findAll();

			List<ValorVarAnaLabDTO> valorVarAnaLabDTO = new ArrayList<ValorVarAnaLabDTO>();

			for (ValorVarAnaLab valorVarAnaLabTmp : valorVarAnaLab) {
				ValorVarAnaLabDTO valorVarAnaLabDTO2 = new ValorVarAnaLabDTO();

				valorVarAnaLabDTO2.setValorVarAnaLabId(valorVarAnaLabTmp.getValorVarAnaLabId());
				valorVarAnaLabDTO2.setFechaCreacion(valorVarAnaLabTmp.getFechaCreacion());
				valorVarAnaLabDTO2.setFechaModificacion(valorVarAnaLabTmp.getFechaModificacion());
				valorVarAnaLabDTO2
						.setValor((valorVarAnaLabTmp.getValor() != null) ? valorVarAnaLabTmp.getValor() : null);
				valorVarAnaLabDTO2.setDatAnaLabId_DatAnaLaboratorio(
						(valorVarAnaLabTmp.getDatAnaLaboratorio().getDatAnaLabId() != null)
								? valorVarAnaLabTmp.getDatAnaLaboratorio().getDatAnaLabId() : null);
				valorVarAnaLabDTO2
						.setVariableLabId_VariableLab((valorVarAnaLabTmp.getVariableLab().getVariableLabId() != null)
								? valorVarAnaLabTmp.getVariableLab().getVariableLabId() : null);
				valorVarAnaLabDTO.add(valorVarAnaLabDTO2);
			}

			return valorVarAnaLabDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ValorVarAnaLab getValorVarAnaLab(Long valorVarAnaLabId) throws Exception {
		log.debug("getting ValorVarAnaLab instance");

		ValorVarAnaLab entity = null;

		try {
			entity = valorVarAnaLabDAO.findById(valorVarAnaLabId);
		} catch (Exception e) {
			log.error("get ValorVarAnaLab failed", e);
			throw new ZMessManager().new FindingException("ValorVarAnaLab");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ValorVarAnaLab> findPageValorVarAnaLab(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ValorVarAnaLab> entity = null;

		try {
			entity = valorVarAnaLabDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ValorVarAnaLab Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberValorVarAnaLab() throws Exception {
		Long entity = null;

		try {
			entity = valorVarAnaLabDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ValorVarAnaLab Count");
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
	public List<ValorVarAnaLab> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ValorVarAnaLab> list = new ArrayList<ValorVarAnaLab>();
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
			list = valorVarAnaLabDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
