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

import co.com.arcosoft.dataaccess.dao.IIngrActivProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.IngrActivProd;
import co.com.arcosoft.modelo.IngrActivProdId;
import co.com.arcosoft.modelo.dto.IngrActivProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("IngrActivProdLogic")
public class IngrActivProdLogic implements IIngrActivProdLogic {
	private static final Logger log = LoggerFactory.getLogger(IngrActivProdLogic.class);

	/**
	 * DAO injected by Spring that manages IngrActivProd entities
	 *
	 */
	@Autowired
	private IIngrActivProdDAO ingrActivProdDAO;

	/**
	 * Logic injected by Spring that manages IngredienteActivo entities
	 *
	 */
	@Autowired
	IIngredienteActivoLogic logicIngredienteActivo1;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto2;

	@Override
	@Transactional(readOnly = true)
	public List<IngrActivProd> getIngrActivProd() throws Exception {
		log.debug("finding all IngrActivProd instances");

		List<IngrActivProd> list = new ArrayList<IngrActivProd>();

		try {
			list = ingrActivProdDAO.findAll();
		} catch (Exception e) {
			log.error("finding all IngrActivProd failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "IngrActivProd");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveIngrActivProd(IngrActivProd entity) throws Exception {
		log.debug("saving IngrActivProd instance");

		try {
			if (entity.getIngredienteActivo() == null) {
				throw new ZMessManager().new ForeignException("ingredienteActivo");
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

			if (entity.getId().getIngredienteActId() == null) {
				throw new ZMessManager().new EmptyFieldException("ingredienteActId");
			}

			if ((entity.getId().getIngredienteActId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getIngredienteActId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ingredienteActId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getPtjeContribuccion() == null) {
				throw new ZMessManager().new EmptyFieldException("ptjeContribuccion");
			}

			if ((entity.getId().getPtjeContribuccion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getPtjeContribuccion(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("ptjeContribuccion");
			}

			if (entity.getIngredienteActivo().getIngredienteActId() == null) {
				throw new ZMessManager().new EmptyFieldException("ingredienteActId_IngredienteActivo");
			}

			if ((entity.getIngredienteActivo().getIngredienteActId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getIngredienteActivo().getIngredienteActId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ingredienteActId_IngredienteActivo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			if (getIngrActivProd(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			ingrActivProdDAO.save(entity);

			log.debug("save IngrActivProd successful");
		} catch (Exception e) {
			log.error("save IngrActivProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteIngrActivProd(IngrActivProd entity) throws Exception {
		log.debug("deleting IngrActivProd instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("IngrActivProd");
		}

		if (entity.getId().getProductoId() == null) {
			throw new ZMessManager().new EmptyFieldException("productoId");
		}

		if (entity.getId().getIngredienteActId() == null) {
			throw new ZMessManager().new EmptyFieldException("ingredienteActId");
		}

		if (entity.getId().getCompania() == null) {
			throw new ZMessManager().new EmptyFieldException("compania");
		}

		if (entity.getId().getPtjeContribuccion() == null) {
			throw new ZMessManager().new EmptyFieldException("ptjeContribuccion");
		}

		try {
			ingrActivProdDAO.delete(entity);

			log.debug("delete IngrActivProd successful");
		} catch (Exception e) {
			log.error("delete IngrActivProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateIngrActivProd(IngrActivProd entity) throws Exception {
		log.debug("updating IngrActivProd instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("IngrActivProd");
			}

			if (entity.getIngredienteActivo() == null) {
				throw new ZMessManager().new ForeignException("ingredienteActivo");
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

			if (entity.getId().getIngredienteActId() == null) {
				throw new ZMessManager().new EmptyFieldException("ingredienteActId");
			}

			if ((entity.getId().getIngredienteActId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getIngredienteActId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ingredienteActId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getPtjeContribuccion() == null) {
				throw new ZMessManager().new EmptyFieldException("ptjeContribuccion");
			}

			if ((entity.getId().getPtjeContribuccion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getPtjeContribuccion(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("ptjeContribuccion");
			}

			if (entity.getIngredienteActivo().getIngredienteActId() == null) {
				throw new ZMessManager().new EmptyFieldException("ingredienteActId_IngredienteActivo");
			}

			if ((entity.getIngredienteActivo().getIngredienteActId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getIngredienteActivo().getIngredienteActId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ingredienteActId_IngredienteActivo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			ingrActivProdDAO.update(entity);

			log.debug("update IngrActivProd successful");
		} catch (Exception e) {
			log.error("update IngrActivProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<IngrActivProdDTO> getDataIngrActivProd() throws Exception {
		try {
			List<IngrActivProd> ingrActivProd = ingrActivProdDAO.findAll();

			List<IngrActivProdDTO> ingrActivProdDTO = new ArrayList<IngrActivProdDTO>();

			for (IngrActivProd ingrActivProdTmp : ingrActivProd) {
				IngrActivProdDTO ingrActivProdDTO2 = new IngrActivProdDTO();

				ingrActivProdDTO2.setProductoId(ingrActivProdTmp.getId().getProductoId());
				ingrActivProdDTO2.setIngredienteActId(ingrActivProdTmp.getId().getIngredienteActId());
				ingrActivProdDTO2.setCompania(ingrActivProdTmp.getId().getCompania());
				ingrActivProdDTO2.setPtjeContribuccion(ingrActivProdTmp.getId().getPtjeContribuccion());
				ingrActivProdDTO2.setIngredienteActId_IngredienteActivo(
						(ingrActivProdTmp.getIngredienteActivo().getIngredienteActId() != null)
								? ingrActivProdTmp.getIngredienteActivo().getIngredienteActId() : null);
				ingrActivProdDTO2.setProductoId_Producto((ingrActivProdTmp.getProducto().getProductoId() != null)
						? ingrActivProdTmp.getProducto().getProductoId() : null);
				ingrActivProdDTO.add(ingrActivProdDTO2);
			}

			return ingrActivProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public IngrActivProd getIngrActivProd(IngrActivProdId id) throws Exception {
		log.debug("getting IngrActivProd instance");

		IngrActivProd entity = null;

		try {
			entity = ingrActivProdDAO.findById(id);
		} catch (Exception e) {
			log.error("get IngrActivProd failed", e);
			throw new ZMessManager().new FindingException("IngrActivProd");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<IngrActivProd> findPageIngrActivProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<IngrActivProd> entity = null;

		try {
			entity = ingrActivProdDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("IngrActivProd Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberIngrActivProd() throws Exception {
		Long entity = null;

		try {
			entity = ingrActivProdDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("IngrActivProd Count");
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
	public List<IngrActivProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<IngrActivProd> list = new ArrayList<IngrActivProd>();
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
			list = ingrActivProdDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
