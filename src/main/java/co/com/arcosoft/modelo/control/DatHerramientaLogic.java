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

import co.com.arcosoft.dataaccess.dao.IDatHerramientaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.dto.DatHerramientaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatHerramientaLogic")
public class DatHerramientaLogic implements IDatHerramientaLogic {
	private static final Logger log = LoggerFactory
			.getLogger(DatHerramientaLogic.class);

	/**
	 * DAO injected by Spring that manages DatHerramienta entities
	 *
	 */
	@Autowired
	private IDatHerramientaDAO datHerramientaDAO;

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

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Transactional(readOnly = true)
	public List<DatHerramienta> getDatHerramienta() throws Exception {
		log.debug("finding all DatHerramienta instances");

		List<DatHerramienta> list = new ArrayList<DatHerramienta>();

		try {
			list = datHerramientaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatHerramienta failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "DatHerramienta");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatHerramienta(DatHerramienta entity) throws Exception {
		log.debug("saving DatHerramienta instance");

		try {
			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidadEntregada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadEntregada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadEntregada");
			}

			if ((entity.getCompania() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"consecutivo");
			}

			if (entity.getDatHerramientaId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"datHerramientaId");
			}

			if ((entity.getDatHerramientaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDatHerramientaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"datHerramientaId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacionAnularReg");
			}

			if ((entity.getTipoRegistro() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoRegistro(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoRegistro");
			}

			if ((entity.getUsuarioDigitacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuarioDigitacion");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAlmacen().getAlmacenId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"almacenId_Almacen");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProducto().getProductoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoId_Producto");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"trabId_Trabajador");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTrabajador().getTrabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"trabId_Trabajador");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUdadMed().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"udadMedId_UdadMed");
			}

			

			datHerramientaDAO.save(entity);

			log.debug("save DatHerramienta successful");
		} catch (Exception e) {
			log.error("save DatHerramienta failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatHerramienta(DatHerramienta entity) throws Exception {
		log.debug("deleting DatHerramienta instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatHerramienta");
		}

		if (entity.getDatHerramientaId() == null) {
			throw new ZMessManager().new EmptyFieldException("datHerramientaId");
		}

		try {
			datHerramientaDAO.delete(entity);

			log.debug("delete DatHerramienta successful");
		} catch (Exception e) {
			log.error("delete DatHerramienta failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatHerramienta(DatHerramienta entity) throws Exception {
		log.debug("updating DatHerramienta instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"DatHerramienta");
			}

			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidadEntregada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadEntregada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadEntregada");
			}

			if ((entity.getCompania() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"consecutivo");
			}

			if (entity.getDatHerramientaId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"datHerramientaId");
			}

			if ((entity.getDatHerramientaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDatHerramientaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"datHerramientaId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacionAnularReg");
			}

			if ((entity.getTipoRegistro() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoRegistro(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoRegistro");
			}

			if ((entity.getUsuarioDigitacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuarioDigitacion");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAlmacen().getAlmacenId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"almacenId_Almacen");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProducto().getProductoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoId_Producto");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"trabId_Trabajador");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTrabajador().getTrabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"trabId_Trabajador");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUdadMed().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"udadMedId_UdadMed");
			}

			datHerramientaDAO.update(entity);

			log.debug("update DatHerramienta successful");
		} catch (Exception e) {
			log.error("update DatHerramienta failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatHerramientaDTO> getDataDatHerramienta() throws Exception {
		try {
			List<DatHerramienta> datHerramienta = datHerramientaDAO.findAll();

			List<DatHerramientaDTO> datHerramientaDTO = new ArrayList<DatHerramientaDTO>();

			for (DatHerramienta datHerramientaTmp : datHerramienta) {
				DatHerramientaDTO datHerramientaDTO2 = new DatHerramientaDTO();

				datHerramientaDTO2.setDatHerramientaId(datHerramientaTmp
						.getDatHerramientaId());
				datHerramientaDTO2.setCantidadEntregada((datHerramientaTmp
						.getCantidadEntregada() != null) ? datHerramientaTmp
						.getCantidadEntregada() : null);
				datHerramientaDTO2
						.setCompania((datHerramientaTmp.getCompania() != null) ? datHerramientaTmp
								.getCompania() : null);
				datHerramientaDTO2.setConsecutivo((datHerramientaTmp
						.getConsecutivo() != null) ? datHerramientaTmp
						.getConsecutivo() : null);
				datHerramientaDTO2
						.setEstado((datHerramientaTmp.getEstado() != null) ? datHerramientaTmp
								.getEstado() : null);
				datHerramientaDTO2.setFechaCreacion(datHerramientaTmp
						.getFechaCreacion());
				datHerramientaDTO2.setFechaModificacion(datHerramientaTmp
						.getFechaModificacion());
				datHerramientaDTO2.setFechaRegistro(datHerramientaTmp
						.getFechaRegistro());
				datHerramientaDTO2.setInfoAdicional((datHerramientaTmp
						.getInfoAdicional() != null) ? datHerramientaTmp
						.getInfoAdicional() : null);
				datHerramientaDTO2.setInfoAdicional2((datHerramientaTmp
						.getInfoAdicional2() != null) ? datHerramientaTmp
						.getInfoAdicional2() : null);
				datHerramientaDTO2.setObservacion((datHerramientaTmp
						.getObservacion() != null) ? datHerramientaTmp
						.getObservacion() : null);
				datHerramientaDTO2.setObservacionAnularReg((datHerramientaTmp
						.getObservacionAnularReg() != null) ? datHerramientaTmp
						.getObservacionAnularReg() : null);
				datHerramientaDTO2.setTipoRegistro((datHerramientaTmp
						.getTipoRegistro() != null) ? datHerramientaTmp
						.getTipoRegistro() : null);
				datHerramientaDTO2.setUsuarioDigitacion((datHerramientaTmp
						.getUsuarioDigitacion() != null) ? datHerramientaTmp
						.getUsuarioDigitacion() : null);

				if (datHerramientaTmp.getAlmacen() != null) {
					datHerramientaDTO2.setAlmacenId_Almacen(datHerramientaTmp
							.getAlmacen().getAlmacenId());
				} else {
					datHerramientaDTO2.setAlmacenId_Almacen(null);
				}

				if (datHerramientaTmp.getProducto() != null) {
					datHerramientaDTO2.setProductoId_Producto(datHerramientaTmp
							.getProducto().getProductoId());
				} else {
					datHerramientaDTO2.setProductoId_Producto(null);
				}

				if (datHerramientaTmp.getTrabajador() != null) {
					datHerramientaDTO2.setTrabId_Trabajador(datHerramientaTmp
							.getTrabajador().getTrabId());
				} else {
					datHerramientaDTO2.setTrabId_Trabajador(null);
				}

				datHerramientaDTO2
						.setUdadMedId_UdadMed((datHerramientaTmp.getUdadMed()
								.getUdadMedId() != null) ? datHerramientaTmp
								.getUdadMed().getUdadMedId() : null);
				datHerramientaDTO.add(datHerramientaDTO2);
			}

			return datHerramientaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatHerramienta getDatHerramienta(Long datHerramientaId)
			throws Exception {
		log.debug("getting DatHerramienta instance");

		DatHerramienta entity = null;

		try {
			entity = datHerramientaDAO.findById(datHerramientaId);
		} catch (Exception e) {
			log.error("get DatHerramienta failed", e);
			throw new ZMessManager().new FindingException("DatHerramienta");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatHerramienta> findPageDatHerramienta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<DatHerramienta> entity = null;

		try {
			entity = datHerramientaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DatHerramienta Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatHerramienta() throws Exception {
		Long entity = null;

		try {
			entity = datHerramientaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DatHerramienta Count");
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
	@Transactional(readOnly = true)
	public List<DatHerramienta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DatHerramienta> list = new ArrayList<DatHerramienta>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null)
						&& (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null)
						&& (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null)
						&& (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0) ? ("(" + value + " "
							+ comparator1 + " " + variable + " and " + variable
							+ " " + comparator2 + " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1
									+ " " + variable + " and " + variable + " "
									+ comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null)
						&& (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0) ? ("(model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')") : (tempWhere + " AND (model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')");
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
			list = datHerramientaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
