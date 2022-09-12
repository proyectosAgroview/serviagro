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

import co.com.arcosoft.dataaccess.dao.ITarifaLaborRendimientoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaLaborRendimiento;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaLaborRendimientoLogic")
public class TarifaLaborRendimientoLogic implements ITarifaLaborRendimientoLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaLaborRendimientoLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaLaborRendimiento entities
	 *
	 */
	@Autowired
	private ITarifaLaborRendimientoDAO tarifaLaborRendimientoDAO;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor1;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaLaborRendimiento> getTarifaLaborRendimiento() throws Exception {
		log.debug("finding all TarifaLaborRendimiento instances");

		List<TarifaLaborRendimiento> list = new ArrayList<TarifaLaborRendimiento>();

		try {
			list = tarifaLaborRendimientoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaLaborRendimiento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaLaborRendimiento");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		log.debug("saving TarifaLaborRendimiento instance");

		try {
			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			tarifaLaborRendimientoDAO.save(entity);

			log.debug("save TarifaLaborRendimiento successful");
		} catch (Exception e) {
			log.error("save TarifaLaborRendimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		log.debug("deleting TarifaLaborRendimiento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaLaborRendimiento");
		}

		if (entity.getTarifaLaborId() == null) {
			throw new ZMessManager().new EmptyFieldException("tarifaLaborId");
		}

		try {
			tarifaLaborRendimientoDAO.delete(entity);

			log.debug("delete TarifaLaborRendimiento successful");
		} catch (Exception e) {
			log.error("delete TarifaLaborRendimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		log.debug("updating TarifaLaborRendimiento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaLaborRendimiento");
			}


			tarifaLaborRendimientoDAO.update(entity);

			log.debug("update TarifaLaborRendimiento successful");
		} catch (Exception e) {
			log.error("update TarifaLaborRendimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaLaborRendimientoDTO> getDataTarifaLaborRendimiento() throws Exception {
		try {
			List<TarifaLaborRendimiento> tarifaLaborRendimiento = tarifaLaborRendimientoDAO.findAll();

			List<TarifaLaborRendimientoDTO> tarifaLaborRendimientoDTO = new ArrayList<TarifaLaborRendimientoDTO>();

			for (TarifaLaborRendimiento tarifaLaborRendimientoTmp : tarifaLaborRendimiento) {
				TarifaLaborRendimientoDTO tarifaLaborRendimientoDTO2 = new TarifaLaborRendimientoDTO();

				tarifaLaborRendimientoDTO2.setTarifaLaborId(tarifaLaborRendimientoTmp.getTarifaLaborId());
				tarifaLaborRendimientoDTO2.setCompania((tarifaLaborRendimientoTmp.getCompania() != null)
						? tarifaLaborRendimientoTmp.getCompania() : null);
				tarifaLaborRendimientoDTO2.setContratistaId((tarifaLaborRendimientoTmp.getContratistaId() != null)
						? tarifaLaborRendimientoTmp.getContratistaId() : null);
				tarifaLaborRendimientoDTO2.setFechaCreacion(tarifaLaborRendimientoTmp.getFechaCreacion());
				tarifaLaborRendimientoDTO2.setFechaFinal(tarifaLaborRendimientoTmp.getFechaFinal());
				tarifaLaborRendimientoDTO2.setFechaInicial(tarifaLaborRendimientoTmp.getFechaInicial());
				tarifaLaborRendimientoDTO2.setFechaModificacion(tarifaLaborRendimientoTmp.getFechaModificacion());
				tarifaLaborRendimientoDTO2.setNivel2Id((tarifaLaborRendimientoTmp.getNivel2Id() != null)
						? tarifaLaborRendimientoTmp.getNivel2Id() : null);
				tarifaLaborRendimientoDTO2.setRendimiento((tarifaLaborRendimientoTmp.getRendimiento() != null)
						? tarifaLaborRendimientoTmp.getRendimiento() : null);
				tarifaLaborRendimientoDTO2.setBonificacion((tarifaLaborRendimientoTmp.getBonificacion() != null)
						? tarifaLaborRendimientoTmp.getBonificacion() : null);

				tarifaLaborRendimientoDTO2.setTarifa(
						(tarifaLaborRendimientoTmp.getTarifa() != null) ? tarifaLaborRendimientoTmp.getTarifa() : null);
				tarifaLaborRendimientoDTO2.setUdadMedId((tarifaLaborRendimientoTmp.getUdadMedId() != null)
						? tarifaLaborRendimientoTmp.getUdadMedId() : null);

				if (tarifaLaborRendimientoTmp.getLabor() != null) {
					tarifaLaborRendimientoDTO2.setLaborId_Labor(tarifaLaborRendimientoTmp.getLabor().getLaborId());
				} else {
					tarifaLaborRendimientoDTO2.setLaborId_Labor(null);
				}

				if (tarifaLaborRendimientoTmp.getNivel2Id() != null) {
					tarifaLaborRendimientoDTO2.setCodNivel2(tarifaLaborRendimientoTmp.getNivel2Id().getCodigo());
				} else {
					tarifaLaborRendimientoDTO2.setCodNivel2(null);
				}

				if (tarifaLaborRendimientoTmp.getUdadMedId() != null) {
					tarifaLaborRendimientoDTO2.setCodUdadMed(tarifaLaborRendimientoTmp.getUdadMedId().getCodigo());
				} else {
					tarifaLaborRendimientoDTO2.setCodUdadMed(null);
				}

				if (tarifaLaborRendimientoTmp.getContratistaId() != null) {
					tarifaLaborRendimientoDTO2
							.setCodContratista(tarifaLaborRendimientoTmp.getContratistaId().getCodigo());
				} else {
					tarifaLaborRendimientoDTO2.setCodContratista(null);
				}

				tarifaLaborRendimientoDTO.add(tarifaLaborRendimientoDTO2);
			}

			return tarifaLaborRendimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaLaborRendimiento getTarifaLaborRendimiento(Long tarifaLaborId) throws Exception {
		log.debug("getting TarifaLaborRendimiento instance");

		TarifaLaborRendimiento entity = null;

		try {
			entity = tarifaLaborRendimientoDAO.findById(tarifaLaborId);
		} catch (Exception e) {
			log.error("get TarifaLaborRendimiento failed", e);
			throw new ZMessManager().new FindingException("TarifaLaborRendimiento");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaLaborRendimiento> findPageTarifaLaborRendimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TarifaLaborRendimiento> entity = null;

		try {
			entity = tarifaLaborRendimientoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaLaborRendimiento Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaLaborRendimiento() throws Exception {
		Long entity = null;

		try {
			entity = tarifaLaborRendimientoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaLaborRendimiento Count");
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
	public List<TarifaLaborRendimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaLaborRendimiento> list = new ArrayList<TarifaLaborRendimiento>();
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
			list = tarifaLaborRendimientoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaLaborRendimientoDTO> getDataRendimientoByTarifaRendimientoId(Long laborId) throws Exception {
		try {
			List<TarifaLaborRendimiento> TarifaRendimiento = tarifaLaborRendimientoDAO
					.findByCriteria("labor.laborId= " + laborId);

			List<TarifaLaborRendimientoDTO> TarifaLaborRendimientoDTO = new ArrayList<TarifaLaborRendimientoDTO>();

			for (TarifaLaborRendimiento tarifaLaborRendimientoTmp : TarifaRendimiento) {
				TarifaLaborRendimientoDTO TarifaLaborRendimientoDTO2 = new TarifaLaborRendimientoDTO();

				TarifaLaborRendimientoDTO2.setTarifaLaborId(tarifaLaborRendimientoTmp.getTarifaLaborId());
				TarifaLaborRendimientoDTO2.setCompania(tarifaLaborRendimientoTmp.getCompania());
				TarifaLaborRendimientoDTO2.setContratistaId(tarifaLaborRendimientoTmp.getContratistaId());
				TarifaLaborRendimientoDTO2.setNivel2Id(tarifaLaborRendimientoTmp.getNivel2Id());
				TarifaLaborRendimientoDTO2.setRendimiento(tarifaLaborRendimientoTmp.getRendimiento());
				TarifaLaborRendimientoDTO2.setBonificacion(tarifaLaborRendimientoTmp.getBonificacion());
				TarifaLaborRendimientoDTO2.setFechaCreacion(tarifaLaborRendimientoTmp.getFechaCreacion());
				TarifaLaborRendimientoDTO2.setFechaModificacion(tarifaLaborRendimientoTmp.getFechaModificacion());
				TarifaLaborRendimientoDTO2.setFechaInicial(tarifaLaborRendimientoTmp.getFechaInicial());
				TarifaLaborRendimientoDTO2.setFechaFinal(tarifaLaborRendimientoTmp.getFechaFinal());
				TarifaLaborRendimientoDTO2.setUdadMedId(tarifaLaborRendimientoTmp.getUdadMedId());
				TarifaLaborRendimientoDTO2.setTarifa(tarifaLaborRendimientoTmp.getTarifa());
				TarifaLaborRendimientoDTO2.setRendimientoMax(tarifaLaborRendimientoTmp.getRendimientoMax());

				if (tarifaLaborRendimientoTmp.getLabor() != null) {
					TarifaLaborRendimientoDTO2.setLaborId_Labor(tarifaLaborRendimientoTmp.getLabor().getLaborId());
				} else {
					TarifaLaborRendimientoDTO2.setLaborId_Labor(null);
				}

				if (tarifaLaborRendimientoTmp.getNivel2Id() != null) {
					TarifaLaborRendimientoDTO2.setCodNivel2(tarifaLaborRendimientoTmp.getNivel2Id().getCodigo());
				} else {
					TarifaLaborRendimientoDTO2.setCodNivel2(null);
				}

				if (tarifaLaborRendimientoTmp.getUdadMedId() != null) {
					TarifaLaborRendimientoDTO2.setCodUdadMed(tarifaLaborRendimientoTmp.getUdadMedId().getNombre());
				} else {
					TarifaLaborRendimientoDTO2.setCodUdadMed(null);
				}

				if (tarifaLaborRendimientoTmp.getContratistaId() != null) {
					TarifaLaborRendimientoDTO2
							.setCodContratista(tarifaLaborRendimientoTmp.getContratistaId().getCodigo());
				} else {
					TarifaLaborRendimientoDTO2.setCodContratista(null);
				}

				TarifaLaborRendimientoDTO.add(TarifaLaborRendimientoDTO2);
			}

			return TarifaLaborRendimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
