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

import co.com.arcosoft.dataaccess.dao.IPersEmprDAO;
import co.com.arcosoft.dataaccess.dao.ITipoClienteDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.TipoCliente;
import co.com.arcosoft.modelo.dto.TipoClienteDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoClienteLogic")
public class TipoClienteLogic implements ITipoClienteLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoClienteLogic.class);

	/**
	 * DAO injected by Spring that manages TipoCliente entities
	 *
	 */
	@Autowired
	private ITipoClienteDAO tipoClienteDAO;

	/**
	 * DAO injected by Spring that manages Cliente entities
	 *
	 */
	@Autowired
	private IPersEmprDAO clienteDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoCliente> getTipoCliente() throws Exception {
		log.debug("finding all TipoCliente instances");

		List<TipoCliente> list = new ArrayList<TipoCliente>();

		try {
			list = tipoClienteDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoCliente failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoCliente");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoCliente(TipoCliente entity) throws Exception {
		log.debug("saving TipoCliente instance");

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
			 * if (entity.getTipoClienteId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "tipoClienteId"); }
			 * 
			 * if ((entity.getTipoClienteId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoClienteId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "tipoClienteId"); }
			 * 
			 * if (getTipoCliente(entity.getTipoClienteId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			tipoClienteDAO.save(entity);

			log.debug("save TipoCliente successful");
		} catch (Exception e) {
			log.error("save TipoCliente failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoCliente(TipoCliente entity) throws Exception {
		log.debug("deleting TipoCliente instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoCliente");
		}

		if (entity.getTipoClienteId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoClienteId");
		}

		List<PersEmpr> clientes = null;

		try {
			clientes = clienteDAO.findByProperty("tipoCliente.tipoClienteId", entity.getTipoClienteId());

			if (Utilities.validationsList(clientes) == true) {
				throw new ZMessManager().new DeletingException("clientes");
			}

			tipoClienteDAO.delete(entity);

			log.debug("delete TipoCliente successful");
		} catch (Exception e) {
			log.error("delete TipoCliente failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoCliente(TipoCliente entity) throws Exception {
		log.debug("updating TipoCliente instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoCliente");
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

			if (entity.getTipoClienteId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoClienteId");
			}

			if ((entity.getTipoClienteId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoClienteId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoClienteId");
			}

			tipoClienteDAO.update(entity);

			log.debug("update TipoCliente successful");
		} catch (Exception e) {
			log.error("update TipoCliente failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoClienteDTO> getDataTipoCliente() throws Exception {
		try {
			List<TipoCliente> tipoCliente = tipoClienteDAO.findAll();

			List<TipoClienteDTO> tipoClienteDTO = new ArrayList<TipoClienteDTO>();

			for (TipoCliente tipoClienteTmp : tipoCliente) {
				TipoClienteDTO tipoClienteDTO2 = new TipoClienteDTO();

				tipoClienteDTO2.setTipoClienteId(tipoClienteTmp.getTipoClienteId());
				tipoClienteDTO2.setCodigo((tipoClienteTmp.getCodigo() != null) ? tipoClienteTmp.getCodigo() : null);
				tipoClienteDTO2
						.setCompania((tipoClienteTmp.getCompania() != null) ? tipoClienteTmp.getCompania() : null);
				tipoClienteDTO2.setEstado((tipoClienteTmp.getEstado() != null) ? tipoClienteTmp.getEstado() : null);
				tipoClienteDTO2.setFechaCreacion(
						(tipoClienteTmp.getFechaCreacion() != null) ? tipoClienteTmp.getFechaCreacion() : null);
				tipoClienteDTO2.setFechaModificacion(
						(tipoClienteTmp.getFechaModificacion() != null) ? tipoClienteTmp.getFechaModificacion() : null);
				tipoClienteDTO2.setInfoAdicional(
						(tipoClienteTmp.getInfoAdicional() != null) ? tipoClienteTmp.getInfoAdicional() : null);
				tipoClienteDTO2.setInfoAdicional2(
						(tipoClienteTmp.getInfoAdicional2() != null) ? tipoClienteTmp.getInfoAdicional2() : null);
				tipoClienteDTO2.setNombre((tipoClienteTmp.getNombre() != null) ? tipoClienteTmp.getNombre() : null);
				tipoClienteDTO.add(tipoClienteDTO2);
			}

			return tipoClienteDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoCliente getTipoCliente(Long tipoClienteId) throws Exception {
		log.debug("getting TipoCliente instance");

		TipoCliente entity = null;

		try {
			entity = tipoClienteDAO.findById(tipoClienteId);
		} catch (Exception e) {
			log.error("get TipoCliente failed", e);
			throw new ZMessManager().new FindingException("TipoCliente");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoCliente> findPageTipoCliente(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TipoCliente> entity = null;

		try {
			entity = tipoClienteDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoCliente Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoCliente() throws Exception {
		Long entity = null;

		try {
			entity = tipoClienteDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoCliente Count");
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
	public List<TipoCliente> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoCliente> list = new ArrayList<TipoCliente>();
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
			list = tipoClienteDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
