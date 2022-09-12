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

import co.com.arcosoft.dataaccess.dao.ITarifaOtrosDevengosDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaOtrosDevengosLogic")
public class TarifaOtrosDevengosLogic implements ITarifaOtrosDevengosLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaOtrosDevengosLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaOtrosDevengos entities
	 *
	 */
	@Autowired
	private ITarifaOtrosDevengosDAO tarifaOtrosDevengosDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaOtrosDevengos> getTarifaOtrosDevengos() throws Exception {
		log.debug("finding all TarifaOtrosDevengos instances");

		List<TarifaOtrosDevengos> list = new ArrayList<TarifaOtrosDevengos>();

		try {
			list = tarifaOtrosDevengosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaOtrosDevengos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaOtrosDevengos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		log.debug("saving TarifaOtrosDevengos instance");

		try {
			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConceptoNominaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConceptoNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conceptoNominaId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId");
			}

			if ((entity.getValorDeduccion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorDeduccion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorDeduccion");
			}
			/*
			 * if (entity.getOdevengosId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("odevengosId"); }
			 * 
			 * if ((entity.getOdevengosId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOdevengosId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "odevengosId"); }
			 * 
			 * if (getTarifaOtrosDevengos(entity.getOdevengosId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			tarifaOtrosDevengosDAO.save(entity);

			log.debug("save TarifaOtrosDevengos successful");
		} catch (Exception e) {
			log.error("save TarifaOtrosDevengos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		log.debug("deleting TarifaOtrosDevengos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaOtrosDevengos");
		}

		if (entity.getOdevengosId() == null) {
			throw new ZMessManager().new EmptyFieldException("odevengosId");
		}

		try {
			tarifaOtrosDevengosDAO.delete(entity);

			log.debug("delete TarifaOtrosDevengos successful");
		} catch (Exception e) {
			log.error("delete TarifaOtrosDevengos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		log.debug("updating TarifaOtrosDevengos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaOtrosDevengos");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if (entity.getOdevengosId() == null) {
				throw new ZMessManager().new EmptyFieldException("odevengosId");
			}

			if ((entity.getOdevengosId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getOdevengosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("odevengosId");
			}

			if ((entity.getValorDeduccion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorDeduccion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorDeduccion");
			}

			tarifaOtrosDevengosDAO.update(entity);

			log.debug("update TarifaOtrosDevengos successful");
		} catch (Exception e) {
			log.error("update TarifaOtrosDevengos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengos() throws Exception {
		try {
			List<TarifaOtrosDevengos> tarifaOtrosDevengos = tarifaOtrosDevengosDAO.findAll();

			List<TarifaOtrosDevengosDTO> tarifaOtrosDevengosDTO = new ArrayList<TarifaOtrosDevengosDTO>();

			for (TarifaOtrosDevengos tarifaOtrosDevengosTmp : tarifaOtrosDevengos) {
				TarifaOtrosDevengosDTO tarifaOtrosDevengosDTO2 = new TarifaOtrosDevengosDTO();

				tarifaOtrosDevengosDTO2.setOdevengosId(tarifaOtrosDevengosTmp.getOdevengosId());
				tarifaOtrosDevengosDTO2.setCompania(
						(tarifaOtrosDevengosTmp.getCompania() != null) ? tarifaOtrosDevengosTmp.getCompania() : null);

				tarifaOtrosDevengosDTO2.setEstado(
						(tarifaOtrosDevengosTmp.getEstado() != null) ? tarifaOtrosDevengosTmp.getEstado() : null);
				tarifaOtrosDevengosDTO2.setFechaCreacion(tarifaOtrosDevengosTmp.getFechaCreacion());
				tarifaOtrosDevengosDTO2.setFechaFinal(tarifaOtrosDevengosTmp.getFechaFinal());
				tarifaOtrosDevengosDTO2.setFechaInicial(tarifaOtrosDevengosTmp.getFechaInicial());
				tarifaOtrosDevengosDTO2.setFechaModificacion(tarifaOtrosDevengosTmp.getFechaModificacion());

				tarifaOtrosDevengosDTO2.setValorDeduccion((tarifaOtrosDevengosTmp.getValorDeduccion() != null)
						? tarifaOtrosDevengosTmp.getValorDeduccion() : null);

				if (tarifaOtrosDevengosTmp.getTrabId() != null) {
					tarifaOtrosDevengosDTO2.setTrabId(tarifaOtrosDevengosTmp.getTrabId());
				} else {
					tarifaOtrosDevengosDTO2.setTrabId(null);
				}

				if (tarifaOtrosDevengosTmp.getConceptoNominaId() != null) {
					tarifaOtrosDevengosDTO2.setConceptoNominaId(tarifaOtrosDevengosTmp.getConceptoNominaId());
				} else {
					tarifaOtrosDevengosDTO2.setConceptoNominaId(null);
				}

				if (tarifaOtrosDevengosTmp.getConceptoNominaId() != null) {
					tarifaOtrosDevengosDTO2
							.setCodConceptoNomina(tarifaOtrosDevengosTmp.getConceptoNominaId().getCodigo());
				} else {
					tarifaOtrosDevengosDTO2.setCodConceptoNomina(null);
				}

				tarifaOtrosDevengosDTO.add(tarifaOtrosDevengosDTO2);
			}

			return tarifaOtrosDevengosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaOtrosDevengos getTarifaOtrosDevengos(Long odevengosId) throws Exception {
		log.debug("getting TarifaOtrosDevengos instance");

		TarifaOtrosDevengos entity = null;

		try {
			entity = tarifaOtrosDevengosDAO.findById(odevengosId);
		} catch (Exception e) {
			log.error("get TarifaOtrosDevengos failed", e);
			throw new ZMessManager().new FindingException("TarifaOtrosDevengos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaOtrosDevengos> findPageTarifaOtrosDevengos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TarifaOtrosDevengos> entity = null;

		try {
			entity = tarifaOtrosDevengosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaOtrosDevengos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaOtrosDevengos() throws Exception {
		Long entity = null;

		try {
			entity = tarifaOtrosDevengosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaOtrosDevengos Count");
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
	public List<TarifaOtrosDevengos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaOtrosDevengos> list = new ArrayList<TarifaOtrosDevengos>();
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
			list = tarifaOtrosDevengosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengosByTrabajador(Long Trabajador) throws Exception {
		try {
			List<TarifaOtrosDevengos> tarifaOtrosDevengos = tarifaOtrosDevengosDAO
					.findByCriteria("trabId.trabId= " + Trabajador);

			List<TarifaOtrosDevengosDTO> tarifaOtrosDevengosDTO = new ArrayList<TarifaOtrosDevengosDTO>();

			for (TarifaOtrosDevengos tarifaOtrosDevengosTmp : tarifaOtrosDevengos) {
				TarifaOtrosDevengosDTO tarifaOtrosDevengosDTO2 = new TarifaOtrosDevengosDTO();

				tarifaOtrosDevengosDTO2.setOdevengosId(tarifaOtrosDevengosTmp.getOdevengosId());
				tarifaOtrosDevengosDTO2.setCompania(
						(tarifaOtrosDevengosTmp.getCompania() != null) ? tarifaOtrosDevengosTmp.getCompania() : null);

				tarifaOtrosDevengosDTO2.setEstado(
						(tarifaOtrosDevengosTmp.getEstado() != null) ? tarifaOtrosDevengosTmp.getEstado() : null);
				tarifaOtrosDevengosDTO2.setFechaCreacion(tarifaOtrosDevengosTmp.getFechaCreacion());
				tarifaOtrosDevengosDTO2.setFechaFinal(tarifaOtrosDevengosTmp.getFechaFinal());
				tarifaOtrosDevengosDTO2.setFechaInicial(tarifaOtrosDevengosTmp.getFechaInicial());
				tarifaOtrosDevengosDTO2.setFechaModificacion(tarifaOtrosDevengosTmp.getFechaModificacion());

				tarifaOtrosDevengosDTO2.setValorDeduccion((tarifaOtrosDevengosTmp.getValorDeduccion() != null)
						? tarifaOtrosDevengosTmp.getValorDeduccion() : null);

				if (tarifaOtrosDevengosTmp.getTrabId() != null) {
					tarifaOtrosDevengosDTO2.setTrabId(tarifaOtrosDevengosTmp.getTrabId());
				} else {
					tarifaOtrosDevengosDTO2.setTrabId(null);
				}

				if (tarifaOtrosDevengosTmp.getConceptoNominaId() != null) {
					tarifaOtrosDevengosDTO2.setConceptoNominaId(tarifaOtrosDevengosTmp.getConceptoNominaId());
				} else {
					tarifaOtrosDevengosDTO2.setConceptoNominaId(null);
				}

				if (tarifaOtrosDevengosTmp.getConceptoNominaId() != null) {
					tarifaOtrosDevengosDTO2
							.setCodConceptoNomina(tarifaOtrosDevengosTmp.getConceptoNominaId().getCodigo());
				} else {
					tarifaOtrosDevengosDTO2.setCodConceptoNomina(null);
				}

				tarifaOtrosDevengosDTO2
						.setGeneraDomingosFestivos((tarifaOtrosDevengosTmp.getGeneraDomingosFestivos() != null)
								? tarifaOtrosDevengosTmp.getGeneraDomingosFestivos() : null);
				tarifaOtrosDevengosDTO2.setGeneraAuxilioTransp((tarifaOtrosDevengosTmp.getGeneraAuxilioTransp() != null)
						? tarifaOtrosDevengosTmp.getGeneraAuxilioTransp() : null);

				tarifaOtrosDevengosDTO2.setGeneraAuxilioAdmon((tarifaOtrosDevengosTmp.getGeneraAuxilioAdmon() != null)
						? tarifaOtrosDevengosTmp.getGeneraAuxilioAdmon() : null);

				if (tarifaOtrosDevengosTmp.getCeptoNominaAlternativo() != null) {
					tarifaOtrosDevengosDTO2
							.setCeptoNominaAlternativo(tarifaOtrosDevengosTmp.getCeptoNominaAlternativo());
				} else {
					tarifaOtrosDevengosDTO2.setCeptoNominaAlternativo(null);
				}

				if (tarifaOtrosDevengosTmp.getCeptoNominaAlternativo() != null) {
					tarifaOtrosDevengosDTO2
							.setCodConceptoAlternativo(tarifaOtrosDevengosTmp.getCeptoNominaAlternativo().getCodigo());
				} else {
					tarifaOtrosDevengosDTO2.setCodConceptoAlternativo(null);
				}

				tarifaOtrosDevengosDTO2.setHorasDia(
						(tarifaOtrosDevengosTmp.getHorasDia() != null) ? tarifaOtrosDevengosTmp.getHorasDia() : null);
				tarifaOtrosDevengosDTO2.setHorasMes(
						(tarifaOtrosDevengosTmp.getHorasMes() != null) ? tarifaOtrosDevengosTmp.getHorasMes() : null);

				tarifaOtrosDevengosDTO.add(tarifaOtrosDevengosDTO2);
			}

			return tarifaOtrosDevengosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
