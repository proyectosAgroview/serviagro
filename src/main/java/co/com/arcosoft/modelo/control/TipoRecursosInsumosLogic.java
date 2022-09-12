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

import co.com.arcosoft.dataaccess.dao.ITipoRecursosInsumosDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.dto.TipoRecursosInsumosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoRecursosInsumosLogic")
public class TipoRecursosInsumosLogic implements ITipoRecursosInsumosLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoRecursosInsumosLogic.class);

	/**
	 * DAO injected by Spring that manages TipoRecursosInsumos entities
	 *
	 */
	@Autowired
	private ITipoRecursosInsumosDAO tipoRecursosInsumosDAO;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto1;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto2;

	/**
	 * Logic injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	ITipoRecursoLogic logicTipoRecurso3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosInsumos> getTipoRecursosInsumos() throws Exception {
		log.debug("finding all TipoRecursosInsumos instances");

		List<TipoRecursosInsumos> list = new ArrayList<TipoRecursosInsumos>();

		try {
			list = tipoRecursosInsumosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoRecursosInsumos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoRecursosInsumos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		log.debug("saving TipoRecursosInsumos instance");

		try {
			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if (getTipoRecursosInsumos(entity.getTipoRecursosInsumosId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tipoRecursosInsumosDAO.save(entity);

			log.debug("save TipoRecursosInsumos successful");
		} catch (Exception e) {
			log.error("save TipoRecursosInsumos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		log.debug("deleting TipoRecursosInsumos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoRecursosInsumos");
		}

		if (entity.getTipoRecursosInsumosId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoRecursosInsumosId");
		}

		try {
			tipoRecursosInsumosDAO.delete(entity);

			log.debug("delete TipoRecursosInsumos successful");
		} catch (Exception e) {
			log.error("delete TipoRecursosInsumos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		log.debug("updating TipoRecursosInsumos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoRecursosInsumos");
			}

			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			tipoRecursosInsumosDAO.update(entity);

			log.debug("update TipoRecursosInsumos successful");
		} catch (Exception e) {
			log.error("update TipoRecursosInsumos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumos() throws Exception {
		try {
			List<TipoRecursosInsumos> tipoRecursosInsumos = tipoRecursosInsumosDAO.findAll();

			List<TipoRecursosInsumosDTO> tipoRecursosInsumosDTO = new ArrayList<TipoRecursosInsumosDTO>();

			for (TipoRecursosInsumos tipoRecursosInsumosTmp : tipoRecursosInsumos) {
				TipoRecursosInsumosDTO tipoRecursosInsumosDTO2 = new TipoRecursosInsumosDTO();

				tipoRecursosInsumosDTO2.setTipoRecursosInsumosId(tipoRecursosInsumosTmp.getTipoRecursosInsumosId());
				tipoRecursosInsumosDTO2.setFechaCreacion(tipoRecursosInsumosTmp.getFechaCreacion());
				tipoRecursosInsumosDTO2.setFechaFinal(tipoRecursosInsumosTmp.getFechaFinal());
				tipoRecursosInsumosDTO2.setFechaInicial(tipoRecursosInsumosTmp.getFechaInicial());
				tipoRecursosInsumosDTO2.setFechaModificacion(tipoRecursosInsumosTmp.getFechaModificacion());
				tipoRecursosInsumosDTO2.setValor(
						(tipoRecursosInsumosTmp.getValor() != null) ? tipoRecursosInsumosTmp.getValor() : null);
				tipoRecursosInsumosDTO2.setElemCostoId_ElementoCosto((tipoRecursosInsumosTmp.getElementoCosto() != null)
						? tipoRecursosInsumosTmp.getElementoCosto() : null);

				if (tipoRecursosInsumosTmp.getProducto() != null) {
					tipoRecursosInsumosDTO2.setProductoId_Producto(tipoRecursosInsumosTmp.getProducto());
				} else {
					tipoRecursosInsumosDTO2.setProductoId_Producto(null);
				}

				tipoRecursosInsumosDTO2
						.setTpRecursoId_TipoRecurso((tipoRecursosInsumosTmp.getTipoRecurso().getTpRecursoId() != null)
								? tipoRecursosInsumosTmp.getTipoRecurso().getTpRecursoId() : null);
				tipoRecursosInsumosDTO2.setUdadMedId_UdadMed(
						(tipoRecursosInsumosTmp.getUdadMed() != null) ? tipoRecursosInsumosTmp.getUdadMed() : null);

				if (tipoRecursosInsumosTmp.getUdadMed() != null) {
					tipoRecursosInsumosDTO2.setNombreUm(tipoRecursosInsumosTmp.getUdadMed().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreUm(null);
				}

				if (tipoRecursosInsumosTmp.getProducto() != null) {
					tipoRecursosInsumosDTO2.setNombreProducto(tipoRecursosInsumosTmp.getProducto().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreProducto(null);
				}

				if (tipoRecursosInsumosTmp.getElementoCosto() != null) {
					tipoRecursosInsumosDTO2.setNombreElemCosto(tipoRecursosInsumosTmp.getElementoCosto().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreElemCosto(null);
				}

				tipoRecursosInsumosDTO.add(tipoRecursosInsumosDTO2);
			}

			return tipoRecursosInsumosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoRecursosInsumos getTipoRecursosInsumos(Long tipoRecursosInsumosId) throws Exception {
		log.debug("getting TipoRecursosInsumos instance");

		TipoRecursosInsumos entity = null;

		try {
			entity = tipoRecursosInsumosDAO.findById(tipoRecursosInsumosId);
		} catch (Exception e) {
			log.error("get TipoRecursosInsumos failed", e);
			throw new ZMessManager().new FindingException("TipoRecursosInsumos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosInsumos> findPageTipoRecursosInsumos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TipoRecursosInsumos> entity = null;

		try {
			entity = tipoRecursosInsumosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecursosInsumos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoRecursosInsumos() throws Exception {
		Long entity = null;

		try {
			entity = tipoRecursosInsumosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecursosInsumos Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<TipoRecursosInsumos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoRecursosInsumos> list = new ArrayList<TipoRecursosInsumos>();
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
			list = tipoRecursosInsumosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumosByInsumos(Long tipoRecursosInsumosId)
			throws Exception {
		try {

			List<TipoRecursosInsumos> tipoRecursosInsumos = tipoRecursosInsumosDAO
					.findByCriteria("tipoRecurso.tpRecursoId= " + tipoRecursosInsumosId);

			List<TipoRecursosInsumosDTO> tipoRecursosInsumosDTO = new ArrayList<TipoRecursosInsumosDTO>();

			for (TipoRecursosInsumos tipoRecursosInsumosTmp : tipoRecursosInsumos) {
				TipoRecursosInsumosDTO tipoRecursosInsumosDTO2 = new TipoRecursosInsumosDTO();

				tipoRecursosInsumosDTO2.setTipoRecursosInsumosId(tipoRecursosInsumosTmp.getTipoRecursosInsumosId());
				tipoRecursosInsumosDTO2.setFechaCreacion(tipoRecursosInsumosTmp.getFechaCreacion());
				tipoRecursosInsumosDTO2.setFechaFinal(tipoRecursosInsumosTmp.getFechaFinal());
				tipoRecursosInsumosDTO2.setFechaInicial(tipoRecursosInsumosTmp.getFechaInicial());
				tipoRecursosInsumosDTO2.setFechaModificacion(tipoRecursosInsumosTmp.getFechaModificacion());
				tipoRecursosInsumosDTO2.setValor(
						(tipoRecursosInsumosTmp.getValor() != null) ? tipoRecursosInsumosTmp.getValor() : null);
				tipoRecursosInsumosDTO2.setElemCostoId_ElementoCosto((tipoRecursosInsumosTmp.getElementoCosto() != null)
						? tipoRecursosInsumosTmp.getElementoCosto() : null);

				if (tipoRecursosInsumosTmp.getProducto() != null) {
					tipoRecursosInsumosDTO2.setProductoId_Producto(tipoRecursosInsumosTmp.getProducto());
				} else {
					tipoRecursosInsumosDTO2.setProductoId_Producto(null);
				}

				tipoRecursosInsumosDTO2
						.setTpRecursoId_TipoRecurso((tipoRecursosInsumosTmp.getTipoRecurso().getTpRecursoId() != null)
								? tipoRecursosInsumosTmp.getTipoRecurso().getTpRecursoId() : null);
				tipoRecursosInsumosDTO2.setUdadMedId_UdadMed(
						(tipoRecursosInsumosTmp.getUdadMed() != null) ? tipoRecursosInsumosTmp.getUdadMed() : null);

				if (tipoRecursosInsumosTmp.getUdadMed() != null) {
					tipoRecursosInsumosDTO2.setNombreUm(tipoRecursosInsumosTmp.getUdadMed().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreUm(null);
				}

				if (tipoRecursosInsumosTmp.getProducto() != null) {
					tipoRecursosInsumosDTO2.setNombreProducto(tipoRecursosInsumosTmp.getProducto().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreProducto(null);
				}

				if (tipoRecursosInsumosTmp.getElementoCosto() != null) {
					tipoRecursosInsumosDTO2.setNombreElemCosto(tipoRecursosInsumosTmp.getElementoCosto().getNombre());
				} else {
					tipoRecursosInsumosDTO2.setNombreElemCosto(null);
				}

				tipoRecursosInsumosDTO.add(tipoRecursosInsumosDTO2);
			}

			return tipoRecursosInsumosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
