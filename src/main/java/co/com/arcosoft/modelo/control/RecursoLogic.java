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

import co.com.arcosoft.dataaccess.dao.ICostoRecursoDAO;
import co.com.arcosoft.dataaccess.dao.IPlanAsignarRecursoDAO;
import co.com.arcosoft.dataaccess.dao.IRecursoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CostoRecurso;
import co.com.arcosoft.modelo.PlanAsignarRecurso;
import co.com.arcosoft.modelo.Recurso;
import co.com.arcosoft.modelo.dto.RecursoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("RecursoLogic")
public class RecursoLogic implements IRecursoLogic {
	private static final Logger log = LoggerFactory.getLogger(RecursoLogic.class);

	/**
	 * DAO injected by Spring that manages Recurso entities
	 *
	 */
	@Autowired
	private IRecursoDAO recursoDAO;

	/**
	 * DAO injected by Spring that manages CostoRecurso entities
	 *
	 */
	@Autowired
	private ICostoRecursoDAO costoRecursoDAO;

	/**
	 * DAO injected by Spring that manages PlanAsignarRecurso entities
	 *
	 */
	@Autowired
	private IPlanAsignarRecursoDAO planAsignarRecursoDAO;

	/**
	 * Logic injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	ITipoRecursoLogic logicTipoRecurso1;

	@Override
	@Transactional(readOnly = true)
	public List<Recurso> getRecurso() throws Exception {
		log.debug("finding all Recurso instances");

		List<Recurso> list = new ArrayList<Recurso>();

		try {
			list = recursoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Recurso failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Recurso");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRecurso(Recurso entity) throws Exception {
		log.debug("saving Recurso instance");

		try {
			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
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

			if (entity.getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if ((entity.getTipoRecurso().getTpRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoRecurso().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId_TipoRecurso");
			}

			if (getRecurso(entity.getRecursoId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			recursoDAO.save(entity);

			log.debug("save Recurso successful");
		} catch (Exception e) {
			log.error("save Recurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRecurso(Recurso entity) throws Exception {
		log.debug("deleting Recurso instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Recurso");
		}

		if (entity.getRecursoId() == null) {
			throw new ZMessManager().new EmptyFieldException("recursoId");
		}

		List<CostoRecurso> costoRecursos = null;
		List<PlanAsignarRecurso> planAsignarRecursos = null;

		try {
			costoRecursos = costoRecursoDAO.findByProperty("recurso.recursoId", entity.getRecursoId());

			if (Utilities.validationsList(costoRecursos) == true) {
				throw new ZMessManager().new DeletingException("costoRecursos");
			}

			planAsignarRecursos = planAsignarRecursoDAO.findByProperty("recurso.recursoId", entity.getRecursoId());

			if (Utilities.validationsList(planAsignarRecursos) == true) {
				throw new ZMessManager().new DeletingException("planAsignarRecursos");
			}

			recursoDAO.delete(entity);

			log.debug("delete Recurso successful");
		} catch (Exception e) {
			log.error("delete Recurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRecurso(Recurso entity) throws Exception {
		log.debug("updating Recurso instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Recurso");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
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

			if (entity.getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if ((entity.getTipoRecurso().getTpRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoRecurso().getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId_TipoRecurso");
			}

			recursoDAO.update(entity);

			log.debug("update Recurso successful");
		} catch (Exception e) {
			log.error("update Recurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<RecursoDTO> getDataRecurso() throws Exception {
		try {
			List<Recurso> recurso = recursoDAO.findAll();

			List<RecursoDTO> recursoDTO = new ArrayList<RecursoDTO>();

			for (Recurso recursoTmp : recurso) {
				RecursoDTO recursoDTO2 = new RecursoDTO();

				recursoDTO2.setRecursoId(recursoTmp.getRecursoId());
				recursoDTO2.setCodigo((recursoTmp.getCodigo() != null) ? recursoTmp.getCodigo() : null);
				recursoDTO2.setCompania((recursoTmp.getCompania() != null) ? recursoTmp.getCompania() : null);
				recursoDTO2.setEstado((recursoTmp.getEstado() != null) ? recursoTmp.getEstado() : null);
				recursoDTO2.setFechaCreacion(recursoTmp.getFechaCreacion());
				recursoDTO2.setFechaModificacion(recursoTmp.getFechaModificacion());
				recursoDTO2.setInfoAdicional(
						(recursoTmp.getInfoAdicional() != null) ? recursoTmp.getInfoAdicional() : null);
				recursoDTO2.setInfoAdicional2(
						(recursoTmp.getInfoAdicional2() != null) ? recursoTmp.getInfoAdicional2() : null);
				recursoDTO2.setNombre((recursoTmp.getNombre() != null) ? recursoTmp.getNombre() : null);
				recursoDTO2.setTpRecursoId_TipoRecurso((recursoTmp.getTipoRecurso().getTpRecursoId() != null)
						? recursoTmp.getTipoRecurso().getTpRecursoId() : null);
				recursoDTO.add(recursoDTO2);
			}

			return recursoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Recurso getRecurso(Long recursoId) throws Exception {
		log.debug("getting Recurso instance");

		Recurso entity = null;

		try {
			entity = recursoDAO.findById(recursoId);
		} catch (Exception e) {
			log.error("get Recurso failed", e);
			throw new ZMessManager().new FindingException("Recurso");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Recurso> findPageRecurso(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Recurso> entity = null;

		try {
			entity = recursoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Recurso Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberRecurso() throws Exception {
		Long entity = null;

		try {
			entity = recursoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Recurso Count");
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
	public List<Recurso> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Recurso> list = new ArrayList<Recurso>();
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
			list = recursoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
