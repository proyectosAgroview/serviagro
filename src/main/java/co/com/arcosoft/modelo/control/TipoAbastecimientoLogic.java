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

import co.com.arcosoft.dataaccess.dao.IDatAbastCombustibleDAO;
import co.com.arcosoft.dataaccess.dao.ITipoAbastecimientoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAbastCombustible;
import co.com.arcosoft.modelo.TipoAbastecimiento;
import co.com.arcosoft.modelo.dto.TipoAbastecimientoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoAbastecimientoLogic")
public class TipoAbastecimientoLogic implements ITipoAbastecimientoLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoAbastecimientoLogic.class);

	/**
	 * DAO injected by Spring that manages TipoAbastecimiento entities
	 *
	 */
	@Autowired
	private ITipoAbastecimientoDAO tipoAbastecimientoDAO;

	/**
	 * DAO injected by Spring that manages DatAbastCombustible entities
	 *
	 */
	@Autowired
	private IDatAbastCombustibleDAO datAbastCombustibleDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoAbastecimiento> getTipoAbastecimiento() throws Exception {
		log.debug("finding all TipoAbastecimiento instances");

		List<TipoAbastecimiento> list = new ArrayList<TipoAbastecimiento>();

		try {
			list = tipoAbastecimientoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoAbastecimiento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoAbastecimiento");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		log.debug("saving TipoAbastecimiento instance");

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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			tipoAbastecimientoDAO.save(entity);

			log.debug("save TipoAbastecimiento successful");
		} catch (Exception e) {
			log.error("save TipoAbastecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		log.debug("deleting TipoAbastecimiento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoAbastecimiento");
		}

		if (entity.getTipoAbastecimientoId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoAbastecimientoId");
		}

		List<DatAbastCombustible> datAbastCombustibles = null;

		try {
			datAbastCombustibles = datAbastCombustibleDAO.findByProperty("tipoAbastecimiento.tipoAbastecimientoId",
					entity.getTipoAbastecimientoId());

			if (Utilities.validationsList(datAbastCombustibles) == true) {
				throw new ZMessManager().new DeletingException("datAbastCombustibles");
			}

			tipoAbastecimientoDAO.delete(entity);

			log.debug("delete TipoAbastecimiento successful");
		} catch (Exception e) {
			log.error("delete TipoAbastecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		log.debug("updating TipoAbastecimiento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoAbastecimiento");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getTipoAbastecimientoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoAbastecimientoId");
			}

			if ((entity.getTipoAbastecimientoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoAbastecimientoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoAbastecimientoId");
			}

			tipoAbastecimientoDAO.update(entity);

			log.debug("update TipoAbastecimiento successful");
		} catch (Exception e) {
			log.error("update TipoAbastecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoAbastecimientoDTO> getDataTipoAbastecimiento() throws Exception {
		try {
			List<TipoAbastecimiento> tipoAbastecimiento = tipoAbastecimientoDAO.findAll();

			List<TipoAbastecimientoDTO> tipoAbastecimientoDTO = new ArrayList<TipoAbastecimientoDTO>();

			for (TipoAbastecimiento tipoAbastecimientoTmp : tipoAbastecimiento) {
				TipoAbastecimientoDTO tipoAbastecimientoDTO2 = new TipoAbastecimientoDTO();

				tipoAbastecimientoDTO2.setTipoAbastecimientoId(tipoAbastecimientoTmp.getTipoAbastecimientoId());
				tipoAbastecimientoDTO2.setCodigo(
						(tipoAbastecimientoTmp.getCodigo() != null) ? tipoAbastecimientoTmp.getCodigo() : null);
				tipoAbastecimientoDTO2.setCompania(
						(tipoAbastecimientoTmp.getCompania() != null) ? tipoAbastecimientoTmp.getCompania() : null);
				tipoAbastecimientoDTO2.setEstado(
						(tipoAbastecimientoTmp.getEstado() != null) ? tipoAbastecimientoTmp.getEstado() : null);
				tipoAbastecimientoDTO2.setFechaCreacion(tipoAbastecimientoTmp.getFechaCreacion());
				tipoAbastecimientoDTO2.setFechaModificacion(tipoAbastecimientoTmp.getFechaModificacion());
				tipoAbastecimientoDTO2.setNombre(
						(tipoAbastecimientoTmp.getNombre() != null) ? tipoAbastecimientoTmp.getNombre() : null);
				tipoAbastecimientoDTO.add(tipoAbastecimientoDTO2);
			}

			return tipoAbastecimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoAbastecimiento getTipoAbastecimiento(Long tipoAbastecimientoId) throws Exception {
		log.debug("getting TipoAbastecimiento instance");

		TipoAbastecimiento entity = null;

		try {
			entity = tipoAbastecimientoDAO.findById(tipoAbastecimientoId);
		} catch (Exception e) {
			log.error("get TipoAbastecimiento failed", e);
			throw new ZMessManager().new FindingException("TipoAbastecimiento");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoAbastecimiento> findPageTipoAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TipoAbastecimiento> entity = null;

		try {
			entity = tipoAbastecimientoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoAbastecimiento Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoAbastecimiento() throws Exception {
		Long entity = null;

		try {
			entity = tipoAbastecimientoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoAbastecimiento Count");
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
	public List<TipoAbastecimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoAbastecimiento> list = new ArrayList<TipoAbastecimiento>();
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
			list = tipoAbastecimientoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
