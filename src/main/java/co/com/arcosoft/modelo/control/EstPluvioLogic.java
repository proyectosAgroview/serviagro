package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatPluvioDAO;
import co.com.arcosoft.dataaccess.dao.IEstPluvioDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPluvio;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.EstPluvioDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EstPluvioLogic")
public class EstPluvioLogic implements IEstPluvioLogic {
	private static final Logger log = LoggerFactory.getLogger(EstPluvioLogic.class);

	/**
	 * DAO injected by Spring that manages EstPluvio entities
	 *
	 */
	@Autowired
	private IEstPluvioDAO estPluvioDAO;

	/**
	 * DAO injected by Spring that manages DatPluvio entities
	 *
	 */
	@Autowired
	private IDatPluvioDAO datPluvioDAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	@Override
	@Transactional(readOnly = true)
	public List<EstPluvio> getEstPluvio() throws Exception {
		log.debug("finding all EstPluvio instances");

		List<EstPluvio> list = new ArrayList<EstPluvio>();

		try {
			list = estPluvioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all EstPluvio failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "EstPluvio");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEstPluvio(EstPluvio entity) throws Exception {
		log.debug("saving EstPluvio instance");

		try {
			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getEstPluvioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("estPluvioId"); }
			 * 
			 * if ((entity.getEstPluvioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstPluvioId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "estPluvioId"); }
			 */

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (getEstPluvio(entity.getEstPluvioId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			estPluvioDAO.save(entity);

			log.debug("save EstPluvio successful");
		} catch (Exception e) {
			log.error("save EstPluvio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEstPluvio(EstPluvio entity) throws Exception {
		log.debug("deleting EstPluvio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("EstPluvio");
		}

		if (entity.getEstPluvioId() == null) {
			throw new ZMessManager().new EmptyFieldException("estPluvioId");
		}

		List<DatPluvio> datPluvios = null;
		List<Nivel4> nivel4s = null;

		try {
			datPluvios = datPluvioDAO.findByProperty("estPluvio.estPluvioId", entity.getEstPluvioId());

			if (Utilities.validationsList(datPluvios) == true) {
				throw new ZMessManager().new DeletingException("datPluvios");
			}

			nivel4s = nivel4DAO.findByProperty("estPluvio.estPluvioId", entity.getEstPluvioId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			estPluvioDAO.delete(entity);

			log.debug("delete EstPluvio successful");
		} catch (Exception e) {
			log.error("delete EstPluvio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEstPluvio(EstPluvio entity) throws Exception {
		log.debug("updating EstPluvio instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("EstPluvio");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getEstPluvioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("estPluvioId"); }
			 * 
			 * if ((entity.getEstPluvioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstPluvioId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "estPluvioId"); }
			 */

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			estPluvioDAO.update(entity);

			log.debug("update EstPluvio successful");
		} catch (Exception e) {
			log.error("update EstPluvio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstPluvioDTO> getDataEstPluvio() throws Exception {
		try {
			List<EstPluvio> estPluvio = estPluvioDAO.findAll();

			List<EstPluvioDTO> estPluvioDTO = new ArrayList<EstPluvioDTO>();

			for (EstPluvio estPluvioTmp : estPluvio) {
				EstPluvioDTO estPluvioDTO2 = new EstPluvioDTO();

				estPluvioDTO2.setEstPluvioId(estPluvioTmp.getEstPluvioId());
				estPluvioDTO2.setCodigo((estPluvioTmp.getCodigo() != null) ? estPluvioTmp.getCodigo() : null);
				estPluvioDTO2.setCompania((estPluvioTmp.getCompania() != null) ? estPluvioTmp.getCompania() : null);
				estPluvioDTO2.setEstado((estPluvioTmp.getEstado() != null) ? estPluvioTmp.getEstado() : null);
				estPluvioDTO2.setFechaCreacion(estPluvioTmp.getFechaCreacion());
				estPluvioDTO2.setFechaModificacion(estPluvioTmp.getFechaModificacion());
				estPluvioDTO2.setNombre((estPluvioTmp.getNombre() != null) ? estPluvioTmp.getNombre() : null);
				estPluvioDTO.add(estPluvioDTO2);
			}

			return estPluvioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public EstPluvio getEstPluvio(Long estPluvioId) throws Exception {
		log.debug("getting EstPluvio instance");

		EstPluvio entity = null;

		try {
			entity = estPluvioDAO.findById(estPluvioId);
		} catch (Exception e) {
			log.error("get EstPluvio failed", e);
			throw new ZMessManager().new FindingException("EstPluvio");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstPluvio> findPageEstPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<EstPluvio> entity = null;

		try {
			entity = estPluvioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EstPluvio Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEstPluvio() throws Exception {
		Long entity = null;

		try {
			entity = estPluvioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EstPluvio Count");
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
	public List<EstPluvio> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<EstPluvio> list = new ArrayList<EstPluvio>();
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
			list = estPluvioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstPluvioDTO> findByCriteriaPageEstPluvio(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {

		try {
			List<EstPluvio> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = estPluvioDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<EstPluvioDTO> estPluvioDTO = new ArrayList<EstPluvioDTO>();
			for (EstPluvio estPluvioTmp : entity) {
				EstPluvioDTO estPluvioDTO2 = new EstPluvioDTO();

				estPluvioDTO2.setEstPluvioId(estPluvioTmp.getEstPluvioId());
				estPluvioDTO2.setCodigo((estPluvioTmp.getCodigo() != null) ? estPluvioTmp.getCodigo() : null);
				estPluvioDTO2.setCompania((estPluvioTmp.getCompania() != null) ? estPluvioTmp.getCompania() : null);
				estPluvioDTO2.setEstado((estPluvioTmp.getEstado() != null) ? estPluvioTmp.getEstado() : null);
				estPluvioDTO2.setFechaCreacion(estPluvioTmp.getFechaCreacion());
				estPluvioDTO2.setFechaModificacion(estPluvioTmp.getFechaModificacion());
				estPluvioDTO2.setNombre((estPluvioTmp.getNombre() != null) ? estPluvioTmp.getNombre() : null);
				estPluvioDTO2.setLatitud((estPluvioTmp.getLatitud() != null) ? estPluvioTmp.getLatitud() : null);
				estPluvioDTO2.setLongitud((estPluvioTmp.getLongitud() != null) ? estPluvioTmp.getLongitud() : null);
				estPluvioDTO2.setPrecision((estPluvioTmp.getPrecision() != null) ? estPluvioTmp.getPrecision() : null);
				
				estPluvioDTO.add(estPluvioDTO2);
			}

			return estPluvioDTO;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEstPluvio(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = estPluvioDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EstPluvio Count");
		} finally {
		}
		return entity;
	}

}
