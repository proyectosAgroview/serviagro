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

import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDAO;
import co.com.arcosoft.dataaccess.dao.IDatServImplementoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.ILaborServicioDAO;
import co.com.arcosoft.dataaccess.dao.IServicioDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatServImplemento;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.LaborServicio;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.dto.ServicioDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ServicioLogic")
public class ServicioLogic implements IServicioLogic {
	private static final Logger log = LoggerFactory.getLogger(ServicioLogic.class);

	/**
	 * DAO injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	private IServicioDAO servicioDAO;

	/**
	 * DAO injected by Spring that manages DatPlanLabor entities
	 *
	 */
	@Autowired
	private IDatPlanLaborDAO datPlanLaborDAO;

	/**
	 * DAO injected by Spring that manages DatServImplemento entities
	 *
	 */
	@Autowired
	private IDatServImplementoDAO datServImplementoDAO;

	/**
	 * DAO injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	private IDatServicioDAO datServicioDAO;

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	/**
	 * DAO injected by Spring that manages LaborServicio entities
	 *
	 */
	@Autowired
	private ILaborServicioDAO laborServicioDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> getServicio() throws Exception {
		log.debug("finding all Servicio instances");

		List<Servicio> list = new ArrayList<Servicio>();

		try {
			list = servicioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Servicio failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Servicio");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveServicio(Servicio entity) throws Exception {
		log.debug("saving Servicio instance");

		try {
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
			 * if (entity.getServicioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("servicioId"); }
			 * 
			 * if ((entity.getServicioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getServicioId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "servicioId"); }
			 * 
			 * 
			 * if (getServicio(entity.getServicioId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			servicioDAO.save(entity);

			log.debug("save Servicio successful");
		} catch (Exception e) {
			log.error("save Servicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteServicio(Servicio entity) throws Exception {
		log.debug("deleting Servicio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Servicio");
		}

		if (entity.getServicioId() == null) {
			throw new ZMessManager().new EmptyFieldException("servicioId");
		}

		List<DatPlanLabor> datPlanLabors = null;
		List<DatServImplemento> datServImplementos = null;
		List<DatServicio> datServicios = null;
		List<Equipo> equipos = null;
		List<LaborServicio> laborServicios = null;

		try {
			datPlanLabors = datPlanLaborDAO.findByProperty("servicio.servicioId", entity.getServicioId());

			if (Utilities.validationsList(datPlanLabors) == true) {
				throw new ZMessManager().new DeletingException("datPlanLabors");
			}

			datServImplementos = datServImplementoDAO.findByProperty("servicio.servicioId", entity.getServicioId());

			if (Utilities.validationsList(datServImplementos) == true) {
				throw new ZMessManager().new DeletingException("datServImplementos");
			}

			datServicios = datServicioDAO.findByProperty("servicio.servicioId", entity.getServicioId());

			if (Utilities.validationsList(datServicios) == true) {
				throw new ZMessManager().new DeletingException("datServicios");
			}

			equipos = equipoDAO.findByProperty("servicio.servicioId", entity.getServicioId());

			if (Utilities.validationsList(equipos) == true) {
				throw new ZMessManager().new DeletingException("equipos");
			}

			laborServicios = laborServicioDAO.findByProperty("servicio.servicioId", entity.getServicioId());

			if (Utilities.validationsList(laborServicios) == true) {
				throw new ZMessManager().new DeletingException("laborServicios");
			}

			servicioDAO.delete(entity);

			log.debug("delete Servicio successful");
		} catch (Exception e) {
			log.error("delete Servicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateServicio(Servicio entity) throws Exception {
		log.debug("updating Servicio instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Servicio");
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

			if (entity.getServicioId() == null) {
				throw new ZMessManager().new EmptyFieldException("servicioId");
			}

			if ((entity.getServicioId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getServicioId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("servicioId");
			}

			servicioDAO.update(entity);

			log.debug("update Servicio successful");
		} catch (Exception e) {
			log.error("update Servicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ServicioDTO> getDataServicio() throws Exception {
		try {
			List<Servicio> servicio = servicioDAO.findAll();

			List<ServicioDTO> servicioDTO = new ArrayList<ServicioDTO>();

			for (Servicio servicioTmp : servicio) {
				ServicioDTO servicioDTO2 = new ServicioDTO();

				servicioDTO2.setServicioId(servicioTmp.getServicioId());
				servicioDTO2.setCodigo((servicioTmp.getCodigo() != null) ? servicioTmp.getCodigo() : null);
				servicioDTO2.setCompania((servicioTmp.getCompania() != null) ? servicioTmp.getCompania() : null);
				servicioDTO2.setEstado((servicioTmp.getEstado() != null) ? servicioTmp.getEstado() : null);
				servicioDTO2.setFechaCreacion(servicioTmp.getFechaCreacion());
				servicioDTO2.setFechaModificacion(servicioTmp.getFechaModificacion());
				servicioDTO2.setInfoAdicional(
						(servicioTmp.getInfoAdicional() != null) ? servicioTmp.getInfoAdicional() : null);
				servicioDTO2.setInfoAdicional2(
						(servicioTmp.getInfoAdicional2() != null) ? servicioTmp.getInfoAdicional2() : null);
				servicioDTO2.setNombre((servicioTmp.getNombre() != null) ? servicioTmp.getNombre() : null);

				servicioDTO.add(servicioDTO2);
			}

			return servicioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio getServicio(Long servicioId) throws Exception {
		log.debug("getting Servicio instance");

		Servicio entity = null;

		try {
			entity = servicioDAO.findById(servicioId);
		} catch (Exception e) {
			log.error("get Servicio failed", e);
			throw new ZMessManager().new FindingException("Servicio");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findPageServicio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Servicio> entity = null;

		try {
			entity = servicioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Servicio Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberServicio() throws Exception {
		Long entity = null;

		try {
			entity = servicioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Servicio Count");
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
	public List<Servicio> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Servicio> list = new ArrayList<Servicio>();
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
			list = servicioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
