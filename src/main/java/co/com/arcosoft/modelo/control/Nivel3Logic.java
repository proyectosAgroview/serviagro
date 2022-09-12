package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.INivel3DAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.Nivel3DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("Nivel3Logic")
public class Nivel3Logic implements INivel3Logic {
	private static final Logger log = LoggerFactory.getLogger(Nivel3Logic.class);

	/**
	 * DAO injected by Spring that manages Nivel3 entities
	 *
	 */
	@Autowired
	private INivel3DAO nivel3DAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	/**
	 * Logic injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	INivel2Logic logicNivel21;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador2;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel3> getNivel3() throws Exception {
		log.debug("finding all Nivel3 instances");

		List<Nivel3> list = new ArrayList<Nivel3>();

		try {
			list = nivel3DAO.findAll();
		} catch (Exception e) {
			log.error("finding all Nivel3 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Nivel3");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveNivel3(Nivel3 entity) throws Exception {
		log.debug("saving Nivel3 instance");

		try {
			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
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
			 * if (entity.getNivel3Id() == null) { throw new ZMessManager().new
			 * EmptyFieldException("nivel3Id"); }
			 * 
			 * if ((entity.getNivel3Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel3Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("nivel3Id"); }
			 * 
			 * if (getNivel3(entity.getNivel3Id()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			nivel3DAO.save(entity);

			log.debug("save Nivel3 successful");
		} catch (Exception e) {
			log.error("save Nivel3 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteNivel3(Nivel3 entity) throws Exception {
		log.debug("deleting Nivel3 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Nivel3");
		}

		if (entity.getNivel3Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel3Id");
		}

		List<Nivel4> nivel4s = null;

		try {
			nivel4s = nivel4DAO.findByProperty("nivel3.nivel3Id", entity.getNivel3Id());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			nivel3DAO.delete(entity);

			log.debug("delete Nivel3 successful");
		} catch (Exception e) {
			log.error("delete Nivel3 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateNivel3(Nivel3 entity) throws Exception {
		log.debug("updating Nivel3 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Nivel3");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
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

			if (entity.getNivel3Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel3Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			/*
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			nivel3DAO.update(entity);

			log.debug("update Nivel3 successful");
		} catch (Exception e) {
			log.error("update Nivel3 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel3DTO> getDataNivel3() throws Exception {
		try {
			List<Nivel3> nivel3 = nivel3DAO.findAll();

			List<Nivel3DTO> nivel3DTO = new ArrayList<Nivel3DTO>();

			for (Nivel3 nivel3Tmp : nivel3) {
				Nivel3DTO nivel3DTO2 = new Nivel3DTO();

				nivel3DTO2.setNivel3Id(nivel3Tmp.getNivel3Id());
				nivel3DTO2.setCodigo((nivel3Tmp.getCodigo() != null) ? nivel3Tmp.getCodigo() : null);
				nivel3DTO2.setCompania((nivel3Tmp.getCompania() != null) ? nivel3Tmp.getCompania() : null);
				nivel3DTO2.setEstado((nivel3Tmp.getEstado() != null) ? nivel3Tmp.getEstado() : null);
				nivel3DTO2.setFechaCreacion(nivel3Tmp.getFechaCreacion());
				nivel3DTO2.setFechaModificacion(nivel3Tmp.getFechaModificacion());
				nivel3DTO2
						.setInfoAdicional((nivel3Tmp.getInfoAdicional() != null) ? nivel3Tmp.getInfoAdicional() : null);
				nivel3DTO2.setInfoAdicional2(
						(nivel3Tmp.getInfoAdicional2() != null) ? nivel3Tmp.getInfoAdicional2() : null);
				nivel3DTO2.setLatitud((nivel3Tmp.getLatitud() != null) ? nivel3Tmp.getLatitud() : null);
				nivel3DTO2.setLongitud((nivel3Tmp.getLongitud() != null) ? nivel3Tmp.getLongitud() : null);
				nivel3DTO2.setNombre((nivel3Tmp.getNombre() != null) ? nivel3Tmp.getNombre() : null);
				nivel3DTO2.setPrecision((nivel3Tmp.getPrecision() != null) ? nivel3Tmp.getPrecision() : null);

				if (nivel3Tmp.getNivel2() != null) {

					String nombre = nivel3Tmp.getNivel2().getNombre();
					nivel3DTO2.setNombreNivel2(nombre);
				}
				nivel3DTO2.setTrabId_Trabajador((nivel3Tmp.getTrabajador() != null) ? nivel3Tmp.getTrabajador() : null);

				nivel3DTO.add(nivel3DTO2);
			}

			return nivel3DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel3 getNivel3(Long nivel3Id) throws Exception {
		log.debug("getting Nivel3 instance");

		Nivel3 entity = null;

		try {
			entity = nivel3DAO.findById(nivel3Id);
		} catch (Exception e) {
			log.error("get Nivel3 failed", e);
			throw new ZMessManager().new FindingException("Nivel3");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel3> findPageNivel3(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Nivel3> entity = null;

		try {
			entity = nivel3DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel3 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel3() throws Exception {
		Long entity = null;

		try {
			entity = nivel3DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel3 Count");
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
	public List<Nivel3> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Nivel3> list = new ArrayList<Nivel3>();
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
			list = nivel3DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel3DTO> findByCriteriaPageNivel3(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {
			List<Nivel3> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("nombreNivel2")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = nivel3DAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<Nivel3DTO> nivel3DTO = new ArrayList<Nivel3DTO>();

			for (Nivel3 nivel3Tmp : entity) {
				Nivel3DTO nivel3DTO2 = new Nivel3DTO();

				nivel3DTO2.setNivel3Id(nivel3Tmp.getNivel3Id());
				nivel3DTO2.setCodigo((nivel3Tmp.getCodigo() != null) ? nivel3Tmp.getCodigo() : null);
				nivel3DTO2.setCompania((nivel3Tmp.getCompania() != null) ? nivel3Tmp.getCompania() : null);
				nivel3DTO2.setEstado((nivel3Tmp.getEstado() != null) ? nivel3Tmp.getEstado() : null);
				nivel3DTO2.setFechaCreacion(nivel3Tmp.getFechaCreacion());
				nivel3DTO2.setFechaModificacion(nivel3Tmp.getFechaModificacion());
				nivel3DTO2
						.setInfoAdicional((nivel3Tmp.getInfoAdicional() != null) ? nivel3Tmp.getInfoAdicional() : null);
				nivel3DTO2.setInfoAdicional2(
						(nivel3Tmp.getInfoAdicional2() != null) ? nivel3Tmp.getInfoAdicional2() : null);
				nivel3DTO2.setLatitud((nivel3Tmp.getLatitud() != null) ? nivel3Tmp.getLatitud() : null);
				nivel3DTO2.setLongitud((nivel3Tmp.getLongitud() != null) ? nivel3Tmp.getLongitud() : null);
				nivel3DTO2.setPrecision((nivel3Tmp.getPrecision() != null) ? nivel3Tmp.getPrecision() : null);
				nivel3DTO2.setNombre((nivel3Tmp.getNombre() != null) ? nivel3Tmp.getNombre() : null);
				
				if (nivel3Tmp.getNivel2() != null) {

					String nombre = nivel3Tmp.getNivel2().getNombre();
					nivel3DTO2.setNombreNivel2(nombre);
				}
				nivel3DTO2.setTrabId_Trabajador((nivel3Tmp.getTrabajador() != null) ? nivel3Tmp.getTrabajador() : null);

				nivel3DTO.add(nivel3DTO2);
			}

			return nivel3DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel3(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				if (e.getKey().equals("nombreNivel2")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}
			entity = nivel3DAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel3 Count");
		} finally {
		}
		return entity;
	}

}
