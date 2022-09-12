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

import co.com.arcosoft.dataaccess.dao.ICronogramaLaboresLaboresDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CronogramaLaboresLabores;
import co.com.arcosoft.modelo.dto.CronogramaLaboresLaboresDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CronogramaLaboresLaboresLogic")
public class CronogramaLaboresLaboresLogic implements ICronogramaLaboresLaboresLogic {
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresLaboresLogic.class);

	/**
	 * DAO injected by Spring that manages CronogramaLaboresLabores entities
	 *
	 */
	@Autowired
	private ICronogramaLaboresLaboresDAO cronogramaLaboresLaboresDAO;

	/**
	 * Logic injected by Spring that manages CronogramaLabores entities
	 *
	 */
	@Autowired
	ICronogramaLaboresLogic logicCronogramaLabores1;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor2;

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresLabores> getCronogramaLaboresLabores() throws Exception {
		log.debug("finding all CronogramaLaboresLabores instances");

		List<CronogramaLaboresLabores> list = new ArrayList<CronogramaLaboresLabores>();

		try {
			list = cronogramaLaboresLaboresDAO.findAll();
		} catch (Exception e) {
			log.error("finding all CronogramaLaboresLabores failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "CronogramaLaboresLabores");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		log.debug("saving CronogramaLaboresLabores instance");

		try {
			if (entity.getCronogramaLabores() == null) {
				throw new ZMessManager().new ForeignException("cronogramaLabores");
			}

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getCronogramaLaboresLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresLaboresId");
			}

			if ((entity.getCronogramaLaboresLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCronogramaLaboresLaboresId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresLaboresId");
			}

			if ((entity.getDuracion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDuracion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("duracion");
			}

			if ((entity.getNumeroDiasFin() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDiasFin(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDiasFin");
			}

			if ((entity.getNumeroDiasInicio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDiasInicio(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDiasInicio");
			}

			if (entity.getCronogramaLabores().getCronogramaLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId_CronogramaLabores");
			}

			if ((entity.getCronogramaLabores().getCronogramaLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCronogramaLabores().getCronogramaLaboresId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresId_CronogramaLabores");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if ((entity.getLabor().getLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
			}

			if (getCronogramaLaboresLabores(entity.getCronogramaLaboresLaboresId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			cronogramaLaboresLaboresDAO.save(entity);

			log.debug("save CronogramaLaboresLabores successful");
		} catch (Exception e) {
			log.error("save CronogramaLaboresLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		log.debug("deleting CronogramaLaboresLabores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CronogramaLaboresLabores");
		}

		if (entity.getCronogramaLaboresLaboresId() == null) {
			throw new ZMessManager().new EmptyFieldException("cronogramaLaboresLaboresId");
		}

		try {
			cronogramaLaboresLaboresDAO.delete(entity);

			log.debug("delete CronogramaLaboresLabores successful");
		} catch (Exception e) {
			log.error("delete CronogramaLaboresLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		log.debug("updating CronogramaLaboresLabores instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("CronogramaLaboresLabores");
			}

			if (entity.getCronogramaLabores() == null) {
				throw new ZMessManager().new ForeignException("cronogramaLabores");
			}

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getCronogramaLaboresLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresLaboresId");
			}

			if ((entity.getCronogramaLaboresLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCronogramaLaboresLaboresId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresLaboresId");
			}

			if ((entity.getDuracion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDuracion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("duracion");
			}

			if ((entity.getNumeroDiasFin() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDiasFin(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDiasFin");
			}

			if ((entity.getNumeroDiasInicio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDiasInicio(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDiasInicio");
			}

			if (entity.getCronogramaLabores().getCronogramaLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId_CronogramaLabores");
			}

			if ((entity.getCronogramaLabores().getCronogramaLaboresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCronogramaLabores().getCronogramaLaboresId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresId_CronogramaLabores");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if ((entity.getLabor().getLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
			}

			cronogramaLaboresLaboresDAO.update(entity);

			log.debug("update CronogramaLaboresLabores successful");
		} catch (Exception e) {
			log.error("update CronogramaLaboresLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLabores() throws Exception {
		try {
			List<CronogramaLaboresLabores> cronogramaLaboresLabores = cronogramaLaboresLaboresDAO.findAll();

			List<CronogramaLaboresLaboresDTO> cronogramaLaboresLaboresDTO = new ArrayList<CronogramaLaboresLaboresDTO>();

			for (CronogramaLaboresLabores cronogramaLaboresLaboresTmp : cronogramaLaboresLabores) {
				CronogramaLaboresLaboresDTO cronogramaLaboresLaboresDTO2 = new CronogramaLaboresLaboresDTO();

				cronogramaLaboresLaboresDTO2
						.setCronogramaLaboresLaboresId(cronogramaLaboresLaboresTmp.getCronogramaLaboresLaboresId());
				cronogramaLaboresLaboresDTO2.setDuracion((cronogramaLaboresLaboresTmp.getDuracion() != null)
						? cronogramaLaboresLaboresTmp.getDuracion() : null);
				cronogramaLaboresLaboresDTO2.setNumeroDiasFin((cronogramaLaboresLaboresTmp.getNumeroDiasFin() != null)
						? cronogramaLaboresLaboresTmp.getNumeroDiasFin() : null);
				cronogramaLaboresLaboresDTO2
						.setNumeroDiasInicio((cronogramaLaboresLaboresTmp.getNumeroDiasInicio() != null)
								? cronogramaLaboresLaboresTmp.getNumeroDiasInicio() : null);
				cronogramaLaboresLaboresDTO2.setCronogramaLaboresId_CronogramaLabores(
						(cronogramaLaboresLaboresTmp.getCronogramaLabores().getCronogramaLaboresId() != null)
								? cronogramaLaboresLaboresTmp.getCronogramaLabores().getCronogramaLaboresId() : null);

				if (cronogramaLaboresLaboresTmp.getLabor() != null) {
					cronogramaLaboresLaboresDTO2.setLaborId_Labor(cronogramaLaboresLaboresTmp.getLabor());
				} else {
					cronogramaLaboresLaboresDTO2.setLaborId_Labor(null);
				}

				if (cronogramaLaboresLaboresTmp.getLabor() != null) {
					cronogramaLaboresLaboresDTO2.setNombreLabor(cronogramaLaboresLaboresTmp.getLabor().getNombre());
				} else {
					cronogramaLaboresLaboresDTO2.setNombreLabor(null);
				}

				cronogramaLaboresLaboresDTO.add(cronogramaLaboresLaboresDTO2);
			}

			return cronogramaLaboresLaboresDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CronogramaLaboresLabores getCronogramaLaboresLabores(Long cronogramaLaboresLaboresId) throws Exception {
		log.debug("getting CronogramaLaboresLabores instance");

		CronogramaLaboresLabores entity = null;

		try {
			entity = cronogramaLaboresLaboresDAO.findById(cronogramaLaboresLaboresId);
		} catch (Exception e) {
			log.error("get CronogramaLaboresLabores failed", e);
			throw new ZMessManager().new FindingException("CronogramaLaboresLabores");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresLabores> findPageCronogramaLaboresLabores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<CronogramaLaboresLabores> entity = null;

		try {
			entity = cronogramaLaboresLaboresDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLaboresLabores Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCronogramaLaboresLabores() throws Exception {
		Long entity = null;

		try {
			entity = cronogramaLaboresLaboresDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLaboresLabores Count");
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
	public List<CronogramaLaboresLabores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<CronogramaLaboresLabores> list = new ArrayList<CronogramaLaboresLabores>();
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
			list = cronogramaLaboresLaboresDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLaboresByCronograma(Long cronogramaLaboresId)
			throws Exception {
		try {
			List<CronogramaLaboresLabores> cronogramaLaboresLabores = cronogramaLaboresLaboresDAO
					.findByCriteria("cronogramaLabores.cronogramaLaboresId= " + cronogramaLaboresId);
			List<CronogramaLaboresLaboresDTO> cronogramaLaboresLaboresDTO = new ArrayList<CronogramaLaboresLaboresDTO>();

			for (CronogramaLaboresLabores cronogramaLaboresLaboresTmp : cronogramaLaboresLabores) {
				CronogramaLaboresLaboresDTO cronogramaLaboresLaboresDTO2 = new CronogramaLaboresLaboresDTO();

				cronogramaLaboresLaboresDTO2
						.setCronogramaLaboresLaboresId(cronogramaLaboresLaboresTmp.getCronogramaLaboresLaboresId());
				cronogramaLaboresLaboresDTO2.setDuracion((cronogramaLaboresLaboresTmp.getDuracion() != null)
						? cronogramaLaboresLaboresTmp.getDuracion() : null);
				cronogramaLaboresLaboresDTO2.setNumeroDiasFin((cronogramaLaboresLaboresTmp.getNumeroDiasFin() != null)
						? cronogramaLaboresLaboresTmp.getNumeroDiasFin() : null);
				cronogramaLaboresLaboresDTO2
						.setNumeroDiasInicio((cronogramaLaboresLaboresTmp.getNumeroDiasInicio() != null)
								? cronogramaLaboresLaboresTmp.getNumeroDiasInicio() : null);
				cronogramaLaboresLaboresDTO2.setCronogramaLaboresId_CronogramaLabores(
						(cronogramaLaboresLaboresTmp.getCronogramaLabores().getCronogramaLaboresId() != null)
								? cronogramaLaboresLaboresTmp.getCronogramaLabores().getCronogramaLaboresId() : null);

				if (cronogramaLaboresLaboresTmp.getLabor() != null) {
					cronogramaLaboresLaboresDTO2.setLaborId_Labor(cronogramaLaboresLaboresTmp.getLabor());
				} else {
					cronogramaLaboresLaboresDTO2.setLaborId_Labor(null);
				}

				if (cronogramaLaboresLaboresTmp.getLabor() != null) {
					cronogramaLaboresLaboresDTO2.setNombreLabor(cronogramaLaboresLaboresTmp.getLabor().getNombre());
				} else {
					cronogramaLaboresLaboresDTO2.setNombreLabor(null);
				}

				
				if (cronogramaLaboresLaboresTmp.getUdadMed() != null) {
					cronogramaLaboresLaboresDTO2.setNombreUdadMed(cronogramaLaboresLaboresTmp.getUdadMed().getNombre());
				} else {
					cronogramaLaboresLaboresDTO2.setNombreUdadMed(null);
				}
				
				if (cronogramaLaboresLaboresTmp.getUdadMed() != null) {
					cronogramaLaboresLaboresDTO2.setUdadMed(cronogramaLaboresLaboresTmp.getUdadMed());
				} else {
					cronogramaLaboresLaboresDTO2.setUdadMed(null);
				}
				
				
				cronogramaLaboresLaboresDTO2.setTarifaLabor((cronogramaLaboresLaboresTmp.getTarifaLabor() != null)
						? cronogramaLaboresLaboresTmp.getTarifaLabor() : null);
				
				cronogramaLaboresLaboresDTO2.setPresupuestoBaseAreaPlantas((cronogramaLaboresLaboresTmp.getPresupuestoBaseAreaPlantas() != null)
						? cronogramaLaboresLaboresTmp.getPresupuestoBaseAreaPlantas() : null);
				
				
				cronogramaLaboresLaboresDTO2.setNumeroDiasFin((cronogramaLaboresLaboresTmp.getNumeroDiasFin() != null)
						? cronogramaLaboresLaboresTmp.getNumeroDiasFin() : null);
				
				cronogramaLaboresLaboresDTO2.setEnero ((cronogramaLaboresLaboresTmp.getEnero() != null) ? cronogramaLaboresLaboresTmp.getEnero() : null);
				cronogramaLaboresLaboresDTO2.setFebrero ((cronogramaLaboresLaboresTmp.getFebrero() != null) ? cronogramaLaboresLaboresTmp.getFebrero() : null);
				cronogramaLaboresLaboresDTO2.setMarzo ((cronogramaLaboresLaboresTmp.getMarzo() != null) ? cronogramaLaboresLaboresTmp.getMarzo() : null);
				cronogramaLaboresLaboresDTO2.setAbril ((cronogramaLaboresLaboresTmp.getAbril() != null) ? cronogramaLaboresLaboresTmp.getAbril() : null);
				cronogramaLaboresLaboresDTO2.setMayo ((cronogramaLaboresLaboresTmp.getMayo() != null) ? cronogramaLaboresLaboresTmp.getMayo() : null);
				cronogramaLaboresLaboresDTO2.setJunio ((cronogramaLaboresLaboresTmp.getJunio() != null) ? cronogramaLaboresLaboresTmp.getJunio() : null);
				cronogramaLaboresLaboresDTO2.setJulio ((cronogramaLaboresLaboresTmp.getJulio() != null) ? cronogramaLaboresLaboresTmp.getJulio() : null);
				cronogramaLaboresLaboresDTO2.setAgosto ((cronogramaLaboresLaboresTmp.getAgosto() != null) ? cronogramaLaboresLaboresTmp.getAgosto() : null);
				cronogramaLaboresLaboresDTO2.setSeptiembre ((cronogramaLaboresLaboresTmp.getSeptiembre() != null) ? cronogramaLaboresLaboresTmp.getSeptiembre() : null);
				cronogramaLaboresLaboresDTO2.setOctubre ((cronogramaLaboresLaboresTmp.getOctubre() != null) ? cronogramaLaboresLaboresTmp.getOctubre() : null);
				cronogramaLaboresLaboresDTO2.setNoviembre ((cronogramaLaboresLaboresTmp.getNoviembre() != null) ? cronogramaLaboresLaboresTmp.getNoviembre() : null);
				cronogramaLaboresLaboresDTO2.setDiciembre ((cronogramaLaboresLaboresTmp.getDiciembre() != null) ? cronogramaLaboresLaboresTmp.getDiciembre() : null);
				cronogramaLaboresLaboresDTO2.setAreaEnero ((cronogramaLaboresLaboresTmp.getAreaEnero() != null) ? cronogramaLaboresLaboresTmp.getAreaEnero() : null);
				cronogramaLaboresLaboresDTO2.setAreaFebrero ((cronogramaLaboresLaboresTmp.getAreaFebrero() != null) ? cronogramaLaboresLaboresTmp.getAreaFebrero() : null);
				cronogramaLaboresLaboresDTO2.setAreaMarzo ((cronogramaLaboresLaboresTmp.getAreaMarzo() != null) ? cronogramaLaboresLaboresTmp.getAreaMarzo() : null);
				cronogramaLaboresLaboresDTO2.setAreaAbril ((cronogramaLaboresLaboresTmp.getAreaAbril() != null) ? cronogramaLaboresLaboresTmp.getAreaAbril() : null);
				cronogramaLaboresLaboresDTO2.setAreaMayo ((cronogramaLaboresLaboresTmp.getAreaMayo() != null) ? cronogramaLaboresLaboresTmp.getAreaMayo() : null);
				cronogramaLaboresLaboresDTO2.setAreaJunio ((cronogramaLaboresLaboresTmp.getAreaJunio() != null) ? cronogramaLaboresLaboresTmp.getAreaJunio() : null);
				cronogramaLaboresLaboresDTO2.setAreaJulio ((cronogramaLaboresLaboresTmp.getAreaJulio() != null) ? cronogramaLaboresLaboresTmp.getAreaJulio() : null);
				cronogramaLaboresLaboresDTO2.setAreaAgosto ((cronogramaLaboresLaboresTmp.getAreaAgosto() != null) ? cronogramaLaboresLaboresTmp.getAreaAgosto() : null);
				cronogramaLaboresLaboresDTO2.setAreaSeptiembre ((cronogramaLaboresLaboresTmp.getAreaSeptiembre() != null) ? cronogramaLaboresLaboresTmp.getAreaSeptiembre() : null);
				cronogramaLaboresLaboresDTO2.setAreaOctubre ((cronogramaLaboresLaboresTmp.getAreaOctubre() != null) ? cronogramaLaboresLaboresTmp.getAreaOctubre() : null);
				cronogramaLaboresLaboresDTO2.setAreaNoviembre ((cronogramaLaboresLaboresTmp.getAreaNoviembre() != null) ? cronogramaLaboresLaboresTmp.getAreaNoviembre() : null);
				cronogramaLaboresLaboresDTO2.setAreaDiciembre ((cronogramaLaboresLaboresTmp.getAreaDiciembre() != null) ? cronogramaLaboresLaboresTmp.getAreaDiciembre() : null);
				cronogramaLaboresLaboresDTO2.setLotesEnero ((cronogramaLaboresLaboresTmp.getLotesEnero() != null) ? cronogramaLaboresLaboresTmp.getLotesEnero() : null);
				cronogramaLaboresLaboresDTO2.setLotesFebrero ((cronogramaLaboresLaboresTmp.getLotesFebrero() != null) ? cronogramaLaboresLaboresTmp.getLotesFebrero() : null);
				cronogramaLaboresLaboresDTO2.setLotesMarzo ((cronogramaLaboresLaboresTmp.getLotesMarzo() != null) ? cronogramaLaboresLaboresTmp.getLotesMarzo() : null);
				cronogramaLaboresLaboresDTO2.setLotesAbril ((cronogramaLaboresLaboresTmp.getLotesAbril() != null) ? cronogramaLaboresLaboresTmp.getLotesAbril() : null);
				cronogramaLaboresLaboresDTO2.setLotesMayo ((cronogramaLaboresLaboresTmp.getLotesMayo() != null) ? cronogramaLaboresLaboresTmp.getLotesMayo() : null);
				cronogramaLaboresLaboresDTO2.setLotesJunio ((cronogramaLaboresLaboresTmp.getLotesJunio() != null) ? cronogramaLaboresLaboresTmp.getLotesJunio() : null);
				cronogramaLaboresLaboresDTO2.setLotesJulio ((cronogramaLaboresLaboresTmp.getLotesJulio() != null) ? cronogramaLaboresLaboresTmp.getLotesJulio() : null);
				cronogramaLaboresLaboresDTO2.setLotesAgosto ((cronogramaLaboresLaboresTmp.getLotesAgosto() != null) ? cronogramaLaboresLaboresTmp.getLotesAgosto() : null);
				cronogramaLaboresLaboresDTO2.setLotesSeptiembre ((cronogramaLaboresLaboresTmp.getLotesSeptiembre() != null) ? cronogramaLaboresLaboresTmp.getLotesSeptiembre() : null);
				cronogramaLaboresLaboresDTO2.setLotesOctubre ((cronogramaLaboresLaboresTmp.getLotesOctubre() != null) ? cronogramaLaboresLaboresTmp.getLotesOctubre() : null);
				cronogramaLaboresLaboresDTO2.setLotesNoviembre ((cronogramaLaboresLaboresTmp.getLotesNoviembre() != null) ? cronogramaLaboresLaboresTmp.getLotesNoviembre() : null);
				cronogramaLaboresLaboresDTO2.setLotesDiciembre ((cronogramaLaboresLaboresTmp.getLotesDiciembre() != null) ? cronogramaLaboresLaboresTmp.getLotesDiciembre() : null);

				
				
				cronogramaLaboresLaboresDTO.add(cronogramaLaboresLaboresDTO2);
			}

			return cronogramaLaboresLaboresDTO;
		} catch (Exception e) {
			throw e;
		}
	}
}
