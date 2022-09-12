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

import co.com.arcosoft.dataaccess.dao.INivel1DAO;
import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.dto.Nivel1DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("Nivel1Logic")
public class Nivel1Logic implements INivel1Logic {
	private static final Logger log = LoggerFactory.getLogger(Nivel1Logic.class);

	/**
	 * DAO injected by Spring that manages Nivel1 entities
	 *
	 */
	@Autowired
	private INivel1DAO nivel1DAO;

	/**
	 * DAO injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	private INivel2DAO nivel2DAO;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador1;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel1> getNivel1() throws Exception {
		log.debug("finding all Nivel1 instances");

		List<Nivel1> list = new ArrayList<Nivel1>();

		try {
			list = nivel1DAO.findAll();
		} catch (Exception e) {
			log.error("finding all Nivel1 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Nivel1");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveNivel1(Nivel1 entity) throws Exception {
		log.debug("saving Nivel1 instance");

		try {
			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 */
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

			/*
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			/*
			 * if (entity.getNivel1Id() == null) { throw new ZMessManager().new
			 * EmptyFieldException("nivel1Id"); }
			 * 
			 * if ((entity.getNivel1Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel1Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("nivel1Id"); } if
			 * (getNivel1(entity.getNivel1Id()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			nivel1DAO.save(entity);

			log.debug("save Nivel1 successful");
		} catch (Exception e) {
			log.error("save Nivel1 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteNivel1(Nivel1 entity) throws Exception {
		log.debug("deleting Nivel1 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Nivel1");
		}

		if (entity.getNivel1Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel1Id");
		}

		List<Nivel2> nivel2s = null;

		try {
			nivel2s = nivel2DAO.findByProperty("nivel1.nivel1Id", entity.getNivel1Id());

			if (Utilities.validationsList(nivel2s) == true) {
				throw new ZMessManager().new DeletingException("nivel2s");
			}

			nivel1DAO.delete(entity);

			log.debug("delete Nivel1 successful");
		} catch (Exception e) {
			log.error("delete Nivel1 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateNivel1(Nivel1 entity) throws Exception {
		log.debug("updating Nivel1 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Nivel1");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 */
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

			if (entity.getNivel1Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel1Id");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			nivel1DAO.update(entity);

			log.debug("update Nivel1 successful");
		} catch (Exception e) {
			log.error("update Nivel1 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel1DTO> getDataNivel1() throws Exception {
		try {
			List<Nivel1> nivel1 = nivel1DAO.findAll();

			List<Nivel1DTO> nivel1DTO = new ArrayList<Nivel1DTO>();

			for (Nivel1 nivel1Tmp : nivel1) {
				Nivel1DTO nivel1DTO2 = new Nivel1DTO();

				nivel1DTO2.setNivel1Id(nivel1Tmp.getNivel1Id());
				nivel1DTO2.setCodigo((nivel1Tmp.getCodigo() != null) ? nivel1Tmp.getCodigo() : null);
				nivel1DTO2.setCompania((nivel1Tmp.getCompania() != null) ? nivel1Tmp.getCompania() : null);
				nivel1DTO2.setEstado((nivel1Tmp.getEstado() != null) ? nivel1Tmp.getEstado() : null);
				nivel1DTO2.setFechaCreacion(nivel1Tmp.getFechaCreacion());
				nivel1DTO2.setFechaModificacion(nivel1Tmp.getFechaModificacion());
				nivel1DTO2
						.setInfoAdicional((nivel1Tmp.getInfoAdicional() != null) ? nivel1Tmp.getInfoAdicional() : null);
				nivel1DTO2.setInfoAdicional2(
						(nivel1Tmp.getInfoAdicional2() != null) ? nivel1Tmp.getInfoAdicional2() : null);
				nivel1DTO2.setLatitud((nivel1Tmp.getLatitud() != null) ? nivel1Tmp.getLatitud() : null);
				nivel1DTO2.setLongitud((nivel1Tmp.getLongitud() != null) ? nivel1Tmp.getLongitud() : null);
				nivel1DTO2.setNombre((nivel1Tmp.getNombre() != null) ? nivel1Tmp.getNombre() : null);
				nivel1DTO2.setPrecision((nivel1Tmp.getPrecision() != null) ? nivel1Tmp.getPrecision() : null);
				nivel1DTO2.setTrabId_Trabajador((nivel1Tmp.getTrabajador() != null) ? nivel1Tmp.getTrabajador() : null);
				nivel1DTO.add(nivel1DTO2);
			}

			return nivel1DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel1 getNivel1(Long nivel1Id) throws Exception {
		log.debug("getting Nivel1 instance");

		Nivel1 entity = null;

		try {
			entity = nivel1DAO.findById(nivel1Id);
		} catch (Exception e) {
			log.error("get Nivel1 failed", e);
			throw new ZMessManager().new FindingException("Nivel1");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel1> findPageNivel1(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Nivel1> entity = null;

		try {
			entity = nivel1DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel1 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel1() throws Exception {
		Long entity = null;

		try {
			entity = nivel1DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel1 Count");
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
	public List<Nivel1> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Nivel1> list = new ArrayList<Nivel1>();
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
			list = nivel1DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
