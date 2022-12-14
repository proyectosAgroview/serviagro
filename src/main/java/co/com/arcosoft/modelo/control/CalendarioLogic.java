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

import co.com.arcosoft.dataaccess.dao.ICalendarioDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Calendario;
import co.com.arcosoft.modelo.dto.CalendarioDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CalendarioLogic")
public class CalendarioLogic implements ICalendarioLogic {
	private static final Logger log = LoggerFactory.getLogger(CalendarioLogic.class);

	/**
	 * DAO injected by Spring that manages Calendario entities
	 *
	 */
	@Autowired
	private ICalendarioDAO calendarioDAO;

	/**
	 * Logic injected by Spring that manages AnioFiscal entities
	 *
	 */
	@Autowired
	IAnioFiscalLogic logicAnioFiscal1;

	/**
	 * Logic injected by Spring that manages TipoDia entities
	 *
	 */
	@Autowired
	ITipoDiaLogic logicTipoDia2;

	@Override
	@Transactional(readOnly = true)
	public List<Calendario> getCalendario() throws Exception {
		log.debug("finding all Calendario instances");

		List<Calendario> list = new ArrayList<Calendario>();

		try {
			list = calendarioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Calendario failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Calendario");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCalendario(Calendario entity) throws Exception {
		log.debug("saving Calendario instance");

		try {
			if (entity.getAnioFiscal() == null) {
				throw new ZMessManager().new ForeignException("anioFiscal");
			}

			if (entity.getTipoDia() == null) {
				throw new ZMessManager().new ForeignException("tipoDia");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getAnioFiscal().getAnioFiscalId() == null) {
				throw new ZMessManager().new EmptyFieldException("anioFiscalId_AnioFiscal");
			}

			if ((entity.getAnioFiscal().getAnioFiscalId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnioFiscal().getAnioFiscalId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalId_AnioFiscal");
			}

			if (entity.getTipoDia().getTipDiaId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipDiaId_TipoDia");
			}

			if ((entity.getTipoDia().getTipDiaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoDia().getTipDiaId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipDiaId_TipoDia");
			}
			/*
			 * if (entity.getCalendarId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("calendarId"); }
			 * 
			 * if ((entity.getCalendarId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCalendarId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "calendarId"); }
			 * 
			 * if (getCalendario(entity.getCalendarId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			calendarioDAO.save(entity);

			log.debug("save Calendario successful");
		} catch (Exception e) {
			log.error("save Calendario failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCalendario(Calendario entity) throws Exception {
		log.debug("deleting Calendario instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Calendario");
		}

		if (entity.getCalendarId() == null) {
			throw new ZMessManager().new EmptyFieldException("calendarId");
		}

		try {
			calendarioDAO.delete(entity);

			log.debug("delete Calendario successful");
		} catch (Exception e) {
			log.error("delete Calendario failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCalendario(Calendario entity) throws Exception {
		log.debug("updating Calendario instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Calendario");
			}

			if (entity.getAnioFiscal() == null) {
				throw new ZMessManager().new ForeignException("anioFiscal");
			}

			if (entity.getTipoDia() == null) {
				throw new ZMessManager().new ForeignException("tipoDia");
			}

			if (entity.getCalendarId() == null) {
				throw new ZMessManager().new EmptyFieldException("calendarId");
			}

			if ((entity.getCalendarId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCalendarId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("calendarId");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getAnioFiscal().getAnioFiscalId() == null) {
				throw new ZMessManager().new EmptyFieldException("anioFiscalId_AnioFiscal");
			}

			if ((entity.getAnioFiscal().getAnioFiscalId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnioFiscal().getAnioFiscalId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalId_AnioFiscal");
			}

			if (entity.getTipoDia().getTipDiaId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipDiaId_TipoDia");
			}

			if ((entity.getTipoDia().getTipDiaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoDia().getTipDiaId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipDiaId_TipoDia");
			}

			calendarioDAO.update(entity);

			log.debug("update Calendario successful");
		} catch (Exception e) {
			log.error("update Calendario failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CalendarioDTO> getDataCalendario() throws Exception {
		try {
			List<Calendario> calendario = calendarioDAO.findAll();

			List<CalendarioDTO> calendarioDTO = new ArrayList<CalendarioDTO>();

			for (Calendario calendarioTmp : calendario) {
				CalendarioDTO calendarioDTO2 = new CalendarioDTO();

				calendarioDTO2.setCalendarId(calendarioTmp.getCalendarId());
				calendarioDTO2.setCodigo((calendarioTmp.getCodigo() != null) ? calendarioTmp.getCodigo() : null);
				calendarioDTO2.setDia(calendarioTmp.getDia());
				calendarioDTO2.setEstado((calendarioTmp.getEstado() != null) ? calendarioTmp.getEstado() : null);
				calendarioDTO2.setFechaCreacion(calendarioTmp.getFechaCreacion());
				calendarioDTO2.setFechaModificacion(calendarioTmp.getFechaModificacion());
				calendarioDTO2.setInfoAdicional(
						(calendarioTmp.getInfoAdicional() != null) ? calendarioTmp.getInfoAdicional() : null);
				calendarioDTO2.setInfoAdicional2(
						(calendarioTmp.getInfoAdicional2() != null) ? calendarioTmp.getInfoAdicional2() : null);
				calendarioDTO2.setAnioFiscalId_AnioFiscal((calendarioTmp.getAnioFiscal().getAnioFiscalId() != null)
						? calendarioTmp.getAnioFiscal().getAnioFiscalId() : null);
				calendarioDTO2.setTipDiaId_TipoDia((calendarioTmp.getTipoDia().getTipDiaId() != null)
						? calendarioTmp.getTipoDia().getTipDiaId() : null);
				calendarioDTO.add(calendarioDTO2);
			}

			return calendarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Calendario getCalendario(Long calendarId) throws Exception {
		log.debug("getting Calendario instance");

		Calendario entity = null;

		try {
			entity = calendarioDAO.findById(calendarId);
		} catch (Exception e) {
			log.error("get Calendario failed", e);
			throw new ZMessManager().new FindingException("Calendario");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Calendario> findPageCalendario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Calendario> entity = null;

		try {
			entity = calendarioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Calendario Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCalendario() throws Exception {
		Long entity = null;

		try {
			entity = calendarioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Calendario Count");
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
	public List<Calendario> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Calendario> list = new ArrayList<Calendario>();
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
			list = calendarioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
