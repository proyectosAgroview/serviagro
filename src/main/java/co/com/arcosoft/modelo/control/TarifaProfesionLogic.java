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

import co.com.arcosoft.dataaccess.dao.ITarifaProfesionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaProfesion;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaProfesionLogic")
public class TarifaProfesionLogic implements ITarifaProfesionLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaProfesionLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaProfesion entities
	 *
	 */
	@Autowired
	private ITarifaProfesionDAO tarifaProfesionDAO;

	/**
	 * Logic injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	IConceptoNominaLogic logicConceptoNomina1;

	/**
	 * Logic injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	IProfesionLogic logicProfesion2;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed3;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaProfesion> getTarifaProfesion() throws Exception {
		log.debug("finding all TarifaProfesion instances");

		List<TarifaProfesion> list = new ArrayList<TarifaProfesion>();

		try {
			list = tarifaProfesionDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaProfesion failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaProfesion");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaProfesion(TarifaProfesion entity) throws Exception {
		log.debug("saving TarifaProfesion instance");

		try {
			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new ForeignException("conceptoNomina");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getContratistaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratistaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaProfId");
			}

			if ((entity.getTarifaProfId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaProfId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaProfId");
			}

			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId_ConceptoNomina");
			}

			if ((entity.getConceptoNomina() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConceptoNomina(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ceptoNominaId_ConceptoNomina");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if ((entity.getProfesion().getProfId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProfesion().getProfId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("profId_Profesion");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (getTarifaProfesion(entity.getTarifaProfId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tarifaProfesionDAO.save(entity);

			log.debug("save TarifaProfesion successful");
		} catch (Exception e) {
			log.error("save TarifaProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaProfesion(TarifaProfesion entity) throws Exception {
		log.debug("deleting TarifaProfesion instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaProfesion");
		}

		if (entity.getTarifaProfId() == null) {
			throw new ZMessManager().new EmptyFieldException("tarifaProfId");
		}

		try {
			tarifaProfesionDAO.delete(entity);

			log.debug("delete TarifaProfesion successful");
		} catch (Exception e) {
			log.error("delete TarifaProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaProfesion(TarifaProfesion entity) throws Exception {
		log.debug("updating TarifaProfesion instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaProfesion");
			}

			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new ForeignException("conceptoNomina");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaProfId");
			}

			if ((entity.getTarifaProfId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaProfId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaProfId");
			}

			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId_ConceptoNomina");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if ((entity.getProfesion().getProfId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProfesion().getProfId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("profId_Profesion");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			tarifaProfesionDAO.update(entity);

			log.debug("update TarifaProfesion successful");
		} catch (Exception e) {
			log.error("update TarifaProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaProfesionDTO> getDataTarifaProfesion() throws Exception {
		try {
			List<TarifaProfesion> tarifaProfesion = tarifaProfesionDAO.findAll();

			List<TarifaProfesionDTO> tarifaProfesionDTO = new ArrayList<TarifaProfesionDTO>();

			for (TarifaProfesion tarifaProfesionTmp : tarifaProfesion) {
				TarifaProfesionDTO tarifaProfesionDTO2 = new TarifaProfesionDTO();

				tarifaProfesionDTO2.setTarifaProfId(tarifaProfesionTmp.getTarifaProfId());
				tarifaProfesionDTO2.setCompania(
						(tarifaProfesionTmp.getCompania() != null) ? tarifaProfesionTmp.getCompania() : null);
				tarifaProfesionDTO2.setContratistaId(
						(tarifaProfesionTmp.getContratistaId() != null) ? tarifaProfesionTmp.getContratistaId() : null);
				tarifaProfesionDTO2.setFechaCreacion(tarifaProfesionTmp.getFechaCreacion());
				tarifaProfesionDTO2.setFechaFinal(tarifaProfesionTmp.getFechaFinal());
				tarifaProfesionDTO2.setFechaInicial(tarifaProfesionTmp.getFechaInicial());
				tarifaProfesionDTO2.setFechaModificacion(tarifaProfesionTmp.getFechaModificacion());
				tarifaProfesionDTO2
						.setTarifa((tarifaProfesionTmp.getTarifa() != null) ? tarifaProfesionTmp.getTarifa() : null);
				tarifaProfesionDTO2.setCeptoNominaId_ConceptoNomina((tarifaProfesionTmp.getConceptoNomina() != null)
						? tarifaProfesionTmp.getConceptoNomina() : null);

				if (tarifaProfesionTmp.getProfesion() != null) {
					tarifaProfesionDTO2.setProfId_Profesion(tarifaProfesionTmp.getProfesion());
				} else {
					tarifaProfesionDTO2.setProfId_Profesion(null);
				}

				tarifaProfesionDTO2.setUdadMedId_UdadMed(
						(tarifaProfesionTmp.getUdadMed() != null) ? tarifaProfesionTmp.getUdadMed() : null);

				if (tarifaProfesionTmp.getContratistaId() != null) {
					tarifaProfesionDTO2.setCodContratista(tarifaProfesionTmp.getContratistaId().getCodigo());
				} else {
					tarifaProfesionDTO2.setCodContratista(null);
				}

				if (tarifaProfesionTmp.getConceptoNomina() != null) {
					tarifaProfesionDTO2.setCodConceptoNomina(tarifaProfesionTmp.getConceptoNomina().getCodigo());
				} else {
					tarifaProfesionDTO2.setCodConceptoNomina(null);
				}

				if (tarifaProfesionTmp.getUdadMed() != null) {
					tarifaProfesionDTO2.setCodUdadMed(tarifaProfesionTmp.getUdadMed().getCodigo());
				} else {
					tarifaProfesionDTO2.setCodUdadMed(null);
				}

				tarifaProfesionDTO.add(tarifaProfesionDTO2);
			}

			return tarifaProfesionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaProfesion getTarifaProfesion(Long tarifaProfId) throws Exception {
		log.debug("getting TarifaProfesion instance");

		TarifaProfesion entity = null;

		try {
			entity = tarifaProfesionDAO.findById(tarifaProfId);
		} catch (Exception e) {
			log.error("get TarifaProfesion failed", e);
			throw new ZMessManager().new FindingException("TarifaProfesion");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaProfesion> findPageTarifaProfesion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TarifaProfesion> entity = null;

		try {
			entity = tarifaProfesionDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaProfesion Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaProfesion() throws Exception {
		Long entity = null;

		try {
			entity = tarifaProfesionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaProfesion Count");
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
	public List<TarifaProfesion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaProfesion> list = new ArrayList<TarifaProfesion>();
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
			list = tarifaProfesionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaProfesionDTO> getDataProfesionByTarifaProfesionId(Long profesionId) throws Exception {
		try {
			List<TarifaProfesion> TarifaProfesion = tarifaProfesionDAO
					.findByCriteria("profesion.profId= " + profesionId);

			List<TarifaProfesionDTO> TarifaProfesionDTO = new ArrayList<TarifaProfesionDTO>();

			for (TarifaProfesion tarifaProfesionTmp : TarifaProfesion) {
				TarifaProfesionDTO TarifaProfesionDTO2 = new TarifaProfesionDTO();

				TarifaProfesionDTO2.setTarifaProfId(tarifaProfesionTmp.getTarifaProfId());
				TarifaProfesionDTO2.setCeptoNominaId_ConceptoNomina(tarifaProfesionTmp.getConceptoNomina());
				TarifaProfesionDTO2.setCompania(tarifaProfesionTmp.getCompania());
				TarifaProfesionDTO2.setContratistaId(tarifaProfesionTmp.getContratistaId());
				TarifaProfesionDTO2.setFechaCreacion(tarifaProfesionTmp.getFechaCreacion());
				TarifaProfesionDTO2.setFechaModificacion(tarifaProfesionTmp.getFechaModificacion());
				TarifaProfesionDTO2.setFechaInicial(tarifaProfesionTmp.getFechaInicial());
				TarifaProfesionDTO2.setFechaFinal(tarifaProfesionTmp.getFechaFinal());
				TarifaProfesionDTO2.setUdadMedId_UdadMed(tarifaProfesionTmp.getUdadMed());
				TarifaProfesionDTO2.setTarifa(tarifaProfesionTmp.getTarifa());

				if (tarifaProfesionTmp.getProfesion() != null) {
					TarifaProfesionDTO2.setProfId_Profesion(tarifaProfesionTmp.getProfesion());
				} else {
					TarifaProfesionDTO2.setProfId_Profesion(null);
				}
				if (tarifaProfesionTmp.getContratistaId() != null) {
					TarifaProfesionDTO2.setCodContratista(tarifaProfesionTmp.getContratistaId().getCodigo());
				} else {
					TarifaProfesionDTO2.setCodContratista(null);
				}

				if (tarifaProfesionTmp.getConceptoNomina() != null) {
					TarifaProfesionDTO2.setCodConceptoNomina(tarifaProfesionTmp.getConceptoNomina().getCodigo());
				} else {
					TarifaProfesionDTO2.setCodConceptoNomina(null);
				}

				if (tarifaProfesionTmp.getUdadMed() != null) {
					TarifaProfesionDTO2.setCodUdadMed(tarifaProfesionTmp.getUdadMed().getCodigo());
				} else {
					TarifaProfesionDTO2.setCodUdadMed(null);
				}

				TarifaProfesionDTO.add(TarifaProfesionDTO2);
			}

			return TarifaProfesionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
