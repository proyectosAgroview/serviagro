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

import co.com.arcosoft.dataaccess.dao.IAnioFiscalDAO;
import co.com.arcosoft.dataaccess.dao.ICalendarioDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnioFiscal;
import co.com.arcosoft.modelo.Calendario;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.AnioFiscalDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AnioFiscalLogic")
public class AnioFiscalLogic implements IAnioFiscalLogic {
	private static final Logger log = LoggerFactory.getLogger(AnioFiscalLogic.class);

	/**
	 * DAO injected by Spring that manages AnioFiscal entities
	 *
	 */
	@Autowired
	private IAnioFiscalDAO anioFiscalDAO;

	/**
	 * DAO injected by Spring that manages Calendario entities
	 *
	 */
	@Autowired
	private ICalendarioDAO calendarioDAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	@Override
	@Transactional(readOnly = true)
	public List<AnioFiscal> getAnioFiscal() throws Exception {
		log.debug("finding all AnioFiscal instances");

		List<AnioFiscal> list = new ArrayList<AnioFiscal>();

		try {
			list = anioFiscalDAO.findAll();
		} catch (Exception e) {
			log.error("finding all AnioFiscal failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "AnioFiscal");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAnioFiscal(AnioFiscal entity) throws Exception {
		log.debug("saving AnioFiscal instance");

		try {

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			/*
			 * if (entity.getAnioFiscalId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("anioFiscalId"); }
			 * 
			 * if ((entity.getAnioFiscalId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAnioFiscalId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "anioFiscalId"); } if
			 * (getAnioFiscal(entity.getAnioFiscalId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			anioFiscalDAO.save(entity);

			log.debug("save AnioFiscal successful");
		} catch (Exception e) {
			log.error("save AnioFiscal failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAnioFiscal(AnioFiscal entity) throws Exception {
		log.debug("deleting AnioFiscal instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("AnioFiscal");
		}

		if (entity.getAnioFiscalId() == null) {
			throw new ZMessManager().new EmptyFieldException("anioFiscalId");
		}

		List<Calendario> calendarios = null;
		List<Nivel4> nivel4s = null;

		try {
			calendarios = calendarioDAO.findByProperty("anioFiscal.anioFiscalId", entity.getAnioFiscalId());

			if (Utilities.validationsList(calendarios) == true) {
				throw new ZMessManager().new DeletingException("calendarios");
			}

			nivel4s = nivel4DAO.findByProperty("anioFiscal.anioFiscalId", entity.getAnioFiscalId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			anioFiscalDAO.delete(entity);

			log.debug("delete AnioFiscal successful");
		} catch (Exception e) {
			log.error("delete AnioFiscal failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAnioFiscal(AnioFiscal entity) throws Exception {
		log.debug("updating AnioFiscal instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("AnioFiscal");
			}

			if (entity.getAnioFiscalId() == null) {
				throw new ZMessManager().new EmptyFieldException("anioFiscalId");
			}

			if ((entity.getAnioFiscalId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalId");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			anioFiscalDAO.update(entity);

			log.debug("update AnioFiscal successful");
		} catch (Exception e) {
			log.error("update AnioFiscal failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnioFiscalDTO> getDataAnioFiscal() throws Exception {
		try {
			List<AnioFiscal> anioFiscal = anioFiscalDAO.findAll();

			List<AnioFiscalDTO> anioFiscalDTO = new ArrayList<AnioFiscalDTO>();

			for (AnioFiscal anioFiscalTmp : anioFiscal) {
				AnioFiscalDTO anioFiscalDTO2 = new AnioFiscalDTO();

				anioFiscalDTO2.setAnioFiscalId(anioFiscalTmp.getAnioFiscalId());
				anioFiscalDTO2.setCodigo((anioFiscalTmp.getCodigo() != null) ? anioFiscalTmp.getCodigo() : null);
				anioFiscalDTO2.setEstado((anioFiscalTmp.getEstado() != null) ? anioFiscalTmp.getEstado() : null);
				anioFiscalDTO2.setFechaCreacion(anioFiscalTmp.getFechaCreacion());
				anioFiscalDTO2
						.setFechaFinal((anioFiscalTmp.getFechaFinal() != null) ? anioFiscalTmp.getFechaFinal() : null);
				anioFiscalDTO2.setFechaInicial(
						(anioFiscalTmp.getFechaInicial() != null) ? anioFiscalTmp.getFechaInicial() : null);
				anioFiscalDTO2.setFechaModificacion(anioFiscalTmp.getFechaModificacion());
				anioFiscalDTO2.setInfoAdicional(
						(anioFiscalTmp.getInfoAdicional() != null) ? anioFiscalTmp.getInfoAdicional() : null);
				anioFiscalDTO2.setInfoAdicional2(
						(anioFiscalTmp.getInfoAdicional2() != null) ? anioFiscalTmp.getInfoAdicional2() : null);
				anioFiscalDTO2.setNombre((anioFiscalTmp.getNombre() != null) ? anioFiscalTmp.getNombre() : null);
				anioFiscalDTO.add(anioFiscalDTO2);
			}

			return anioFiscalDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public AnioFiscal getAnioFiscal(Long anioFiscalId) throws Exception {
		log.debug("getting AnioFiscal instance");

		AnioFiscal entity = null;

		try {
			entity = anioFiscalDAO.findById(anioFiscalId);
		} catch (Exception e) {
			log.error("get AnioFiscal failed", e);
			throw new ZMessManager().new FindingException("AnioFiscal");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnioFiscal> findPageAnioFiscal(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<AnioFiscal> entity = null;

		try {
			entity = anioFiscalDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnioFiscal Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAnioFiscal() throws Exception {
		Long entity = null;

		try {
			entity = anioFiscalDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnioFiscal Count");
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
	public List<AnioFiscal> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<AnioFiscal> list = new ArrayList<AnioFiscal>();
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
			list = anioFiscalDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
