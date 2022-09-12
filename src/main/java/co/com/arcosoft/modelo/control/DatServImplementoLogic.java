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

import co.com.arcosoft.dataaccess.dao.IDatServImplementoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServImplemento;
import co.com.arcosoft.modelo.dto.DatServImplementoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatServImplementoLogic")
public class DatServImplementoLogic implements IDatServImplementoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatServImplementoLogic.class);

	/**
	 * DAO injected by Spring that manages DatServImplemento entities
	 *
	 */
	@Autowired
	private IDatServImplementoDAO datServImplementoDAO;

	/**
	 * Logic injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	IDatServicioLogic logicDatServicio1;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo2;

	/**
	 * Logic injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	IServicioLogic logicServicio3;

	@Override
	@Transactional(readOnly = true)
	public List<DatServImplemento> getDatServImplemento() throws Exception {
		log.debug("finding all DatServImplemento instances");

		List<DatServImplemento> list = new ArrayList<DatServImplemento>();

		try {
			list = datServImplementoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatServImplemento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatServImplemento");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatServImplemento(DatServImplemento entity) throws Exception {
		log.debug("saving DatServImplemento instance");

		try {
			if (entity.getDatServicio() == null) {
				throw new ZMessManager().new ForeignException("datServicio");
			}

			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getServicio() == null) {
				throw new ZMessManager().new ForeignException("servicio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getCostoTotalImplemento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotalImplemento(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotalImplemento");
			}

			if (entity.getDatServImpleId() == null) {
				throw new ZMessManager().new EmptyFieldException("datServImpleId");
			}

			if ((entity.getDatServImpleId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatServImpleId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datServImpleId");
			}

			if ((entity.getTarifaImplemento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaImplemento(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaImplemento");
			}

			if (entity.getDatServicio().getDatServicioId() == null) {
				throw new ZMessManager().new EmptyFieldException("datServicioId_DatServicio");
			}

			if ((entity.getDatServicio().getDatServicioId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatServicio().getDatServicioId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datServicioId_DatServicio");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if ((entity.getEquipo().getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo().getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId_Equipo");
			}

			if (entity.getServicio().getServicioId() == null) {
				throw new ZMessManager().new EmptyFieldException("servicioId_Servicio");
			}

			if ((entity.getServicio().getServicioId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getServicio().getServicioId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("servicioId_Servicio");
			}

			if (getDatServImplemento(entity.getDatServImpleId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datServImplementoDAO.save(entity);

			log.debug("save DatServImplemento successful");
		} catch (Exception e) {
			log.error("save DatServImplemento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatServImplemento(DatServImplemento entity) throws Exception {
		log.debug("deleting DatServImplemento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatServImplemento");
		}

		if (entity.getDatServImpleId() == null) {
			throw new ZMessManager().new EmptyFieldException("datServImpleId");
		}

		try {
			datServImplementoDAO.delete(entity);

			log.debug("delete DatServImplemento successful");
		} catch (Exception e) {
			log.error("delete DatServImplemento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatServImplemento(DatServImplemento entity) throws Exception {
		log.debug("updating DatServImplemento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatServImplemento");
			}

			if (entity.getDatServicio() == null) {
				throw new ZMessManager().new ForeignException("datServicio");
			}

			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getServicio() == null) {
				throw new ZMessManager().new ForeignException("servicio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getCostoTotalImplemento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotalImplemento(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotalImplemento");
			}

			if (entity.getDatServImpleId() == null) {
				throw new ZMessManager().new EmptyFieldException("datServImpleId");
			}

			if ((entity.getDatServImpleId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatServImpleId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datServImpleId");
			}

			if ((entity.getTarifaImplemento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaImplemento(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaImplemento");
			}

			if (entity.getDatServicio().getDatServicioId() == null) {
				throw new ZMessManager().new EmptyFieldException("datServicioId_DatServicio");
			}

			if ((entity.getDatServicio().getDatServicioId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatServicio().getDatServicioId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datServicioId_DatServicio");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if ((entity.getEquipo().getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo().getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId_Equipo");
			}

			if (entity.getServicio().getServicioId() == null) {
				throw new ZMessManager().new EmptyFieldException("servicioId_Servicio");
			}

			if ((entity.getServicio().getServicioId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getServicio().getServicioId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("servicioId_Servicio");
			}

			datServImplementoDAO.update(entity);

			log.debug("update DatServImplemento successful");
		} catch (Exception e) {
			log.error("update DatServImplemento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServImplementoDTO> getDataDatServImplemento() throws Exception {
		try {
			List<DatServImplemento> datServImplemento = datServImplementoDAO.findAll();

			List<DatServImplementoDTO> datServImplementoDTO = new ArrayList<DatServImplementoDTO>();

			for (DatServImplemento datServImplementoTmp : datServImplemento) {
				DatServImplementoDTO datServImplementoDTO2 = new DatServImplementoDTO();

				datServImplementoDTO2.setDatServImpleId(datServImplementoTmp.getDatServImpleId());
				datServImplementoDTO2.setCompania(
						(datServImplementoTmp.getCompania() != null) ? datServImplementoTmp.getCompania() : null);
				datServImplementoDTO2.setCostoTotalImplemento((datServImplementoTmp.getCostoTotalImplemento() != null)
						? datServImplementoTmp.getCostoTotalImplemento() : null);
				datServImplementoDTO2.setTarifaImplemento((datServImplementoTmp.getTarifaImplemento() != null)
						? datServImplementoTmp.getTarifaImplemento() : null);
				datServImplementoDTO2
						.setDatServicioId_DatServicio((datServImplementoTmp.getDatServicio().getDatServicioId() != null)
								? datServImplementoTmp.getDatServicio().getDatServicioId() : null);

				if (datServImplementoTmp.getEquipo() != null) {
					datServImplementoDTO2.setEquipoId_Equipo(datServImplementoTmp.getEquipo().getEquipoId());
				} else {
					datServImplementoDTO2.setEquipoId_Equipo(null);
				}

				if (datServImplementoTmp.getServicio() != null) {
					datServImplementoDTO2.setServicioId_Servicio(datServImplementoTmp.getServicio().getServicioId());
				} else {
					datServImplementoDTO2.setServicioId_Servicio(null);
				}

				datServImplementoDTO.add(datServImplementoDTO2);
			}

			return datServImplementoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatServImplemento getDatServImplemento(Long datServImpleId) throws Exception {
		log.debug("getting DatServImplemento instance");

		DatServImplemento entity = null;

		try {
			entity = datServImplementoDAO.findById(datServImpleId);
		} catch (Exception e) {
			log.error("get DatServImplemento failed", e);
			throw new ZMessManager().new FindingException("DatServImplemento");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServImplemento> findPageDatServImplemento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatServImplemento> entity = null;

		try {
			entity = datServImplementoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServImplemento Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatServImplemento() throws Exception {
		Long entity = null;

		try {
			entity = datServImplementoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServImplemento Count");
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
	public List<DatServImplemento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatServImplemento> list = new ArrayList<DatServImplemento>();
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
			list = datServImplementoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
