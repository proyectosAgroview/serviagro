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

import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoDAO;
import co.com.arcosoft.dataaccess.dao.ITipoMantenimientoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.dto.TipoMantenimientoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoMantenimientoLogic")
public class TipoMantenimientoLogic implements ITipoMantenimientoLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoMantenimientoLogic.class);

	/**
	 * DAO injected by Spring that manages TipoMantenimiento entities
	 *
	 */
	@Autowired
	private ITipoMantenimientoDAO tipoMantenimientoDAO;

	/**
	 * DAO injected by Spring that manages DatMantenimientoEquipo entities
	 *
	 */
	@Autowired
	private IDatMantenimientoEquipoDAO datMantenimientoEquipoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoMantenimiento> getTipoMantenimiento() throws Exception {
		log.debug("finding all TipoMantenimiento instances");

		List<TipoMantenimiento> list = new ArrayList<TipoMantenimiento>();

		try {
			list = tipoMantenimientoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoMantenimiento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoMantenimiento");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		log.debug("saving TipoMantenimiento instance");

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

			tipoMantenimientoDAO.save(entity);

			log.debug("save TipoMantenimiento successful");
		} catch (Exception e) {
			log.error("save TipoMantenimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		log.debug("deleting TipoMantenimiento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoMantenimiento");
		}

		if (entity.getTipoMantenimientoId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoMantenimientoId");
		}

		List<DatMantenimientoEquipo> datMantenimientoEquipos = null;

		try {
			datMantenimientoEquipos = datMantenimientoEquipoDAO.findByProperty("tipoMantenimiento.tipoMantenimientoId",
					entity.getTipoMantenimientoId());

			if (Utilities.validationsList(datMantenimientoEquipos) == true) {
				throw new ZMessManager().new DeletingException("datMantenimientoEquipos");
			}

			tipoMantenimientoDAO.delete(entity);

			log.debug("delete TipoMantenimiento successful");
		} catch (Exception e) {
			log.error("delete TipoMantenimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		log.debug("updating TipoMantenimiento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoMantenimiento");
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

			if (entity.getTipoMantenimientoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoMantenimientoId");
			}

			if ((entity.getTipoMantenimientoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoMantenimientoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoMantenimientoId");
			}

			tipoMantenimientoDAO.update(entity);

			log.debug("update TipoMantenimiento successful");
		} catch (Exception e) {
			log.error("update TipoMantenimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoMantenimientoDTO> getDataTipoMantenimiento() throws Exception {
		try {
			List<TipoMantenimiento> tipoMantenimiento = tipoMantenimientoDAO.findAll();

			List<TipoMantenimientoDTO> tipoMantenimientoDTO = new ArrayList<TipoMantenimientoDTO>();

			for (TipoMantenimiento tipoMantenimientoTmp : tipoMantenimiento) {
				TipoMantenimientoDTO tipoMantenimientoDTO2 = new TipoMantenimientoDTO();

				tipoMantenimientoDTO2.setTipoMantenimientoId(tipoMantenimientoTmp.getTipoMantenimientoId());
				tipoMantenimientoDTO2.setCodigo(
						(tipoMantenimientoTmp.getCodigo() != null) ? tipoMantenimientoTmp.getCodigo() : null);
				tipoMantenimientoDTO2.setCompania(
						(tipoMantenimientoTmp.getCompania() != null) ? tipoMantenimientoTmp.getCompania() : null);
				tipoMantenimientoDTO2.setEstado(
						(tipoMantenimientoTmp.getEstado() != null) ? tipoMantenimientoTmp.getEstado() : null);
				tipoMantenimientoDTO2.setFechaCreacion(tipoMantenimientoTmp.getFechaCreacion());
				tipoMantenimientoDTO2.setFechaModificacion(tipoMantenimientoTmp.getFechaModificacion());
				tipoMantenimientoDTO2.setNombre(
						(tipoMantenimientoTmp.getNombre() != null) ? tipoMantenimientoTmp.getNombre() : null);
				tipoMantenimientoDTO.add(tipoMantenimientoDTO2);
			}

			return tipoMantenimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoMantenimiento getTipoMantenimiento(Long tipoMantenimientoId) throws Exception {
		log.debug("getting TipoMantenimiento instance");

		TipoMantenimiento entity = null;

		try {
			entity = tipoMantenimientoDAO.findById(tipoMantenimientoId);
		} catch (Exception e) {
			log.error("get TipoMantenimiento failed", e);
			throw new ZMessManager().new FindingException("TipoMantenimiento");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoMantenimiento> findPageTipoMantenimiento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TipoMantenimiento> entity = null;

		try {
			entity = tipoMantenimientoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoMantenimiento Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoMantenimiento() throws Exception {
		Long entity = null;

		try {
			entity = tipoMantenimientoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoMantenimiento Count");
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
	public List<TipoMantenimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoMantenimiento> list = new ArrayList<TipoMantenimiento>();
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
			list = tipoMantenimientoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
