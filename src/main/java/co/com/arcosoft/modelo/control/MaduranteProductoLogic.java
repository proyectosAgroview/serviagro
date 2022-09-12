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

import co.com.arcosoft.dataaccess.dao.IMaduranteProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.MaduranteProducto;
import co.com.arcosoft.modelo.MaduranteProductoId;
import co.com.arcosoft.modelo.dto.MaduranteProductoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("MaduranteProductoLogic")
public class MaduranteProductoLogic implements IMaduranteProductoLogic {
	private static final Logger log = LoggerFactory.getLogger(MaduranteProductoLogic.class);

	/**
	 * DAO injected by Spring that manages MaduranteProducto entities
	 *
	 */
	@Autowired
	private IMaduranteProductoDAO maduranteProductoDAO;

	/**
	 * Logic injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	ICultivoLogic logicCultivo1;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto2;

	@Override
	@Transactional(readOnly = true)
	public List<MaduranteProducto> getMaduranteProducto() throws Exception {
		log.debug("finding all MaduranteProducto instances");

		List<MaduranteProducto> list = new ArrayList<MaduranteProducto>();

		try {
			list = maduranteProductoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all MaduranteProducto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "MaduranteProducto");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveMaduranteProducto(MaduranteProducto entity) throws Exception {
		log.debug("saving MaduranteProducto instance");

		try {
			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
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

			if (entity.getId().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId");
			}

			if ((entity.getId().getCultivoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCultivoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId");
			}

			if (entity.getId().getNdiasEfecto() == null) {
				throw new ZMessManager().new EmptyFieldException("ndiasEfecto");
			}

			if ((entity.getId().getNdiasEfecto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNdiasEfecto(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ndiasEfecto");
			}

			if (entity.getId().getNdiasReaplic() == null) {
				throw new ZMessManager().new EmptyFieldException("ndiasReaplic");
			}

			if ((entity.getId().getNdiasReaplic() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNdiasReaplic(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ndiasReaplic");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			if (getMaduranteProducto(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			maduranteProductoDAO.save(entity);

			log.debug("save MaduranteProducto successful");
		} catch (Exception e) {
			log.error("save MaduranteProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteMaduranteProducto(MaduranteProducto entity) throws Exception {
		log.debug("deleting MaduranteProducto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("MaduranteProducto");
		}

		if (entity.getId().getProductoId() == null) {
			throw new ZMessManager().new EmptyFieldException("productoId");
		}

		if (entity.getId().getCultivoId() == null) {
			throw new ZMessManager().new EmptyFieldException("cultivoId");
		}

		if (entity.getId().getNdiasEfecto() == null) {
			throw new ZMessManager().new EmptyFieldException("ndiasEfecto");
		}

		if (entity.getId().getNdiasReaplic() == null) {
			throw new ZMessManager().new EmptyFieldException("ndiasReaplic");
		}

		try {
			maduranteProductoDAO.delete(entity);

			log.debug("delete MaduranteProducto successful");
		} catch (Exception e) {
			log.error("delete MaduranteProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateMaduranteProducto(MaduranteProducto entity) throws Exception {
		log.debug("updating MaduranteProducto instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("MaduranteProducto");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
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

			if (entity.getId().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId");
			}

			if ((entity.getId().getCultivoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCultivoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId");
			}

			if (entity.getId().getNdiasEfecto() == null) {
				throw new ZMessManager().new EmptyFieldException("ndiasEfecto");
			}

			if ((entity.getId().getNdiasEfecto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNdiasEfecto(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ndiasEfecto");
			}

			if (entity.getId().getNdiasReaplic() == null) {
				throw new ZMessManager().new EmptyFieldException("ndiasReaplic");
			}

			if ((entity.getId().getNdiasReaplic() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getNdiasReaplic(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ndiasReaplic");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			maduranteProductoDAO.update(entity);

			log.debug("update MaduranteProducto successful");
		} catch (Exception e) {
			log.error("update MaduranteProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<MaduranteProductoDTO> getDataMaduranteProducto() throws Exception {
		try {
			List<MaduranteProducto> maduranteProducto = maduranteProductoDAO.findAll();

			List<MaduranteProductoDTO> maduranteProductoDTO = new ArrayList<MaduranteProductoDTO>();

			for (MaduranteProducto maduranteProductoTmp : maduranteProducto) {
				MaduranteProductoDTO maduranteProductoDTO2 = new MaduranteProductoDTO();

				maduranteProductoDTO2.setProductoId(maduranteProductoTmp.getId().getProductoId());
				maduranteProductoDTO2.setCultivoId(maduranteProductoTmp.getId().getCultivoId());
				maduranteProductoDTO2.setNdiasEfecto(maduranteProductoTmp.getId().getNdiasEfecto());
				maduranteProductoDTO2.setNdiasReaplic(maduranteProductoTmp.getId().getNdiasReaplic());
				maduranteProductoDTO2.setCultivoId_Cultivo((maduranteProductoTmp.getCultivo().getCultivoId() != null)
						? maduranteProductoTmp.getCultivo().getCultivoId() : null);
				maduranteProductoDTO2
						.setProductoId_Producto((maduranteProductoTmp.getProducto().getProductoId() != null)
								? maduranteProductoTmp.getProducto().getProductoId() : null);
				maduranteProductoDTO.add(maduranteProductoDTO2);
			}

			return maduranteProductoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public MaduranteProducto getMaduranteProducto(MaduranteProductoId id) throws Exception {
		log.debug("getting MaduranteProducto instance");

		MaduranteProducto entity = null;

		try {
			entity = maduranteProductoDAO.findById(id);
		} catch (Exception e) {
			log.error("get MaduranteProducto failed", e);
			throw new ZMessManager().new FindingException("MaduranteProducto");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MaduranteProducto> findPageMaduranteProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<MaduranteProducto> entity = null;

		try {
			entity = maduranteProductoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("MaduranteProducto Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberMaduranteProducto() throws Exception {
		Long entity = null;

		try {
			entity = maduranteProductoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("MaduranteProducto Count");
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
	public List<MaduranteProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<MaduranteProducto> list = new ArrayList<MaduranteProducto>();
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
			list = maduranteProductoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
