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

import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoTrabajoDAO;
import co.com.arcosoft.dataaccess.dao.ITrabajadorDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.EquipoTrabajo;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.dto.EquipoTrabajoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EquipoTrabajoLogic")
public class EquipoTrabajoLogic implements IEquipoTrabajoLogic {
	private static final Logger log = LoggerFactory.getLogger(EquipoTrabajoLogic.class);

	/**
	 * DAO injected by Spring that manages EquipoTrabajo entities
	 *
	 */
	@Autowired
	private IEquipoTrabajoDAO equipoTrabajoDAO;

	/**
	 * DAO injected by Spring that manages DatPlanillaNomina entities
	 *
	 */
	@Autowired
	private IDatPlanillaNominaDAO datPlanillaNominaDAO;

	/**
	 * DAO injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	private ITrabajadorDAO trabajadorDAO;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador1;

	@Override
	@Transactional(readOnly = true)
	public List<EquipoTrabajo> getEquipoTrabajo() throws Exception {
		log.debug("finding all EquipoTrabajo instances");

		List<EquipoTrabajo> list = new ArrayList<EquipoTrabajo>();

		try {
			list = equipoTrabajoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all EquipoTrabajo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "EquipoTrabajo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		log.debug("saving EquipoTrabajo instance");

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

			if ((entity.getInfoAdicional1() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional1(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional1");
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
			 * if (entity.getEqpTrabId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("eqpTrabId"); }
			 * 
			 * if ((entity.getEqpTrabId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEqpTrabId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "eqpTrabId"); }
			 * 
			 * 
			 * 
			 * if (getEquipoTrabajo(entity.getEqpTrabId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			equipoTrabajoDAO.save(entity);

			log.debug("save EquipoTrabajo successful");
		} catch (Exception e) {
			log.error("save EquipoTrabajo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		log.debug("deleting EquipoTrabajo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("EquipoTrabajo");
		}

		if (entity.getEqpTrabId() == null) {
			throw new ZMessManager().new EmptyFieldException("eqpTrabId");
		}

		List<DatPlanillaNomina> datPlanillaNominas = null;
		List<Trabajador> trabajadors = null;

		try {
			datPlanillaNominas = datPlanillaNominaDAO.findByProperty("equipoTrabajo.eqpTrabId", entity.getEqpTrabId());

			if (Utilities.validationsList(datPlanillaNominas) == true) {
				throw new ZMessManager().new DeletingException("datPlanillaNominas");
			}

			trabajadors = trabajadorDAO.findByProperty("equipoTrabajo.eqpTrabId", entity.getEqpTrabId());

			if (Utilities.validationsList(trabajadors) == true) {
				throw new ZMessManager().new DeletingException("trabajadors");
			}

			equipoTrabajoDAO.delete(entity);

			log.debug("delete EquipoTrabajo successful");
		} catch (Exception e) {
			log.error("delete EquipoTrabajo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		log.debug("updating EquipoTrabajo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("EquipoTrabajo");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getEqpTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("eqpTrabId");
			}

			if ((entity.getEqpTrabId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEqpTrabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("eqpTrabId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional1() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional1(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional1");
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

			equipoTrabajoDAO.update(entity);

			log.debug("update EquipoTrabajo successful");
		} catch (Exception e) {
			log.error("update EquipoTrabajo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EquipoTrabajoDTO> getDataEquipoTrabajo() throws Exception {
		try {
			List<EquipoTrabajo> equipoTrabajo = equipoTrabajoDAO.findAll();

			List<EquipoTrabajoDTO> equipoTrabajoDTO = new ArrayList<EquipoTrabajoDTO>();

			for (EquipoTrabajo equipoTrabajoTmp : equipoTrabajo) {
				EquipoTrabajoDTO equipoTrabajoDTO2 = new EquipoTrabajoDTO();

				equipoTrabajoDTO2.setEqpTrabId(equipoTrabajoTmp.getEqpTrabId());
				equipoTrabajoDTO2
						.setCodigo((equipoTrabajoTmp.getCodigo() != null) ? equipoTrabajoTmp.getCodigo() : null);
				equipoTrabajoDTO2
						.setCompania((equipoTrabajoTmp.getCompania() != null) ? equipoTrabajoTmp.getCompania() : null);
				equipoTrabajoDTO2
						.setEstado((equipoTrabajoTmp.getEstado() != null) ? equipoTrabajoTmp.getEstado() : null);
				equipoTrabajoDTO2.setFechaCreacion(equipoTrabajoTmp.getFechaCreacion());
				equipoTrabajoDTO2.setFechaModificacion(equipoTrabajoTmp.getFechaModificacion());
				equipoTrabajoDTO2.setInfoAdicional(
						(equipoTrabajoTmp.getInfoAdicional() != null) ? equipoTrabajoTmp.getInfoAdicional() : null);
				equipoTrabajoDTO2.setInfoAdicional1(
						(equipoTrabajoTmp.getInfoAdicional1() != null) ? equipoTrabajoTmp.getInfoAdicional1() : null);
				equipoTrabajoDTO2
						.setNombre((equipoTrabajoTmp.getNombre() != null) ? equipoTrabajoTmp.getNombre() : null);

				equipoTrabajoDTO2.setTrabId_Trabajador(
						(equipoTrabajoTmp.getTrabajador() != null) ? equipoTrabajoTmp.getTrabajador() : null);

				equipoTrabajoDTO.add(equipoTrabajoDTO2);
			}

			return equipoTrabajoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public EquipoTrabajo getEquipoTrabajo(Long eqpTrabId) throws Exception {
		log.debug("getting EquipoTrabajo instance");

		EquipoTrabajo entity = null;

		try {
			entity = equipoTrabajoDAO.findById(eqpTrabId);
		} catch (Exception e) {
			log.error("get EquipoTrabajo failed", e);
			throw new ZMessManager().new FindingException("EquipoTrabajo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EquipoTrabajo> findPageEquipoTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<EquipoTrabajo> entity = null;

		try {
			entity = equipoTrabajoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EquipoTrabajo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEquipoTrabajo() throws Exception {
		Long entity = null;

		try {
			entity = equipoTrabajoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EquipoTrabajo Count");
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
	public List<EquipoTrabajo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<EquipoTrabajo> list = new ArrayList<EquipoTrabajo>();
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
			list = equipoTrabajoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
