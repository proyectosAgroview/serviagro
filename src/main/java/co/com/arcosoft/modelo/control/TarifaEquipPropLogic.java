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

import co.com.arcosoft.dataaccess.dao.ITarifaEquipPropDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaEquipPropLogic")
public class TarifaEquipPropLogic implements ITarifaEquipPropLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaEquipPropLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaEquipProp entities
	 *
	 */
	@Autowired
	private ITarifaEquipPropDAO tarifaEquipPropDAO;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo1;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed2;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor1;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaEquipProp> getTarifaEquipProp() throws Exception {
		log.debug("finding all TarifaEquipProp instances");

		List<TarifaEquipProp> list = new ArrayList<TarifaEquipProp>();

		try {
			list = tarifaEquipPropDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaEquipProp failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaEquipProp");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		log.debug("saving TarifaEquipProp instance");

		try {
			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaEquipPropId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaEquipPropId");
			}

			if ((entity.getTarifaEquipPropId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaEquipPropId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaEquipPropId");
			}

			if ((entity.getEquipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId_Equipo");
			}

			if ((entity.getUdadMed() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if ((entity.getLabor_tarifa() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor_tarifa(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_tarifa");
			}

			if (getTarifaEquipProp(entity.getTarifaEquipPropId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tarifaEquipPropDAO.save(entity);

			log.debug("save TarifaEquipProp successful");
		} catch (Exception e) {
			log.error("save TarifaEquipProp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		log.debug("deleting TarifaEquipProp instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaEquipProp");
		}

		if (entity.getTarifaEquipPropId() == null) {
			throw new ZMessManager().new EmptyFieldException("tarifaEquipPropId");
		}

		try {
			tarifaEquipPropDAO.delete(entity);

			log.debug("delete TarifaEquipProp successful");
		} catch (Exception e) {
			log.error("delete TarifaEquipProp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		log.debug("updating TarifaEquipProp instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaEquipProp");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaEquipPropId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaEquipPropId");
			}

			if ((entity.getTarifaEquipPropId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaEquipPropId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaEquipPropId");
			}
			/*
			 * if ((entity.getEquipo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEquipo(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("Equipo"); }
			 * 
			 * if ((entity.getUdadMed() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getUdadMed(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			 * }
			 * 
			 * if ((entity.getLabor_tarifa() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getLabor_tarifa(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("laborId_tarifa"); }
			 */

			tarifaEquipPropDAO.update(entity);

			log.debug("update TarifaEquipProp successful");
		} catch (Exception e) {
			log.error("update TarifaEquipProp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaEquipPropDTO> getDataTarifaEquipProp() throws Exception {
		try {
			List<TarifaEquipProp> tarifaEquipProp = tarifaEquipPropDAO.findAll();

			List<TarifaEquipPropDTO> tarifaEquipPropDTO = new ArrayList<TarifaEquipPropDTO>();

			for (TarifaEquipProp tarifaEquipPropTmp : tarifaEquipProp) {
				TarifaEquipPropDTO tarifaEquipPropDTO2 = new TarifaEquipPropDTO();

				tarifaEquipPropDTO2.setTarifaEquipPropId(tarifaEquipPropTmp.getTarifaEquipPropId());
				tarifaEquipPropDTO2.setCompania(
						(tarifaEquipPropTmp.getCompania() != null) ? tarifaEquipPropTmp.getCompania() : null);
				tarifaEquipPropDTO2.setFechaCreacion(tarifaEquipPropTmp.getFechaCreacion());
				tarifaEquipPropDTO2.setFechaFinal(tarifaEquipPropTmp.getFechaFinal());
				tarifaEquipPropDTO2.setFechaInicial(tarifaEquipPropTmp.getFechaInicial());
				tarifaEquipPropDTO2.setFechaModificacion(tarifaEquipPropTmp.getFechaModificacion());
				tarifaEquipPropDTO2
						.setTarifa((tarifaEquipPropTmp.getTarifa() != null) ? tarifaEquipPropTmp.getTarifa() : null);

				tarifaEquipPropDTO2.setUdadMedId_UdadMed(
						(tarifaEquipPropTmp.getUdadMed() != null) ? tarifaEquipPropTmp.getUdadMed() : null);

				if (tarifaEquipPropTmp.getTarifaEquipPropId() != null) {
					tarifaEquipPropDTO2.setEquipoId_Equipo(tarifaEquipPropTmp.getTarifaEquipPropId());
				} else {
					tarifaEquipPropDTO2.setEquipoId_Equipo(null);
				}

				if (tarifaEquipPropTmp.getUdadMed() != null) {
					tarifaEquipPropDTO2.setCodUdadMed(tarifaEquipPropTmp.getUdadMed().getCodigo());
				} else {
					tarifaEquipPropDTO2.setCodUdadMed(null);
				}

				tarifaEquipPropDTO.add(tarifaEquipPropDTO2);

			}

			return tarifaEquipPropDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaEquipProp getTarifaEquipProp(Long tarifaEquipPropId) throws Exception {
		log.debug("getting TarifaEquipProp instance");

		TarifaEquipProp entity = null;

		try {
			entity = tarifaEquipPropDAO.findById(tarifaEquipPropId);
		} catch (Exception e) {
			log.error("get TarifaEquipProp failed", e);
			throw new ZMessManager().new FindingException("TarifaEquipProp");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaEquipProp> findPageTarifaEquipProp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TarifaEquipProp> entity = null;

		try {
			entity = tarifaEquipPropDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaEquipProp Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaEquipProp() throws Exception {
		Long entity = null;

		try {
			entity = tarifaEquipPropDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaEquipProp Count");
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
	public List<TarifaEquipProp> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaEquipProp> list = new ArrayList<TarifaEquipProp>();
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
			list = tarifaEquipPropDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaEquipPropDTO> getDataEquipoByTarifaEquipPropId(Long equipoId) throws Exception {
		try {
			List<TarifaEquipProp> tarifaEquipProp = tarifaEquipPropDAO.findByCriteria("equipo.equipoId= " + equipoId);

			List<TarifaEquipPropDTO> TarifaEquipPropDTO = new ArrayList<TarifaEquipPropDTO>();

			for (TarifaEquipProp tarifaEquipPropTmp : tarifaEquipProp) {
				TarifaEquipPropDTO TarifaEquipPropDTO2 = new TarifaEquipPropDTO();

				TarifaEquipPropDTO2.setTarifaEquipPropId((tarifaEquipPropTmp.getTarifaEquipPropId()));

				TarifaEquipPropDTO2.setCompania(((tarifaEquipPropTmp.getCompania())));
				TarifaEquipPropDTO2.setFechaCreacion(((tarifaEquipPropTmp.getFechaCreacion())));
				TarifaEquipPropDTO2.setFechaModificacion(((tarifaEquipPropTmp.getFechaModificacion())));
				TarifaEquipPropDTO2.setFechaInicial(((tarifaEquipPropTmp.getFechaInicial())));
				TarifaEquipPropDTO2.setFechaFinal(((tarifaEquipPropTmp.getFechaFinal())));
				TarifaEquipPropDTO2.setTarifa(((tarifaEquipPropTmp.getTarifa())));
				TarifaEquipPropDTO2.setUdadMedId_UdadMed(((tarifaEquipPropTmp.getUdadMed())));
				TarifaEquipPropDTO2.setLabor_tarifa(tarifaEquipPropTmp.getLabor_tarifa());

				if (tarifaEquipPropTmp.getTarifaEquipPropId() != null) {
					TarifaEquipPropDTO2.setEquipoId_Equipo(tarifaEquipPropTmp.getTarifaEquipPropId());
				} else {
					TarifaEquipPropDTO2.setEquipoId_Equipo(null);
				}

				if (tarifaEquipPropTmp.getLabor_tarifa() != null) {

					TarifaEquipPropDTO2.setCodLabortarifa(tarifaEquipPropTmp.getLabor_tarifa().getCodigo());

				} else {

					TarifaEquipPropDTO2.setCodLabortarifa(null);

				}

				if (tarifaEquipPropTmp.getUdadMed() != null) {
					TarifaEquipPropDTO2.setCodUdadMed(tarifaEquipPropTmp.getUdadMed().getCodigo());
				} else {
					TarifaEquipPropDTO2.setCodUdadMed(null);
				}

				TarifaEquipPropDTO.add(TarifaEquipPropDTO2);
			}

			return TarifaEquipPropDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
