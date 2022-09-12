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

import co.com.arcosoft.dataaccess.dao.IEmpaqueProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.EmpaqueProducto;
import co.com.arcosoft.modelo.EmpaqueProductoId;
import co.com.arcosoft.modelo.dto.EmpaqueProductoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EmpaqueProductoLogic")
public class EmpaqueProductoLogic implements IEmpaqueProductoLogic {
	private static final Logger log = LoggerFactory.getLogger(EmpaqueProductoLogic.class);

	/**
	 * DAO injected by Spring that manages EmpaqueProducto entities
	 *
	 */
	@Autowired
	private IEmpaqueProductoDAO empaqueProductoDAO;

	/**
	 * Logic injected by Spring that manages Empaque entities
	 *
	 */
	@Autowired
	IEmpaqueLogic logicEmpaque1;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto2;

	@Override
	@Transactional(readOnly = true)
	public List<EmpaqueProducto> getEmpaqueProducto() throws Exception {
		log.debug("finding all EmpaqueProducto instances");

		List<EmpaqueProducto> list = new ArrayList<EmpaqueProducto>();

		try {
			list = empaqueProductoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all EmpaqueProducto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "EmpaqueProducto");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		log.debug("saving EmpaqueProducto instance");

		try {
			if (entity.getEmpaque() == null) {
				throw new ZMessManager().new ForeignException("empaque");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getId().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId");
			}

			if ((entity.getId().getProductoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getProductoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId");
			}

			if (entity.getId().getEmpaqueId() == null) {
				throw new ZMessManager().new EmptyFieldException("empaqueId");
			}

			if ((entity.getId().getEmpaqueId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getEmpaqueId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId");
			}

			if (entity.getEmpaque().getEmpaqueId() == null) {
				throw new ZMessManager().new EmptyFieldException("empaqueId_Empaque");
			}

			if ((entity.getEmpaque().getEmpaqueId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpaque().getEmpaqueId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId_Empaque");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			if (getEmpaqueProducto(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			empaqueProductoDAO.save(entity);

			log.debug("save EmpaqueProducto successful");
		} catch (Exception e) {
			log.error("save EmpaqueProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		log.debug("deleting EmpaqueProducto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("EmpaqueProducto");
		}

		if (entity.getId().getProductoId() == null) {
			throw new ZMessManager().new EmptyFieldException("productoId");
		}

		if (entity.getId().getEmpaqueId() == null) {
			throw new ZMessManager().new EmptyFieldException("empaqueId");
		}

		try {
			empaqueProductoDAO.delete(entity);

			log.debug("delete EmpaqueProducto successful");
		} catch (Exception e) {
			log.error("delete EmpaqueProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		log.debug("updating EmpaqueProducto instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("EmpaqueProducto");
			}

			if (entity.getEmpaque() == null) {
				throw new ZMessManager().new ForeignException("empaque");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getId().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId");
			}

			if ((entity.getId().getProductoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getProductoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId");
			}

			if (entity.getId().getEmpaqueId() == null) {
				throw new ZMessManager().new EmptyFieldException("empaqueId");
			}

			if ((entity.getId().getEmpaqueId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getEmpaqueId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId");
			}

			if (entity.getEmpaque().getEmpaqueId() == null) {
				throw new ZMessManager().new EmptyFieldException("empaqueId_Empaque");
			}

			if ((entity.getEmpaque().getEmpaqueId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpaque().getEmpaqueId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId_Empaque");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			empaqueProductoDAO.update(entity);

			log.debug("update EmpaqueProducto successful");
		} catch (Exception e) {
			log.error("update EmpaqueProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmpaqueProductoDTO> getDataEmpaqueProducto() throws Exception {
		try {
			List<EmpaqueProducto> empaqueProducto = empaqueProductoDAO.findAll();

			List<EmpaqueProductoDTO> empaqueProductoDTO = new ArrayList<EmpaqueProductoDTO>();

			for (EmpaqueProducto empaqueProductoTmp : empaqueProducto) {
				EmpaqueProductoDTO empaqueProductoDTO2 = new EmpaqueProductoDTO();

				empaqueProductoDTO2.setProductoId(empaqueProductoTmp.getId().getProductoId());
				empaqueProductoDTO2.setEmpaqueId(empaqueProductoTmp.getId().getEmpaqueId());
				empaqueProductoDTO2.setEmpaqueId_Empaque((empaqueProductoTmp.getEmpaque().getEmpaqueId() != null)
						? empaqueProductoTmp.getEmpaque().getEmpaqueId() : null);
				empaqueProductoDTO2.setProductoId_Producto((empaqueProductoTmp.getProducto().getProductoId() != null)
						? empaqueProductoTmp.getProducto().getProductoId() : null);
				empaqueProductoDTO.add(empaqueProductoDTO2);
			}

			return empaqueProductoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public EmpaqueProducto getEmpaqueProducto(EmpaqueProductoId id) throws Exception {
		log.debug("getting EmpaqueProducto instance");

		EmpaqueProducto entity = null;

		try {
			entity = empaqueProductoDAO.findById(id);
		} catch (Exception e) {
			log.error("get EmpaqueProducto failed", e);
			throw new ZMessManager().new FindingException("EmpaqueProducto");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmpaqueProducto> findPageEmpaqueProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<EmpaqueProducto> entity = null;

		try {
			entity = empaqueProductoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EmpaqueProducto Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEmpaqueProducto() throws Exception {
		Long entity = null;

		try {
			entity = empaqueProductoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EmpaqueProducto Count");
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
	public List<EmpaqueProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<EmpaqueProducto> list = new ArrayList<EmpaqueProducto>();
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
			list = empaqueProductoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
