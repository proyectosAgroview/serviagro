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

import co.com.arcosoft.dataaccess.dao.IFactorConversionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.FactorConversion;
import co.com.arcosoft.modelo.dto.FactorConversionDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("FactorConversionLogic")
public class FactorConversionLogic implements IFactorConversionLogic {
	private static final Logger log = LoggerFactory.getLogger(FactorConversionLogic.class);

	/**
	 * DAO injected by Spring that manages FactorConversion entities
	 *
	 */
	@Autowired
	private IFactorConversionDAO factorConversionDAO;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed1;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed2;

	@Override
	@Transactional(readOnly = true)
	public List<FactorConversion> getFactorConversion() throws Exception {
		log.debug("finding all FactorConversion instances");

		List<FactorConversion> list = new ArrayList<FactorConversion>();

		try {
			list = factorConversionDAO.findAll();
		} catch (Exception e) {
			log.error("finding all FactorConversion failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "FactorConversion");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveFactorConversion(FactorConversion entity) throws Exception {
		log.debug("saving FactorConversion instance");

		try {
			if (entity.getUdadMedByUnadMedOrigenId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUnadMedOrigenId");
			}

			if (entity.getUdadMedByUndadMedDestId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUndadMedDestId");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFactorConversion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFactorConversion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("factorConversion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getUdadMedByUnadMedOrigenId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUnadMedOrigenId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUnadMedOrigenId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (entity.getUdadMedByUndadMedDestId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUndadMedDestId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUndadMedDestId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (entity.getFactorConversionId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "factorConversionId"); }
			 * 
			 * if ((entity.getFactorConversionId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFactorConversionId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "factorConversionId"); } if
			 * (getFactorConversion(entity.getFactorConversionId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			factorConversionDAO.save(entity);

			log.debug("save FactorConversion successful");
		} catch (Exception e) {
			log.error("save FactorConversion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteFactorConversion(FactorConversion entity) throws Exception {
		log.debug("deleting FactorConversion instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("FactorConversion");
		}

		if (entity.getFactorConversionId() == null) {
			throw new ZMessManager().new EmptyFieldException("factorConversionId");
		}

		try {
			factorConversionDAO.delete(entity);

			log.debug("delete FactorConversion successful");
		} catch (Exception e) {
			log.error("delete FactorConversion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateFactorConversion(FactorConversion entity) throws Exception {
		log.debug("updating FactorConversion instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("FactorConversion");
			}

			if (entity.getUdadMedByUnadMedOrigenId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUnadMedOrigenId");
			}

			if (entity.getUdadMedByUndadMedDestId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUndadMedDestId");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFactorConversion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFactorConversion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("factorConversion");
			}

			if (entity.getFactorConversionId() == null) {
				throw new ZMessManager().new EmptyFieldException("factorConversionId");
			}

			if ((entity.getFactorConversionId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFactorConversionId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("factorConversionId");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getUdadMedByUnadMedOrigenId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUnadMedOrigenId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUnadMedOrigenId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (entity.getUdadMedByUndadMedDestId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUndadMedDestId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUndadMedDestId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			factorConversionDAO.update(entity);

			log.debug("update FactorConversion successful");
		} catch (Exception e) {
			log.error("update FactorConversion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<FactorConversionDTO> getDataFactorConversion() throws Exception {
		try {
			List<FactorConversion> factorConversion = factorConversionDAO.findAll();

			List<FactorConversionDTO> factorConversionDTO = new ArrayList<FactorConversionDTO>();

			for (FactorConversion factorConversionTmp : factorConversion) {
				FactorConversionDTO factorConversionDTO2 = new FactorConversionDTO();

				factorConversionDTO2.setFactorConversionId(factorConversionTmp.getFactorConversionId());
				factorConversionDTO2
						.setCodigo((factorConversionTmp.getCodigo() != null) ? factorConversionTmp.getCodigo() : null);
				factorConversionDTO2.setCompania(
						(factorConversionTmp.getCompania() != null) ? factorConversionTmp.getCompania() : null);
				factorConversionDTO2
						.setEstado((factorConversionTmp.getEstado() != null) ? factorConversionTmp.getEstado() : null);
				factorConversionDTO2.setFactorConversion((factorConversionTmp.getFactorConversion() != null)
						? factorConversionTmp.getFactorConversion() : null);
				factorConversionDTO2.setFechaCreacion(factorConversionTmp.getFechaCreacion());
				factorConversionDTO2.setFechaModificacion(factorConversionTmp.getFechaModificacion());
				factorConversionDTO2.setInfoAdicional((factorConversionTmp.getInfoAdicional() != null)
						? factorConversionTmp.getInfoAdicional() : null);
				factorConversionDTO2.setInfoAdicional2((factorConversionTmp.getInfoAdicional2() != null)
						? factorConversionTmp.getInfoAdicional2() : null);
				factorConversionDTO2
						.setNombre((factorConversionTmp.getNombre() != null) ? factorConversionTmp.getNombre() : null);
				factorConversionDTO2.setUdadMedByUnadMedOrigenId(
						(factorConversionTmp.getUdadMedByUnadMedOrigenId().getUdadMedId() != null)
								? factorConversionTmp.getUdadMedByUnadMedOrigenId().getUdadMedId() : null);
				factorConversionDTO2.setUdadMedByUndadMedDestId(
						(factorConversionTmp.getUdadMedByUndadMedDestId().getUdadMedId() != null)
								? factorConversionTmp.getUdadMedByUndadMedDestId().getUdadMedId() : null);

				factorConversionDTO.add(factorConversionDTO2);

			}

			return factorConversionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FactorConversion getFactorConversion(Long factorConversionId) throws Exception {
		log.debug("getting FactorConversion instance");

		FactorConversion entity = null;

		try {
			entity = factorConversionDAO.findById(factorConversionId);
		} catch (Exception e) {
			log.error("get FactorConversion failed", e);
			throw new ZMessManager().new FindingException("FactorConversion");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FactorConversion> findPageFactorConversion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<FactorConversion> entity = null;

		try {
			entity = factorConversionDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FactorConversion Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFactorConversion() throws Exception {
		Long entity = null;

		try {
			entity = factorConversionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FactorConversion Count");
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
	public List<FactorConversion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<FactorConversion> list = new ArrayList<FactorConversion>();
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
			list = factorConversionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
