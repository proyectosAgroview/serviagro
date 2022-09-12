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

import co.com.arcosoft.dataaccess.dao.IDatTransProdDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatTransProdDetLogic")
public class DatTransProdDetLogic implements IDatTransProdDetLogic {
	private static final Logger log = LoggerFactory.getLogger(DatTransProdDetLogic.class);

	/**
	 * DAO injected by Spring that manages DatTransProdDet entities
	 *
	 */
	@Autowired
	private IDatTransProdDetDAO datTransProdDetDAO;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad1;

	/**
	 * Logic injected by Spring that manages Cliente entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	IDatTransProdLogic logicDatTransProd3;

	/**
	 * Logic injected by Spring that manages Empaque entities
	 *
	 */
	@Autowired
	IEmpaqueLogic logicEmpaque4;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto5;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed6;

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDet> getDatTransProdDet() throws Exception {
		log.debug("finding all DatTransProdDet instances");

		List<DatTransProdDet> list = new ArrayList<DatTransProdDet>();

		try {
			list = datTransProdDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatTransProdDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatTransProdDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatTransProdDet(DatTransProdDet entity) throws Exception {
		log.debug("saving DatTransProdDet instance");

		try {

			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			if ((entity.getCliente() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCliente(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("clienteId_Cliente");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			if ((entity.getEmpaque() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpaque(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId_Empaque");
			}

			if ((entity.getProducto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			if ((entity.getUdadMed() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}
			datTransProdDetDAO.save(entity);

			log.debug("save DatTransProdDet successful");
		} catch (Exception e) {
			log.error("save DatTransProdDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatTransProdDet(DatTransProdDet entity) throws Exception {
		log.debug("deleting DatTransProdDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatTransProdDet");
		}

		if (entity.getDatTransProdDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("datTransProdDetId");
		}

		try {
			datTransProdDetDAO.delete(entity);

			log.debug("delete DatTransProdDet successful");
		} catch (Exception e) {
			log.error("delete DatTransProdDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatTransProdDet(DatTransProdDet entity) throws Exception {
		log.debug("updating DatTransProdDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatTransProdDet");
			}
			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDatTransProdDetId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdDetId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdDetId");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			if ((entity.getEmpaque() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpaque(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId_Empaque");
			}

			datTransProdDetDAO.update(entity);

			log.debug("update DatTransProdDet successful");
		} catch (Exception e) {
			log.error("update DatTransProdDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDetDTO> getDataDatTransProdDet() throws Exception {
		try {
			List<DatTransProdDet> datTransProdDet = datTransProdDetDAO.findAll();

			List<DatTransProdDetDTO> datTransProdDetDTO = new ArrayList<DatTransProdDetDTO>();

			for (DatTransProdDet datTransProdDetTmp : datTransProdDet) {
				DatTransProdDetDTO datTransProdDetDTO2 = new DatTransProdDetDTO();

				datTransProdDetDTO2.setDatTransProdDetId(datTransProdDetTmp.getDatTransProdDetId());
				datTransProdDetDTO2.setAreaCosechada(
						(datTransProdDetTmp.getAreaCosechada() != null) ? datTransProdDetTmp.getAreaCosechada() : null);
				
				datTransProdDetDTO2.setCertificacionAceite(
						(datTransProdDetTmp.getCertificacionAceite() != null) ? datTransProdDetTmp.getCertificacionAceite() : null);
				
				datTransProdDetDTO2.setCantidadReal(
						(datTransProdDetTmp.getCantidadReal() != null) ? datTransProdDetTmp.getCantidadReal() : null);
				datTransProdDetDTO2.setCantidadSolicitada((datTransProdDetTmp.getCantidadSolicitada() != null)
						? datTransProdDetTmp.getCantidadSolicitada() : null);
				datTransProdDetDTO2.setCompania(
						(datTransProdDetTmp.getCompania() != null) ? datTransProdDetTmp.getCompania() : null);
				datTransProdDetDTO2.setConsecutivo(
						(datTransProdDetTmp.getConsecutivo() != null) ? datTransProdDetTmp.getConsecutivo() : null);
				datTransProdDetDTO2.setDocumetoErp(
						(datTransProdDetTmp.getDocumetoErp() != null) ? datTransProdDetTmp.getDocumetoErp() : null);
				datTransProdDetDTO2.setValorTotal(
						(datTransProdDetTmp.getValorTotal() != null) ? datTransProdDetTmp.getValorTotal() : null);
				datTransProdDetDTO2.setValorUnitario(
						(datTransProdDetTmp.getValorUnitario() != null) ? datTransProdDetTmp.getValorUnitario() : null);

				datTransProdDetDTO2.setValorDeduccion((datTransProdDetTmp.getValorDeduccion() != null)
						? datTransProdDetTmp.getValorDeduccion() : null);

				datTransProdDetDTO2.setValorNeto(
						(datTransProdDetTmp.getValorNeto() != null) ? datTransProdDetTmp.getValorNeto() : null);

				if (datTransProdDetTmp.getCiudad() != null) {
					datTransProdDetDTO2.setCiudadId_Ciudad(datTransProdDetTmp.getCiudad());
				} else {
					datTransProdDetDTO2.setCiudadId_Ciudad(null);
				}

				if (datTransProdDetTmp.getCliente() != null) {
					datTransProdDetDTO2.setClienteId_Cliente(datTransProdDetTmp.getCliente());
				} else {
					datTransProdDetDTO2.setClienteId_Cliente(null);
				}

				datTransProdDetDTO2.setDatTransProdId_DatTransProd(
						(datTransProdDetTmp.getDatTransProd().getDatTransProdId() != null)
								? datTransProdDetTmp.getDatTransProd().getDatTransProdId() : null);

				if (datTransProdDetTmp.getEmpaque() != null) {
					datTransProdDetDTO2.setEmpaqueId_Empaque(datTransProdDetTmp.getEmpaque());
				} else {
					datTransProdDetDTO2.setEmpaqueId_Empaque(null);
				}

				if (datTransProdDetTmp.getProducto() != null) {
					datTransProdDetDTO2.setProductoId_Producto(datTransProdDetTmp.getProducto());
				} else {
					datTransProdDetDTO2.setProductoId_Producto(null);
				}

				datTransProdDetDTO2.setUdadMedId_UdadMed(
						(datTransProdDetTmp.getUdadMed() != null) ? datTransProdDetTmp.getUdadMed() : null);

				if (datTransProdDetTmp.getProducto() != null) {
					datTransProdDetDTO2.setNombreProducto(datTransProdDetTmp.getProducto().getNombre());
				} else {
					datTransProdDetDTO2.setNombreProducto(null);
				}

				if (datTransProdDetTmp.getCiudad() != null) {
					datTransProdDetDTO2.setNombreCiudad(datTransProdDetTmp.getCiudad().getNombre());
				} else {
					datTransProdDetDTO2.setNombreCiudad(null);
				}

				if (datTransProdDetTmp.getEmpaque() != null) {
					datTransProdDetDTO2.setCodigoEmpaque(datTransProdDetTmp.getEmpaque().getCodigo());
				} else {
					datTransProdDetDTO2.setCodigoEmpaque(null);
				}

				if (datTransProdDetTmp.getCliente() != null) {
					datTransProdDetDTO2.setNombreCliente(datTransProdDetTmp.getCliente().getCodigo());
				} else {
					datTransProdDetDTO2.setNombreCliente(null);
				}

				if (datTransProdDetTmp.getUdadMed() != null) {
					datTransProdDetDTO2.setNombreUdadeMed(datTransProdDetTmp.getUdadMed().getNombre());
				} else {
					datTransProdDetDTO2.setNombreUdadeMed(null);
				}

				datTransProdDetDTO2.setCantidadKilosLiq((datTransProdDetTmp.getCantidadKilosLiq() != null)
						? datTransProdDetTmp.getCantidadKilosLiq() : null);

				datTransProdDetDTO.add(datTransProdDetDTO2);

			}

			return datTransProdDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatTransProdDet getDatTransProdDet(Long datTransProdDetId) throws Exception {
		log.debug("getting DatTransProdDet instance");

		DatTransProdDet entity = null;

		try {
			entity = datTransProdDetDAO.findById(datTransProdDetId);
		} catch (Exception e) {
			log.error("get DatTransProdDet failed", e);
			throw new ZMessManager().new FindingException("DatTransProdDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDet> findPageDatTransProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatTransProdDet> entity = null;

		try {
			entity = datTransProdDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatTransProdDet() throws Exception {
		Long entity = null;

		try {
			entity = datTransProdDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdDet Count");
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
	public List<DatTransProdDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatTransProdDet> list = new ArrayList<DatTransProdDet>();
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
			list = datTransProdDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDetDTO> getDataDetTransProductosByDatTransProdId(Long datTransProdId) throws Exception {
		try {
			List<DatTransProdDet> datTransProdDet = datTransProdDetDAO
					.findByCriteria("datTransProd.datTransProdId= " + datTransProdId);

			List<DatTransProdDetDTO> DatTransProdDetDTO = new ArrayList<DatTransProdDetDTO>();

			for (DatTransProdDet datTransProdDetTmp : datTransProdDet) {
				DatTransProdDetDTO DatTransProdDetDTO2 = new DatTransProdDetDTO();

				DatTransProdDetDTO2.setDatTransProdDetId(datTransProdDetTmp.getDatTransProdDetId());
				DatTransProdDetDTO2.setProductoId_Producto(
						(datTransProdDetTmp.getProducto() != null) ? datTransProdDetTmp.getProducto() : null);
				DatTransProdDetDTO2.setCertificacionAceite(
						(datTransProdDetTmp.getCertificacionAceite() != null) ? datTransProdDetTmp.getCertificacionAceite() : null);
				DatTransProdDetDTO2.setUdadMedId_UdadMed(
						(datTransProdDetTmp.getUdadMed() != null) ? datTransProdDetTmp.getUdadMed() : null);
				DatTransProdDetDTO2.setCiudadId_Ciudad(
						(datTransProdDetTmp.getCiudad() != null) ? datTransProdDetTmp.getCiudad() : null);
				DatTransProdDetDTO2.setClienteId_Cliente(
						(datTransProdDetTmp.getCliente() != null) ? datTransProdDetTmp.getCliente() : null);
				DatTransProdDetDTO2.setEmpaqueId_Empaque(
						(datTransProdDetTmp.getEmpaque() != null) ? datTransProdDetTmp.getEmpaque() : null);
				DatTransProdDetDTO2.setAreaCosechada(
						(datTransProdDetTmp.getAreaCosechada() != null) ? datTransProdDetTmp.getAreaCosechada() : null);
				DatTransProdDetDTO2.setCantidadSolicitada((datTransProdDetTmp.getCantidadSolicitada() != null)
						? datTransProdDetTmp.getCantidadSolicitada() : null);
				DatTransProdDetDTO2.setCantidadReal(
						(datTransProdDetTmp.getCantidadReal() != null) ? datTransProdDetTmp.getCantidadReal() : null);
				DatTransProdDetDTO2.setValorUnitario(
						(datTransProdDetTmp.getValorUnitario() != null) ? datTransProdDetTmp.getValorUnitario() : null);
				DatTransProdDetDTO2.setValorTotal(
						(datTransProdDetTmp.getValorTotal() != null) ? datTransProdDetTmp.getValorTotal() : null);
				DatTransProdDetDTO2.setValorDeduccion((datTransProdDetTmp.getValorDeduccion() != null)
						? datTransProdDetTmp.getValorDeduccion() : null);
				DatTransProdDetDTO2.setValorNeto(
						(datTransProdDetTmp.getValorNeto() != null) ? datTransProdDetTmp.getValorNeto() : null);
				DatTransProdDetDTO2.setCantidadKilosLiq((datTransProdDetTmp.getCantidadKilosLiq() != null)
						? datTransProdDetTmp.getCantidadKilosLiq() : null);

				if (datTransProdDetTmp.getDatTransProd() != null) {
					DatTransProdDetDTO2
							.setDatTransProdId_DatTransProd(datTransProdDetTmp.getDatTransProd().getDatTransProdId());
				} else {
					DatTransProdDetDTO2.setDatTransProdId_DatTransProd(null);
				}

				if (datTransProdDetTmp.getProducto() != null) {
					DatTransProdDetDTO2.setNombreProducto(datTransProdDetTmp.getProducto().getNombre());
				} else {
					DatTransProdDetDTO2.setNombreProducto(null);
				}

				if (datTransProdDetTmp.getCiudad() != null) {
					DatTransProdDetDTO2.setNombreCiudad(datTransProdDetTmp.getCiudad().getNombre());
				} else {
					DatTransProdDetDTO2.setNombreCiudad(null);
				}

				if (datTransProdDetTmp.getEmpaque() != null) {
					DatTransProdDetDTO2.setCodigoEmpaque(datTransProdDetTmp.getEmpaque().getCodigo());
				} else {
					DatTransProdDetDTO2.setCodigoEmpaque(null);
				}

				if (datTransProdDetTmp.getCliente() != null) {
					DatTransProdDetDTO2.setNombreCliente(datTransProdDetTmp.getCliente().getNombre());
				} else {
					DatTransProdDetDTO2.setNombreCliente(null);
				}
				
				

				if (datTransProdDetTmp.getUdadMed() != null) {
					DatTransProdDetDTO2.setNombreUdadeMed(datTransProdDetTmp.getUdadMed().getNombre());
				} else {
					DatTransProdDetDTO2.setNombreUdadeMed(null);
				}
				DatTransProdDetDTO.add(DatTransProdDetDTO2);
			}

			return DatTransProdDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
