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

import co.com.arcosoft.dataaccess.dao.IAlmacenDAO;
import co.com.arcosoft.dataaccess.dao.IDatAplicProductoDAO;
import co.com.arcosoft.dataaccess.dao.IDatHerramientaDAO;
import co.com.arcosoft.dataaccess.dao.IDatRgtroInventDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.dataaccess.dao.IProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.DatRgtroInvent;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.dto.AlmacenDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AlmacenLogic")
public class AlmacenLogic implements IAlmacenLogic {
	private static final Logger log = LoggerFactory.getLogger(AlmacenLogic.class);

	/**
	 * DAO injected by Spring that manages Almacen entities
	 *
	 */
	@Autowired
	private IAlmacenDAO almacenDAO;

	/**
	 * DAO injected by Spring that manages DatAplicProducto entities
	 *
	 */
	@Autowired
	private IDatAplicProductoDAO datAplicProductoDAO;

	/**
	 * DAO injected by Spring that manages DatHerramienta entities
	 *
	 */
	@Autowired
	private IDatHerramientaDAO datHerramientaDAO;

	/**
	 * DAO injected by Spring that manages DatRgtroInvent entities
	 *
	 */
	@Autowired
	private IDatRgtroInventDAO datRgtroInventDAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	/**
	 * DAO injected by Spring that manages PrecioPromProd entities
	 *
	 */
	@Autowired
	private IPrecioPromProdDAO precioPromProdDAO;

	/**
	 * DAO injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	private IProductoDAO productoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Almacen> getAlmacen() throws Exception {
		log.debug("finding all Almacen instances");

		List<Almacen> list = new ArrayList<Almacen>();

		try {
			list = almacenDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Almacen failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Almacen");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAlmacen(Almacen entity) throws Exception {
		log.debug("saving Almacen instance");

		try {

			if ((entity.getCapacidadToneladas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidadToneladas(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidadToneladas");
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

			/*
			 * if (entity.getAlmacenId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("almacenId"); }
			 * 
			 * if ((entity.getAlmacenId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAlmacenId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "almacenId"); }
			 * 
			 * if (getAlmacen(entity.getAlmacenId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			almacenDAO.save(entity);

			log.debug("save Almacen successful");
		} catch (Exception e) {
			log.error("save Almacen failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAlmacen(Almacen entity) throws Exception {
		log.debug("deleting Almacen instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Almacen");
		}

		if (entity.getAlmacenId() == null) {
			throw new ZMessManager().new EmptyFieldException("almacenId");
		}

		List<DatAplicProducto> datAplicProductos = null;
		List<DatHerramienta> datHerramientas = null;
		List<DatRgtroInvent> datRgtroInvents = null;
		List<Nivel4> nivel4s = null;
		List<PrecioPromProd> precioPromProds = null;
		List<Producto> productos = null;

		try {
			datAplicProductos = datAplicProductoDAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(datAplicProductos) == true) {
				throw new ZMessManager().new DeletingException("datAplicProductos");
			}

			datHerramientas = datHerramientaDAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(datHerramientas) == true) {
				throw new ZMessManager().new DeletingException("datHerramientas");
			}

			datRgtroInvents = datRgtroInventDAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(datRgtroInvents) == true) {
				throw new ZMessManager().new DeletingException("datRgtroInvents");
			}

			nivel4s = nivel4DAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			precioPromProds = precioPromProdDAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(precioPromProds) == true) {
				throw new ZMessManager().new DeletingException("precioPromProds");
			}

			productos = productoDAO.findByProperty("almacen.almacenId", entity.getAlmacenId());

			if (Utilities.validationsList(productos) == true) {
				throw new ZMessManager().new DeletingException("productos");
			}

			almacenDAO.delete(entity);

			log.debug("delete Almacen successful");
		} catch (Exception e) {
			log.error("delete Almacen failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAlmacen(Almacen entity) throws Exception {
		log.debug("updating Almacen instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Almacen");
			}

			if (entity.getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException("almacenId");
			}

			if ((entity.getAlmacenId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlmacenId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("almacenId");
			}

			if ((entity.getCapacidadToneladas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidadToneladas(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidadToneladas");
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

			almacenDAO.update(entity);

			log.debug("update Almacen successful");
		} catch (Exception e) {
			log.error("update Almacen failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlmacenDTO> getDataAlmacen(Long companiaUserId) throws Exception {
		try {
			// List<Almacen> almacen = almacenDAO.findAll();

			String whereCondition = "compania" + "=" + companiaUserId;

			List<Almacen> almacen = almacenDAO.findByCriteria(whereCondition);

			List<AlmacenDTO> almacenDTO = new ArrayList<AlmacenDTO>();

			for (Almacen almacenTmp : almacen) {
				AlmacenDTO almacenDTO2 = new AlmacenDTO();

				almacenDTO2.setAlmacenId(almacenTmp.getAlmacenId());
				almacenDTO2.setCapacidadToneladas(
						(almacenTmp.getCapacidadToneladas() != null) ? almacenTmp.getCapacidadToneladas() : null);
				almacenDTO2.setCodigo((almacenTmp.getCodigo() != null) ? almacenTmp.getCodigo() : null);
				almacenDTO2.setCompania((almacenTmp.getCompania() != null) ? almacenTmp.getCompania() : null);
				almacenDTO2.setEstado((almacenTmp.getEstado() != null) ? almacenTmp.getEstado() : null);
				almacenDTO2.setFechaCreacion(almacenTmp.getFechaCreacion());
				almacenDTO2.setFechaModificacion(almacenTmp.getFechaModificacion());
				almacenDTO2.setInfoAdicional(
						(almacenTmp.getInfoAdicional() != null) ? almacenTmp.getInfoAdicional() : null);
				almacenDTO2.setInfoAdicional2(
						(almacenTmp.getInfoAdicional2() != null) ? almacenTmp.getInfoAdicional2() : null);
				almacenDTO2.setNombre((almacenTmp.getNombre() != null) ? almacenTmp.getNombre() : null);
				almacenDTO.add(almacenDTO2);
			}

			return almacenDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Almacen getAlmacen(Long almacenId) throws Exception {
		log.debug("getting Almacen instance");

		Almacen entity = null;

		try {
			entity = almacenDAO.findById(almacenId);
		} catch (Exception e) {
			log.error("get Almacen failed", e);
			throw new ZMessManager().new FindingException("Almacen");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Almacen> findPageAlmacen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Almacen> entity = null;

		try {
			entity = almacenDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Almacen Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAlmacen() throws Exception {
		Long entity = null;

		try {
			entity = almacenDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Almacen Count");
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
	public List<Almacen> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Almacen> list = new ArrayList<Almacen>();
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
			list = almacenDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
