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

import co.com.arcosoft.dataaccess.dao.IListValorDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ListValor;
import co.com.arcosoft.modelo.dto.ListValorDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ListValorLogic")
public class ListValorLogic implements IListValorLogic {
	private static final Logger log = LoggerFactory.getLogger(ListValorLogic.class);

	/**
	 * DAO injected by Spring that manages ListValor entities
	 *
	 */
	@Autowired
	private IListValorDAO listValorDAO;

	/**
	 * Logic injected by Spring that manages Variable entities
	 *
	 */
	@Autowired
	IVariableLogic logicVariable1;

	@Override
	@Transactional(readOnly = true)
	public List<ListValor> getListValor() throws Exception {
		log.debug("finding all ListValor instances");

		List<ListValor> list = new ArrayList<ListValor>();

		try {
			list = listValorDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ListValor failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ListValor");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveListValor(ListValor entity) throws Exception {
		log.debug("saving ListValor instance");

		try {
			if (entity.getVariable() == null) {
				throw new ZMessManager().new ForeignException("variable");
			}

			if ((entity.getClasificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClasificacion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("clasificacion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getValorAlfaNumerico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValorAlfaNumerico(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorAlfaNumerico");
			}

			if ((entity.getValorNumerico() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorNumerico(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorNumerico");
			}

			if (entity.getVariable().getVariableId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableId_Variable");
			}

			if ((entity.getVariable().getVariableId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable().getVariableId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableId_Variable");
			}

			/*
			 * if (getListValor(entity.getListValorId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			listValorDAO.save(entity);

			log.debug("save ListValor successful");
		} catch (Exception e) {
			log.error("save ListValor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteListValor(ListValor entity) throws Exception {
		log.debug("deleting ListValor instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ListValor");
		}

		if (entity.getListValorId() == null) {
			throw new ZMessManager().new EmptyFieldException("listValorId");
		}

		try {
			listValorDAO.delete(entity);

			log.debug("delete ListValor successful");
		} catch (Exception e) {
			log.error("delete ListValor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateListValor(ListValor entity) throws Exception {
		log.debug("updating ListValor instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ListValor");
			}

			if (entity.getVariable() == null) {
				throw new ZMessManager().new ForeignException("variable");
			}

			if ((entity.getClasificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClasificacion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("clasificacion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getListValorId() == null) {
				throw new ZMessManager().new EmptyFieldException("listValorId");
			}

			if ((entity.getListValorId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getListValorId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("listValorId");
			}

			if ((entity.getValorAlfaNumerico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValorAlfaNumerico(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorAlfaNumerico");
			}

			if ((entity.getValorNumerico() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorNumerico(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorNumerico");
			}

			if (entity.getVariable().getVariableId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableId_Variable");
			}

			if ((entity.getVariable().getVariableId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable().getVariableId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableId_Variable");
			}

			listValorDAO.update(entity);

			log.debug("update ListValor successful");
		} catch (Exception e) {
			log.error("update ListValor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ListValorDTO> getDataListValor() throws Exception {
		try {
			List<ListValor> listValor = listValorDAO.findAll();

			List<ListValorDTO> listValorDTO = new ArrayList<ListValorDTO>();

			for (ListValor listValorTmp : listValor) {
				ListValorDTO listValorDTO2 = new ListValorDTO();

				listValorDTO2.setListValorId(listValorTmp.getListValorId());
				listValorDTO2.setClasificacion(
						(listValorTmp.getClasificacion() != null) ? listValorTmp.getClasificacion() : null);
				listValorDTO2.setCodigo((listValorTmp.getCodigo() != null) ? listValorTmp.getCodigo() : null);
				listValorDTO2.setCompania((listValorTmp.getCompania() != null) ? listValorTmp.getCompania() : null);
				listValorDTO2.setFechaCreacion(listValorTmp.getFechaCreacion());
				listValorDTO2.setFechaModificacion(listValorTmp.getFechaModificacion());
				listValorDTO2.setInfoAdicional(
						(listValorTmp.getInfoAdicional() != null) ? listValorTmp.getInfoAdicional() : null);
				listValorDTO2.setInfoAdicional2(
						(listValorTmp.getInfoAdicional2() != null) ? listValorTmp.getInfoAdicional2() : null);
				listValorDTO2.setValorAlfaNumerico(
						(listValorTmp.getValorAlfaNumerico() != null) ? listValorTmp.getValorAlfaNumerico() : null);
				listValorDTO2.setValorNumerico(
						(listValorTmp.getValorNumerico() != null) ? listValorTmp.getValorNumerico() : null);

				if (listValorTmp.getVariable() != null) {
					listValorDTO2.setVariableId_Variable(listValorTmp.getVariable().getVariableId());
				} else {
					listValorDTO2.setVariableId_Variable(null);
				}

				listValorDTO.add(listValorDTO2);
			}

			return listValorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ListValor getListValor(Long listValorId) throws Exception {
		log.debug("getting ListValor instance");

		ListValor entity = null;

		try {
			entity = listValorDAO.findById(listValorId);
		} catch (Exception e) {
			log.error("get ListValor failed", e);
			throw new ZMessManager().new FindingException("ListValor");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ListValor> findPageListValor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<ListValor> entity = null;

		try {
			entity = listValorDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ListValor Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberListValor() throws Exception {
		Long entity = null;

		try {
			entity = listValorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ListValor Count");
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
	public List<ListValor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ListValor> list = new ArrayList<ListValor>();
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
			list = listValorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ListValorDTO> getDataValorByVariableId(Long variableId) throws Exception {
		try {
			List<ListValor> listValor = listValorDAO.findByCriteria("variable.variableId = " + variableId);

			List<ListValorDTO> listValorDTO = new ArrayList<ListValorDTO>();

			for (ListValor listValorTmp : listValor) {
				ListValorDTO listValorDTO2 = new ListValorDTO();

				listValorDTO2.setListValorId(listValorTmp.getListValorId());
				listValorDTO2.setClasificacion(
						(listValorTmp.getClasificacion() != null) ? listValorTmp.getClasificacion() : null);
				listValorDTO2.setCodigo((listValorTmp.getCodigo() != null) ? listValorTmp.getCodigo() : null);
				listValorDTO2.setCompania((listValorTmp.getCompania() != null) ? listValorTmp.getCompania() : null);
				listValorDTO2.setFechaCreacion(listValorTmp.getFechaCreacion());
				listValorDTO2.setFechaModificacion(listValorTmp.getFechaModificacion());
				listValorDTO2.setInfoAdicional(
						(listValorTmp.getInfoAdicional() != null) ? listValorTmp.getInfoAdicional() : null);
				listValorDTO2.setInfoAdicional2(
						(listValorTmp.getInfoAdicional2() != null) ? listValorTmp.getInfoAdicional2() : null);
				listValorDTO2.setValorAlfaNumerico(
						(listValorTmp.getValorAlfaNumerico() != null) ? listValorTmp.getValorAlfaNumerico() : null);
				listValorDTO2.setValorNumerico(
						(listValorTmp.getValorNumerico() != null) ? listValorTmp.getValorNumerico() : null);

				if (listValorTmp.getVariable() != null) {
					listValorDTO2.setVariableId_Variable(listValorTmp.getVariable().getVariableId());
				} else {
					listValorDTO2.setVariableId_Variable(null);
				}

				listValorDTO.add(listValorDTO2);
			}

			return listValorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
