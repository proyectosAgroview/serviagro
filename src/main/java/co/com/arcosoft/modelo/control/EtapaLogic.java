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

import co.com.arcosoft.dataaccess.dao.IEtapaDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.EtapaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EtapaLogic")
public class EtapaLogic implements IEtapaLogic {
	private static final Logger log = LoggerFactory.getLogger(EtapaLogic.class);

	/**
	 * DAO injected by Spring that manages Etapa entities
	 *
	 */
	@Autowired
	private IEtapaDAO etapaDAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	/**
	 * Logic injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	ICultivoLogic logicCultivo1;

	@Override
	@Transactional(readOnly = true)
	public List<Etapa> getEtapa() throws Exception {
		log.debug("finding all Etapa instances");

		List<Etapa> list = new ArrayList<Etapa>();

		try {
			list = etapaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Etapa failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Etapa");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEtapa(Etapa entity) throws Exception {
		log.debug("saving Etapa instance");

		try {
			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
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

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroCosechas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroCosechas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroCosechas");
			}

			if ((entity.getProximaEtapa() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProximaEtapa(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proximaEtapa");
			}

			if ((entity.getTipoCosecha() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoCosecha(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoCosecha");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			/*
			 * if (entity.getEtapaId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("etapaId"); }
			 * 
			 * if ((entity.getEtapaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEtapaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("etapaId"); }
			 * 
			 * if (getEtapa(entity.getEtapaId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			etapaDAO.save(entity);

			log.debug("save Etapa successful");
		} catch (Exception e) {
			log.error("save Etapa failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEtapa(Etapa entity) throws Exception {
		log.debug("deleting Etapa instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Etapa");
		}

		if (entity.getEtapaId() == null) {
			throw new ZMessManager().new EmptyFieldException("etapaId");
		}

		List<Nivel4> nivel4s = null;

		try {
			nivel4s = nivel4DAO.findByProperty("etapa.etapaId", entity.getEtapaId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			etapaDAO.delete(entity);

			log.debug("delete Etapa successful");
		} catch (Exception e) {
			log.error("delete Etapa failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEtapa(Etapa entity) throws Exception {
		log.debug("updating Etapa instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Etapa");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
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

			if (entity.getEtapaId() == null) {
				throw new ZMessManager().new EmptyFieldException("etapaId");
			}

			if ((entity.getEtapaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaId");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroCosechas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroCosechas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroCosechas");
			}

			if ((entity.getProximaEtapa() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProximaEtapa(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proximaEtapa");
			}

			if ((entity.getTipoCosecha() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoCosecha(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoCosecha");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			etapaDAO.update(entity);

			log.debug("update Etapa successful");
		} catch (Exception e) {
			log.error("update Etapa failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EtapaDTO> getDataEtapa() throws Exception {
		try {
			List<Etapa> etapa = etapaDAO.findAll();

			List<EtapaDTO> etapaDTO = new ArrayList<EtapaDTO>();

			for (Etapa etapaTmp : etapa) {
				EtapaDTO etapaDTO2 = new EtapaDTO();

				etapaDTO2.setEtapaId(etapaTmp.getEtapaId());
				etapaDTO2.setCodigo((etapaTmp.getCodigo() != null) ? etapaTmp.getCodigo() : null);
				etapaDTO2.setCompania((etapaTmp.getCompania() != null) ? etapaTmp.getCompania() : null);
				etapaDTO2.setEstado((etapaTmp.getEstado() != null) ? etapaTmp.getEstado() : null);
				etapaDTO2.setFechaCreacion(etapaTmp.getFechaCreacion());
				etapaDTO2.setFechaModificacion(etapaTmp.getFechaModificacion());
				etapaDTO2.setInfoAdicional((etapaTmp.getInfoAdicional() != null) ? etapaTmp.getInfoAdicional() : null);
				etapaDTO2.setInfoAdicional2(
						(etapaTmp.getInfoAdicional2() != null) ? etapaTmp.getInfoAdicional2() : null);
				etapaDTO2.setNombre((etapaTmp.getNombre() != null) ? etapaTmp.getNombre() : null);
				etapaDTO2.setNumeroCosechas(
						(etapaTmp.getNumeroCosechas() != null) ? etapaTmp.getNumeroCosechas() : null);
				etapaDTO2.setProximaEtapa((etapaTmp.getProximaEtapa() != null) ? etapaTmp.getProximaEtapa() : null);
				etapaDTO2.setTipoCosecha((etapaTmp.getTipoCosecha() != null) ? etapaTmp.getTipoCosecha() : null);

				if (etapaTmp.getCultivo() != null) {
					etapaDTO2.setCultivoId_Cultivo(etapaTmp.getCultivo().getCultivoId());
				} else {
					etapaDTO2.setCultivoId_Cultivo(null);
				}

				etapaDTO.add(etapaDTO2);
			}

			return etapaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Etapa getEtapa(Long etapaId) throws Exception {
		log.debug("getting Etapa instance");

		Etapa entity = null;

		try {
			entity = etapaDAO.findById(etapaId);
		} catch (Exception e) {
			log.error("get Etapa failed", e);
			throw new ZMessManager().new FindingException("Etapa");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Etapa> findPageEtapa(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Etapa> entity = null;

		try {
			entity = etapaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Etapa Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEtapa() throws Exception {
		Long entity = null;

		try {
			entity = etapaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Etapa Count");
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
	public List<Etapa> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Etapa> list = new ArrayList<Etapa>();
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
			list = etapaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
