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

import co.com.arcosoft.dataaccess.dao.IClaseTextSueloDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ClaseTextSuelo;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.ClaseTextSueloDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ClaseTextSueloLogic")
public class ClaseTextSueloLogic implements IClaseTextSueloLogic {
	private static final Logger log = LoggerFactory.getLogger(ClaseTextSueloLogic.class);

	/**
	 * DAO injected by Spring that manages ClaseTextSuelo entities
	 *
	 */
	@Autowired
	private IClaseTextSueloDAO claseTextSueloDAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	@Override
	@Transactional(readOnly = true)
	public List<ClaseTextSuelo> getClaseTextSuelo() throws Exception {
		log.debug("finding all ClaseTextSuelo instances");

		List<ClaseTextSuelo> list = new ArrayList<ClaseTextSuelo>();

		try {
			list = claseTextSueloDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ClaseTextSuelo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ClaseTextSuelo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
		log.debug("saving ClaseTextSuelo instance");

		try {

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
			 * if (entity.getClaseTextSueloId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "claseTextSueloId"); }
			 * 
			 * if ((entity.getClaseTextSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getClaseTextSueloId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "claseTextSueloId");
			 * }
			 * 
			 * 
			 * if (getClaseTextSuelo(entity.getClaseTextSueloId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			claseTextSueloDAO.save(entity);

			log.debug("save ClaseTextSuelo successful");
		} catch (Exception e) {
			log.error("save ClaseTextSuelo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
		log.debug("deleting ClaseTextSuelo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ClaseTextSuelo");
		}

		if (entity.getClaseTextSueloId() == null) {
			throw new ZMessManager().new EmptyFieldException("claseTextSueloId");
		}

		List<Nivel4> nivel4s = null;

		try {
			nivel4s = nivel4DAO.findByProperty("claseTextSuelo.claseTextSueloId", entity.getClaseTextSueloId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			claseTextSueloDAO.delete(entity);

			log.debug("delete ClaseTextSuelo successful");
		} catch (Exception e) {
			log.error("delete ClaseTextSuelo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
		log.debug("updating ClaseTextSuelo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ClaseTextSuelo");
			}

			if (entity.getClaseTextSueloId() == null) {
				throw new ZMessManager().new EmptyFieldException("claseTextSueloId");
			}

			if ((entity.getClaseTextSueloId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getClaseTextSueloId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseTextSueloId");
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

			claseTextSueloDAO.update(entity);

			log.debug("update ClaseTextSuelo successful");
		} catch (Exception e) {
			log.error("update ClaseTextSuelo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClaseTextSueloDTO> getDataClaseTextSuelo() throws Exception {
		try {
			List<ClaseTextSuelo> claseTextSuelo = claseTextSueloDAO.findAll();

			List<ClaseTextSueloDTO> claseTextSueloDTO = new ArrayList<ClaseTextSueloDTO>();

			for (ClaseTextSuelo claseTextSueloTmp : claseTextSuelo) {
				ClaseTextSueloDTO claseTextSueloDTO2 = new ClaseTextSueloDTO();

				claseTextSueloDTO2.setClaseTextSueloId(claseTextSueloTmp.getClaseTextSueloId());
				claseTextSueloDTO2
						.setCodigo((claseTextSueloTmp.getCodigo() != null) ? claseTextSueloTmp.getCodigo() : null);
				claseTextSueloDTO2.setCompania(
						(claseTextSueloTmp.getCompania() != null) ? claseTextSueloTmp.getCompania() : null);
				claseTextSueloDTO2
						.setEstado((claseTextSueloTmp.getEstado() != null) ? claseTextSueloTmp.getEstado() : null);
				claseTextSueloDTO2.setFechaCreacion(claseTextSueloTmp.getFechaCreacion());
				claseTextSueloDTO2.setFechaModificacion(claseTextSueloTmp.getFechaModificacion());
				claseTextSueloDTO2.setInfoAdicional(
						(claseTextSueloTmp.getInfoAdicional() != null) ? claseTextSueloTmp.getInfoAdicional() : null);
				claseTextSueloDTO2.setInfoAdicional2(
						(claseTextSueloTmp.getInfoAdicional2() != null) ? claseTextSueloTmp.getInfoAdicional2() : null);
				claseTextSueloDTO2
						.setNombre((claseTextSueloTmp.getNombre() != null) ? claseTextSueloTmp.getNombre() : null);
				claseTextSueloDTO.add(claseTextSueloDTO2);
			}

			return claseTextSueloDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ClaseTextSuelo getClaseTextSuelo(Long claseTextSueloId) throws Exception {
		log.debug("getting ClaseTextSuelo instance");

		ClaseTextSuelo entity = null;

		try {
			entity = claseTextSueloDAO.findById(claseTextSueloId);
		} catch (Exception e) {
			log.error("get ClaseTextSuelo failed", e);
			throw new ZMessManager().new FindingException("ClaseTextSuelo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClaseTextSuelo> findPageClaseTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ClaseTextSuelo> entity = null;

		try {
			entity = claseTextSueloDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ClaseTextSuelo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberClaseTextSuelo() throws Exception {
		Long entity = null;

		try {
			entity = claseTextSueloDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ClaseTextSuelo Count");
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
	public List<ClaseTextSuelo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ClaseTextSuelo> list = new ArrayList<ClaseTextSuelo>();
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
			list = claseTextSueloDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
