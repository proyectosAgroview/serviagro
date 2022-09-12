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

import co.com.arcosoft.dataaccess.dao.IDatRgtroInventDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatRgtroInvent;
import co.com.arcosoft.modelo.dto.DatRgtroInventDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatRgtroInventLogic")
public class DatRgtroInventLogic implements IDatRgtroInventLogic {
	private static final Logger log = LoggerFactory.getLogger(DatRgtroInventLogic.class);

	/**
	 * DAO injected by Spring that manages DatRgtroInvent entities
	 *
	 */
	@Autowired
	private IDatRgtroInventDAO datRgtroInventDAO;

	/**
	 * Logic injected by Spring that manages Almacen entities
	 *
	 */
	@Autowired
	IAlmacenLogic logicAlmacen1;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto2;

	@Override
	@Transactional(readOnly = true)
	public List<DatRgtroInvent> getDatRgtroInvent() throws Exception {
		log.debug("finding all DatRgtroInvent instances");

		List<DatRgtroInvent> list = new ArrayList<DatRgtroInvent>();

		try {
			list = datRgtroInventDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatRgtroInvent failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatRgtroInvent");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatRgtroInvent(DatRgtroInvent entity) throws Exception {
		log.debug("saving DatRgtroInvent instance");

		try {
			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if ((entity.getCantidadDisponible() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadDisponible(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadDisponible");
			}

			if ((entity.getCantidadReservada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadReservada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadReservada");
			}

			if ((entity.getCantidadTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadTotal");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatRgtroInventId() == null) {
				throw new ZMessManager().new EmptyFieldException("datRgtroInventId");
			}

			if ((entity.getDatRgtroInventId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatRgtroInventId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datRgtroInventId");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
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

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException("almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlmacen().getAlmacenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("almacenId_Almacen");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			if (getDatRgtroInvent(entity.getDatRgtroInventId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datRgtroInventDAO.save(entity);

			log.debug("save DatRgtroInvent successful");
		} catch (Exception e) {
			log.error("save DatRgtroInvent failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatRgtroInvent(DatRgtroInvent entity) throws Exception {
		log.debug("deleting DatRgtroInvent instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatRgtroInvent");
		}

		if (entity.getDatRgtroInventId() == null) {
			throw new ZMessManager().new EmptyFieldException("datRgtroInventId");
		}

		try {
			datRgtroInventDAO.delete(entity);

			log.debug("delete DatRgtroInvent successful");
		} catch (Exception e) {
			log.error("delete DatRgtroInvent failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatRgtroInvent(DatRgtroInvent entity) throws Exception {
		log.debug("updating DatRgtroInvent instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatRgtroInvent");
			}

			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if ((entity.getCantidadDisponible() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadDisponible(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadDisponible");
			}

			if ((entity.getCantidadReservada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadReservada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadReservada");
			}

			if ((entity.getCantidadTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadTotal");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatRgtroInventId() == null) {
				throw new ZMessManager().new EmptyFieldException("datRgtroInventId");
			}

			if ((entity.getDatRgtroInventId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatRgtroInventId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datRgtroInventId");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
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

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException("almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlmacen().getAlmacenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("almacenId_Almacen");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			datRgtroInventDAO.update(entity);

			log.debug("update DatRgtroInvent successful");
		} catch (Exception e) {
			log.error("update DatRgtroInvent failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatRgtroInventDTO> getDataDatRgtroInvent() throws Exception {
		try {
			List<DatRgtroInvent> datRgtroInvent = datRgtroInventDAO.findAll();

			List<DatRgtroInventDTO> datRgtroInventDTO = new ArrayList<DatRgtroInventDTO>();

			for (DatRgtroInvent datRgtroInventTmp : datRgtroInvent) {
				DatRgtroInventDTO datRgtroInventDTO2 = new DatRgtroInventDTO();

				datRgtroInventDTO2.setDatRgtroInventId(datRgtroInventTmp.getDatRgtroInventId());
				datRgtroInventDTO2.setCantidadDisponible((datRgtroInventTmp.getCantidadDisponible() != null)
						? datRgtroInventTmp.getCantidadDisponible() : null);
				datRgtroInventDTO2.setCantidadReservada((datRgtroInventTmp.getCantidadReservada() != null)
						? datRgtroInventTmp.getCantidadReservada() : null);
				datRgtroInventDTO2.setCantidadTotal(
						(datRgtroInventTmp.getCantidadTotal() != null) ? datRgtroInventTmp.getCantidadTotal() : null);
				datRgtroInventDTO2.setCompania(
						(datRgtroInventTmp.getCompania() != null) ? datRgtroInventTmp.getCompania() : null);
				datRgtroInventDTO2.setConsecutivo(
						(datRgtroInventTmp.getConsecutivo() != null) ? datRgtroInventTmp.getConsecutivo() : null);
				datRgtroInventDTO2.setDocumetoErp(
						(datRgtroInventTmp.getDocumetoErp() != null) ? datRgtroInventTmp.getDocumetoErp() : null);
				datRgtroInventDTO2
						.setEstado((datRgtroInventTmp.getEstado() != null) ? datRgtroInventTmp.getEstado() : null);
				datRgtroInventDTO2.setFechaCreacion(datRgtroInventTmp.getFechaCreacion());
				datRgtroInventDTO2.setFechaModificacion(datRgtroInventTmp.getFechaModificacion());
				datRgtroInventDTO2.setFechaRegistro(datRgtroInventTmp.getFechaRegistro());
				datRgtroInventDTO2.setInfoAdicional(
						(datRgtroInventTmp.getInfoAdicional() != null) ? datRgtroInventTmp.getInfoAdicional() : null);
				datRgtroInventDTO2.setInfoAdicional2(
						(datRgtroInventTmp.getInfoAdicional2() != null) ? datRgtroInventTmp.getInfoAdicional2() : null);
				datRgtroInventDTO2.setObservacionAnularReg((datRgtroInventTmp.getObservacionAnularReg() != null)
						? datRgtroInventTmp.getObservacionAnularReg() : null);
				datRgtroInventDTO2.setUsuarioDigitacion((datRgtroInventTmp.getUsuarioDigitacion() != null)
						? datRgtroInventTmp.getUsuarioDigitacion() : null);

				if (datRgtroInventTmp.getAlmacen() != null) {
					datRgtroInventDTO2.setAlmacenId_Almacen(datRgtroInventTmp.getAlmacen().getAlmacenId());
				} else {
					datRgtroInventDTO2.setAlmacenId_Almacen(null);
				}

				if (datRgtroInventTmp.getProducto() != null) {
					datRgtroInventDTO2.setProductoId_Producto(datRgtroInventTmp.getProducto().getProductoId());
				} else {
					datRgtroInventDTO2.setProductoId_Producto(null);
				}

				datRgtroInventDTO.add(datRgtroInventDTO2);
			}

			return datRgtroInventDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatRgtroInvent getDatRgtroInvent(Long datRgtroInventId) throws Exception {
		log.debug("getting DatRgtroInvent instance");

		DatRgtroInvent entity = null;

		try {
			entity = datRgtroInventDAO.findById(datRgtroInventId);
		} catch (Exception e) {
			log.error("get DatRgtroInvent failed", e);
			throw new ZMessManager().new FindingException("DatRgtroInvent");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatRgtroInvent> findPageDatRgtroInvent(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatRgtroInvent> entity = null;

		try {
			entity = datRgtroInventDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatRgtroInvent Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatRgtroInvent() throws Exception {
		Long entity = null;

		try {
			entity = datRgtroInventDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatRgtroInvent Count");
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
	public List<DatRgtroInvent> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatRgtroInvent> list = new ArrayList<DatRgtroInvent>();
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
			list = datRgtroInventDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
