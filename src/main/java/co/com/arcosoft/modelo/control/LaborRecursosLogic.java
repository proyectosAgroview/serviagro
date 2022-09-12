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

import co.com.arcosoft.dataaccess.dao.ILaborRecursosDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.LaborRecursos;
import co.com.arcosoft.modelo.dto.LaborRecursosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("LaborRecursosLogic")
public class LaborRecursosLogic implements ILaborRecursosLogic {
	private static final Logger log = LoggerFactory.getLogger(LaborRecursosLogic.class);

	/**
	 * DAO injected by Spring that manages LaborRecursos entities
	 *
	 */
	@Autowired
	private ILaborRecursosDAO laborRecursosDAO;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor1;

	/**
	 * Logic injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	ITipoRecursoLogic logicTipoRecurso2;

	@Override
	@Transactional(readOnly = true)
	public List<LaborRecursos> getLaborRecursos() throws Exception {
		log.debug("finding all LaborRecursos instances");

		List<LaborRecursos> list = new ArrayList<LaborRecursos>();

		try {
			list = laborRecursosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all LaborRecursos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "LaborRecursos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveLaborRecursos(LaborRecursos entity) throws Exception {
		log.debug("saving LaborRecursos instance");

		try {
			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if ((entity.getRendimientoRecurso() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRendimientoRecurso(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("rendimientoRecurso");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if (getLaborRecursos(entity.getLaborRecursosId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			laborRecursosDAO.save(entity);

			log.debug("save LaborRecursos successful");
		} catch (Exception e) {
			log.error("save LaborRecursos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteLaborRecursos(LaborRecursos entity) throws Exception {
		log.debug("deleting LaborRecursos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("LaborRecursos");
		}

		if (entity.getLaborRecursosId() == null) {
			throw new ZMessManager().new EmptyFieldException("laborRecursosId");
		}

		try {
			laborRecursosDAO.delete(entity);

			log.debug("delete LaborRecursos successful");
		} catch (Exception e) {
			log.error("delete LaborRecursos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateLaborRecursos(LaborRecursos entity) throws Exception {
		log.debug("updating LaborRecursos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("LaborRecursos");
			}

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if ((entity.getRendimientoRecurso() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRendimientoRecurso(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("rendimientoRecurso");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			laborRecursosDAO.update(entity);

			log.debug("update LaborRecursos successful");
		} catch (Exception e) {
			log.error("update LaborRecursos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<LaborRecursosDTO> getDataLaborRecursos() throws Exception {
		try {
			List<LaborRecursos> laborRecursos = laborRecursosDAO.findAll();

			List<LaborRecursosDTO> laborRecursosDTO = new ArrayList<LaborRecursosDTO>();

			for (LaborRecursos laborRecursosTmp : laborRecursos) {
				LaborRecursosDTO laborRecursosDTO2 = new LaborRecursosDTO();

				laborRecursosDTO2.setLaborRecursosId(laborRecursosTmp.getLaborRecursosId());
				laborRecursosDTO2.setRecursoId(
						(laborRecursosTmp.getRecursoId() != null) ? laborRecursosTmp.getRecursoId() : null);
				laborRecursosDTO2.setRendimientoRecurso((laborRecursosTmp.getRendimientoRecurso() != null)
						? laborRecursosTmp.getRendimientoRecurso() : null);

				if (laborRecursosTmp.getLabor() != null) {
					laborRecursosDTO2.setLaborId_Labor(laborRecursosTmp.getLabor().getLaborId());
				} else {
					laborRecursosDTO2.setLaborId_Labor(null);
				}

				if (laborRecursosTmp.getUdadMedId() != null) {
					laborRecursosDTO2.setUdadMedId(laborRecursosTmp.getUdadMedId());
				} else {
					laborRecursosDTO2.setUdadMedId(null);
				}

				laborRecursosDTO2.setTpRecursoId_TipoRecurso(
						(laborRecursosTmp.getTipoRecurso() != null) ? laborRecursosTmp.getTipoRecurso() : null);

				if (laborRecursosTmp.getUdadMedId() != null) {
					laborRecursosDTO2.setNombreUm(laborRecursosTmp.getUdadMedId().getNombre());
				} else {
					laborRecursosDTO2.setNombreUm(null);
				}

				if (laborRecursosTmp.getTipoRecurso() != null) {
					laborRecursosDTO2.setNombreTipoRecurso(laborRecursosTmp.getTipoRecurso().getNombre());
				} else {
					laborRecursosDTO2.setNombreTipoRecurso(null);
				}

				laborRecursosDTO.add(laborRecursosDTO2);
			}

			return laborRecursosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public LaborRecursos getLaborRecursos(Long laborRecursosId) throws Exception {
		log.debug("getting LaborRecursos instance");

		LaborRecursos entity = null;

		try {
			entity = laborRecursosDAO.findById(laborRecursosId);
		} catch (Exception e) {
			log.error("get LaborRecursos failed", e);
			throw new ZMessManager().new FindingException("LaborRecursos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LaborRecursos> findPageLaborRecursos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<LaborRecursos> entity = null;

		try {
			entity = laborRecursosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("LaborRecursos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberLaborRecursos() throws Exception {
		Long entity = null;

		try {
			entity = laborRecursosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("LaborRecursos Count");
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
	public List<LaborRecursos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<LaborRecursos> list = new ArrayList<LaborRecursos>();
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
			list = laborRecursosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LaborRecursosDTO> getDataLaborRecursosByLabor(Long laborRecursosId) throws Exception {
		try {

			List<LaborRecursos> laborRecursos = laborRecursosDAO.findByCriteria("labor.laborId= " + laborRecursosId);

			List<LaborRecursosDTO> laborRecursosDTO = new ArrayList<LaborRecursosDTO>();

			for (LaborRecursos laborRecursosTmp : laborRecursos) {
				LaborRecursosDTO laborRecursosDTO2 = new LaborRecursosDTO();

				laborRecursosDTO2.setLaborRecursosId(laborRecursosTmp.getLaborRecursosId());
				laborRecursosDTO2.setRecursoId(
						(laborRecursosTmp.getRecursoId() != null) ? laborRecursosTmp.getRecursoId() : null);
				laborRecursosDTO2.setRendimientoRecurso((laborRecursosTmp.getRendimientoRecurso() != null)
						? laborRecursosTmp.getRendimientoRecurso() : null);

				if (laborRecursosTmp.getLabor() != null) {
					laborRecursosDTO2.setLaborId_Labor(laborRecursosTmp.getLabor().getLaborId());
				} else {
					laborRecursosDTO2.setLaborId_Labor(null);
				}

				if (laborRecursosTmp.getUdadMedId() != null) {
					laborRecursosDTO2.setUdadMedId(laborRecursosTmp.getUdadMedId());
				} else {
					laborRecursosDTO2.setUdadMedId(null);
				}

				laborRecursosDTO2.setTpRecursoId_TipoRecurso(
						(laborRecursosTmp.getTipoRecurso() != null) ? laborRecursosTmp.getTipoRecurso() : null);

				if (laborRecursosTmp.getUdadMedId() != null) {
					laborRecursosDTO2.setNombreUm(laborRecursosTmp.getUdadMedId().getNombre());
				} else {
					laborRecursosDTO2.setNombreUm(null);
				}

				if (laborRecursosTmp.getTipoRecurso() != null) {
					laborRecursosDTO2.setNombreTipoRecurso(laborRecursosTmp.getTipoRecurso().getNombre());
				} else {
					laborRecursosDTO2.setNombreTipoRecurso(null);
				}

				if (laborRecursosTmp.getRecursoId() != null) {
					laborRecursosDTO2.setNombreRecurso(laborRecursosTmp.getNombreRecurso());
				} else {
					laborRecursosDTO2.setNombreRecurso(null);
				}

				laborRecursosDTO.add(laborRecursosDTO2);
			}

			return laborRecursosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
