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

import co.com.arcosoft.dataaccess.dao.ICiudadDAO;
import co.com.arcosoft.dataaccess.dao.ICompaniaDAO;
import co.com.arcosoft.dataaccess.dao.IConductorDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdDetDAO;
import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.dataaccess.dao.IPersEmprDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Conductor;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.dto.CiudadDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CiudadLogic")
public class CiudadLogic implements ICiudadLogic {
	private static final Logger log = LoggerFactory.getLogger(CiudadLogic.class);

	/**
	 * DAO injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	private ICiudadDAO ciudadDAO;

	/**
	 * DAO injected by Spring that manages Compania entities
	 *
	 */
	@Autowired
	private ICompaniaDAO companiaDAO;

	/**
	 * DAO injected by Spring that manages Conductor entities
	 *
	 */
	@Autowired
	private IConductorDAO conductorDAO;

	/**
	 * DAO injected by Spring that manages DatTransProdDet entities
	 *
	 */
	@Autowired
	private IDatTransProdDetDAO datTransProdDetDAO;

	/**
	 * DAO injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	private INivel2DAO nivel2DAO;

	/**
	 * DAO injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	private IPersEmprDAO persEmprDAO;

	/**
	 * Logic injected by Spring that manages Estado entities
	 *
	 */
	@Autowired
	IEstadoLogic logicEstado1;

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> getCiudad() throws Exception {
		log.debug("finding all Ciudad instances");

		List<Ciudad> list = new ArrayList<Ciudad>();

		try {
			list = ciudadDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Ciudad failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Ciudad");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCiudad(Ciudad entity) throws Exception {
		log.debug("saving Ciudad instance");

		try {
			if (entity.getEstado() == null) {
				throw new ZMessManager().new ForeignException("estado");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEstado_1() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado_1(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado_1");
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

			if (entity.getEstado().getEstadoId() == null) {
				throw new ZMessManager().new EmptyFieldException("estadoId_Estado");
			}

			if ((entity.getEstado().getEstadoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEstado().getEstadoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estadoId_Estado");
			}
			/*
			 * if (entity.getCiudadId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("ciudadId"); }
			 * 
			 * if ((entity.getCiudadId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCiudadId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("ciudadId"); }
			 * 
			 * if (getCiudad(entity.getCiudadId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			ciudadDAO.save(entity);

			log.debug("save Ciudad successful");
		} catch (Exception e) {
			log.error("save Ciudad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCiudad(Ciudad entity) throws Exception {
		log.debug("deleting Ciudad instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Ciudad");
		}

		if (entity.getCiudadId() == null) {
			throw new ZMessManager().new EmptyFieldException("ciudadId");
		}

		List<Compania> companias = null;
		List<Compania> companias_1 = null;
		List<Conductor> conductorsForCiudadExpId = null;
		List<Conductor> conductorsForCiudadExpLic = null;
		List<DatTransProdDet> datTransProdDets = null;
		List<Nivel2> nivel2s = null;
		List<PersEmpr> persEmprs = null;

		try {
			companias = companiaDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(companias) == true) {
				throw new ZMessManager().new DeletingException("companias");
			}

			companias_1 = companiaDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(companias_1) == true) {
				throw new ZMessManager().new DeletingException("companias_1");
			}

			conductorsForCiudadExpId = conductorDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(conductorsForCiudadExpId) == true) {
				throw new ZMessManager().new DeletingException("conductorsForCiudadExpId");
			}

			conductorsForCiudadExpLic = conductorDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(conductorsForCiudadExpLic) == true) {
				throw new ZMessManager().new DeletingException("conductorsForCiudadExpLic");
			}

			datTransProdDets = datTransProdDetDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(datTransProdDets) == true) {
				throw new ZMessManager().new DeletingException("datTransProdDets");
			}

			nivel2s = nivel2DAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(nivel2s) == true) {
				throw new ZMessManager().new DeletingException("nivel2s");
			}

			persEmprs = persEmprDAO.findByProperty("ciudad.ciudadId", entity.getCiudadId());

			if (Utilities.validationsList(persEmprs) == true) {
				throw new ZMessManager().new DeletingException("persEmprs");
			}

			ciudadDAO.delete(entity);

			log.debug("delete Ciudad successful");
		} catch (Exception e) {
			log.error("delete Ciudad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCiudad(Ciudad entity) throws Exception {
		log.debug("updating Ciudad instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Ciudad");
			}

			if (entity.getEstado() == null) {
				throw new ZMessManager().new ForeignException("estado");
			}

			if (entity.getCiudadId() == null) {
				throw new ZMessManager().new EmptyFieldException("ciudadId");
			}

			if ((entity.getCiudadId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudadId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEstado_1() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado_1(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado_1");
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

			if (entity.getEstado().getEstadoId() == null) {
				throw new ZMessManager().new EmptyFieldException("estadoId_Estado");
			}

			if ((entity.getEstado().getEstadoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEstado().getEstadoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estadoId_Estado");
			}

			ciudadDAO.update(entity);

			log.debug("update Ciudad successful");
		} catch (Exception e) {
			log.error("update Ciudad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CiudadDTO> getDataCiudad() throws Exception {
		try {
			List<Ciudad> ciudad = ciudadDAO.findAll();

			List<CiudadDTO> ciudadDTO = new ArrayList<CiudadDTO>();

			for (Ciudad ciudadTmp : ciudad) {
				CiudadDTO ciudadDTO2 = new CiudadDTO();

				ciudadDTO2.setCiudadId(ciudadTmp.getCiudadId());
				ciudadDTO2.setCodigo((ciudadTmp.getCodigo() != null) ? ciudadTmp.getCodigo() : null);
				ciudadDTO2.setEstado_1((ciudadTmp.getEstado_1() != null) ? ciudadTmp.getEstado_1() : null);
				ciudadDTO2.setFechaCreacion(ciudadTmp.getFechaCreacion());
				ciudadDTO2.setFechaModificacion(ciudadTmp.getFechaModificacion());
				ciudadDTO2
						.setInfoAdicional((ciudadTmp.getInfoAdicional() != null) ? ciudadTmp.getInfoAdicional() : null);
				ciudadDTO2.setInfoAdicional2(
						(ciudadTmp.getInfoAdicional2() != null) ? ciudadTmp.getInfoAdicional2() : null);
				ciudadDTO2.setNombre((ciudadTmp.getNombre() != null) ? ciudadTmp.getNombre() : null);

				if (ciudadTmp.getEstado() != null) {
					ciudadDTO2.setEstadoId_Estado(ciudadTmp.getEstado().getEstadoId());
				} else {
					ciudadDTO2.setEstadoId_Estado(null);
				}

				ciudadDTO.add(ciudadDTO2);
			}

			return ciudadDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Ciudad getCiudad(Long ciudadId) throws Exception {
		log.debug("getting Ciudad instance");

		Ciudad entity = null;

		try {
			entity = ciudadDAO.findById(ciudadId);
		} catch (Exception e) {
			log.error("get Ciudad failed", e);
			throw new ZMessManager().new FindingException("Ciudad");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findPageCiudad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Ciudad> entity = null;

		try {
			entity = ciudadDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Ciudad Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCiudad() throws Exception {
		Long entity = null;

		try {
			entity = ciudadDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Ciudad Count");
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
	public List<Ciudad> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Ciudad> list = new ArrayList<Ciudad>();
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
			list = ciudadDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
