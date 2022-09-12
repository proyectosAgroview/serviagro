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

import co.com.arcosoft.dataaccess.dao.ITarifaInfraestructuraDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaInfraestructura;
import co.com.arcosoft.modelo.dto.TarifaInfraestructuraDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaInfraestructuraLogic")
public class TarifaInfraestructuraLogic implements ITarifaInfraestructuraLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaInfraestructuraLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaInfraestructura entities
	 *
	 */
	@Autowired
	private ITarifaInfraestructuraDAO tarifaInfraestructuraDAO;

	/**
	 * Logic injected by Spring that manages Infraestructura entities
	 *
	 */
	@Autowired
	IInfraestructuraLogic logicInfraestructura1;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaInfraestructura> getTarifaInfraestructura() throws Exception {
		log.debug("finding all TarifaInfraestructura instances");

		List<TarifaInfraestructura> list = new ArrayList<TarifaInfraestructura>();

		try {
			list = tarifaInfraestructuraDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaInfraestructura failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaInfraestructura");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		log.debug("saving TarifaInfraestructura instance");

		try {
			if (entity.getInfraestructura() == null) {
				throw new ZMessManager().new ForeignException("infraestructura");
			}

			if (entity.getTarInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarInfraId");
			}

			if ((entity.getTarInfraId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarInfraId");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getInfraestructura().getInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("infraId_Infraestructura");
			}

			if ((entity.getInfraestructura().getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getInfraestructura().getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId_Infraestructura");
			}

			if (getTarifaInfraestructura(entity.getTarInfraId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tarifaInfraestructuraDAO.save(entity);

			log.debug("save TarifaInfraestructura successful");
		} catch (Exception e) {
			log.error("save TarifaInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		log.debug("deleting TarifaInfraestructura instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaInfraestructura");
		}

		if (entity.getTarInfraId() == null) {
			throw new ZMessManager().new EmptyFieldException("tarInfraId");
		}

		try {
			tarifaInfraestructuraDAO.delete(entity);

			log.debug("delete TarifaInfraestructura successful");
		} catch (Exception e) {
			log.error("delete TarifaInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		log.debug("updating TarifaInfraestructura instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaInfraestructura");
			}

			if (entity.getInfraestructura() == null) {
				throw new ZMessManager().new ForeignException("infraestructura");
			}

			if (entity.getTarInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarInfraId");
			}

			if ((entity.getTarInfraId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarInfraId");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			/*
			 * if (entity.getInfraestructura().getInfraId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "infraId_Infraestructura"); }
			 * 
			 * if ((entity.getInfraestructura().getInfraId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getInfraestructura().getInfraId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "infraId_Infraestructura"); }
			 */

			tarifaInfraestructuraDAO.update(entity);

			log.debug("update TarifaInfraestructura successful");
		} catch (Exception e) {
			log.error("update TarifaInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaInfraestructuraDTO> getDataTarifaInfraestructura() throws Exception {
		try {
			List<TarifaInfraestructura> tarifaInfraestructura = tarifaInfraestructuraDAO.findAll();

			List<TarifaInfraestructuraDTO> tarifaInfraestructuraDTO = new ArrayList<TarifaInfraestructuraDTO>();

			for (TarifaInfraestructura tarifaInfraestructuraTmp : tarifaInfraestructura) {
				TarifaInfraestructuraDTO tarifaInfraestructuraDTO2 = new TarifaInfraestructuraDTO();

				tarifaInfraestructuraDTO2.setTarInfraId(tarifaInfraestructuraTmp.getTarInfraId());
				tarifaInfraestructuraDTO2.setFechaCreacion(tarifaInfraestructuraTmp.getFechaCreacion());
				tarifaInfraestructuraDTO2.setFechaFinal(tarifaInfraestructuraTmp.getFechaFinal());
				tarifaInfraestructuraDTO2.setFechaInicial(tarifaInfraestructuraTmp.getFechaInicial());
				tarifaInfraestructuraDTO2.setFechaModificacion(tarifaInfraestructuraTmp.getFechaModificacion());
				tarifaInfraestructuraDTO2.setValor(
						(tarifaInfraestructuraTmp.getValor() != null) ? tarifaInfraestructuraTmp.getValor() : null);

				if (tarifaInfraestructuraTmp.getInfraestructura() != null) {
					tarifaInfraestructuraDTO2
							.setInfraId_Infraestructura(tarifaInfraestructuraTmp.getInfraestructura().getInfraId());
				} else {
					tarifaInfraestructuraDTO2.setInfraId_Infraestructura(null);
				}

				tarifaInfraestructuraDTO.add(tarifaInfraestructuraDTO2);
			}

			return tarifaInfraestructuraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaInfraestructura getTarifaInfraestructura(Long tarInfraId) throws Exception {
		log.debug("getting TarifaInfraestructura instance");

		TarifaInfraestructura entity = null;

		try {
			entity = tarifaInfraestructuraDAO.findById(tarInfraId);
		} catch (Exception e) {
			log.error("get TarifaInfraestructura failed", e);
			throw new ZMessManager().new FindingException("TarifaInfraestructura");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaInfraestructura> findPageTarifaInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TarifaInfraestructura> entity = null;

		try {
			entity = tarifaInfraestructuraDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaInfraestructura Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaInfraestructura() throws Exception {
		Long entity = null;

		try {
			entity = tarifaInfraestructuraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaInfraestructura Count");
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
	public List<TarifaInfraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaInfraestructura> list = new ArrayList<TarifaInfraestructura>();
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
			list = tarifaInfraestructuraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaInfraestructuraDTO> getDataInfraestructuraByTarifaId(Long id) throws Exception {
		try {
			List<TarifaInfraestructura> tarifaInfraestructura = tarifaInfraestructuraDAO
					.findByCriteria("infraestructura.infraId= " + id);

			List<TarifaInfraestructuraDTO> tarifaInfraestructuraDTO = new ArrayList<TarifaInfraestructuraDTO>();

			for (TarifaInfraestructura tarifaInfraestructuraTmp : tarifaInfraestructura) {
				TarifaInfraestructuraDTO tarifaInfraestructuraDTO2 = new TarifaInfraestructuraDTO();

				tarifaInfraestructuraDTO2.setTarInfraId(tarifaInfraestructuraTmp.getTarInfraId());
				tarifaInfraestructuraDTO2.setFechaCreacion(tarifaInfraestructuraTmp.getFechaCreacion());
				tarifaInfraestructuraDTO2.setFechaFinal(tarifaInfraestructuraTmp.getFechaFinal());
				tarifaInfraestructuraDTO2.setFechaInicial(tarifaInfraestructuraTmp.getFechaInicial());
				tarifaInfraestructuraDTO2.setFechaModificacion(tarifaInfraestructuraTmp.getFechaModificacion());
				tarifaInfraestructuraDTO2.setValor(
						(tarifaInfraestructuraTmp.getValor() != null) ? tarifaInfraestructuraTmp.getValor() : null);

				if (tarifaInfraestructuraTmp.getInfraestructura() != null) {
					tarifaInfraestructuraDTO2
							.setInfraId_Infraestructura(tarifaInfraestructuraTmp.getInfraestructura().getInfraId());
				} else {
					tarifaInfraestructuraDTO2.setInfraId_Infraestructura(null);
				}

				tarifaInfraestructuraDTO.add(tarifaInfraestructuraDTO2);
			}

			return tarifaInfraestructuraDTO;
		} catch (Exception e) {
			throw e;
		}
	}
}
