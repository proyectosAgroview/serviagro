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

import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IFlotaTransporteDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.FlotaTransporte;
import co.com.arcosoft.modelo.dto.FlotaTransporteDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("FlotaTransporteLogic")
public class FlotaTransporteLogic implements IFlotaTransporteLogic {
	private static final Logger log = LoggerFactory.getLogger(FlotaTransporteLogic.class);

	/**
	 * DAO injected by Spring that manages FlotaTransporte entities
	 *
	 */
	@Autowired
	private IFlotaTransporteDAO flotaTransporteDAO;

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<FlotaTransporte> getFlotaTransporte() throws Exception {
		log.debug("finding all FlotaTransporte instances");

		List<FlotaTransporte> list = new ArrayList<FlotaTransporte>();

		try {
			list = flotaTransporteDAO.findAll();
		} catch (Exception e) {
			log.error("finding all FlotaTransporte failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "FlotaTransporte");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveFlotaTransporte(FlotaTransporte entity) throws Exception {
		log.debug("saving FlotaTransporte instance");

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

			if ((entity.getKmhAsfalto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKmhAsfalto(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kmhAsfalto");
			}

			if ((entity.getKmhTerraceria() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKmhTerraceria(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kmhTerraceria");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getVelocidadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMaxima(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMaxima");
			}

			if ((entity.getVelocidadMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMinima(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMinima");
			}

			/*
			 * if (entity.getFlotaTranspId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "flotaTranspId"); }
			 * 
			 * if ((entity.getFlotaTranspId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFlotaTranspId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "flotaTranspId"); }
			 * 
			 * if (getFlotaTransporte(entity.getFlotaTranspId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			flotaTransporteDAO.save(entity);

			log.debug("save FlotaTransporte successful");
		} catch (Exception e) {
			log.error("save FlotaTransporte failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteFlotaTransporte(FlotaTransporte entity) throws Exception {
		log.debug("deleting FlotaTransporte instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("FlotaTransporte");
		}

		if (entity.getFlotaTranspId() == null) {
			throw new ZMessManager().new EmptyFieldException("flotaTranspId");
		}

		List<Equipo> equipos = null;

		try {
			equipos = equipoDAO.findByProperty("flotaTransporte.flotaTranspId", entity.getFlotaTranspId());

			if (Utilities.validationsList(equipos) == true) {
				throw new ZMessManager().new DeletingException("equipos");
			}

			flotaTransporteDAO.delete(entity);

			log.debug("delete FlotaTransporte successful");
		} catch (Exception e) {
			log.error("delete FlotaTransporte failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateFlotaTransporte(FlotaTransporte entity) throws Exception {
		log.debug("updating FlotaTransporte instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("FlotaTransporte");
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

			if (entity.getFlotaTranspId() == null) {
				throw new ZMessManager().new EmptyFieldException("flotaTranspId");
			}

			if ((entity.getFlotaTranspId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFlotaTranspId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("flotaTranspId");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getKmhAsfalto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKmhAsfalto(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kmhAsfalto");
			}

			if ((entity.getKmhTerraceria() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKmhTerraceria(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kmhTerraceria");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getVelocidadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMaxima(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMaxima");
			}

			if ((entity.getVelocidadMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMinima(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMinima");
			}

			flotaTransporteDAO.update(entity);

			log.debug("update FlotaTransporte successful");
		} catch (Exception e) {
			log.error("update FlotaTransporte failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlotaTransporteDTO> getDataFlotaTransporte() throws Exception {
		try {
			List<FlotaTransporte> flotaTransporte = flotaTransporteDAO.findAll();

			List<FlotaTransporteDTO> flotaTransporteDTO = new ArrayList<FlotaTransporteDTO>();

			for (FlotaTransporte flotaTransporteTmp : flotaTransporte) {
				FlotaTransporteDTO flotaTransporteDTO2 = new FlotaTransporteDTO();

				flotaTransporteDTO2.setFlotaTranspId(flotaTransporteTmp.getFlotaTranspId());
				flotaTransporteDTO2
						.setCodigo((flotaTransporteTmp.getCodigo() != null) ? flotaTransporteTmp.getCodigo() : null);
				flotaTransporteDTO2.setCompania(
						(flotaTransporteTmp.getCompania() != null) ? flotaTransporteTmp.getCompania() : null);
				flotaTransporteDTO2
						.setEstado((flotaTransporteTmp.getEstado() != null) ? flotaTransporteTmp.getEstado() : null);
				flotaTransporteDTO2.setFechaCreacion(flotaTransporteTmp.getFechaCreacion());
				flotaTransporteDTO2.setFechaModificacion(flotaTransporteTmp.getFechaModificacion());
				flotaTransporteDTO2.setInfoAdicional(
						(flotaTransporteTmp.getInfoAdicional() != null) ? flotaTransporteTmp.getInfoAdicional() : null);
				flotaTransporteDTO2.setInfoAdicional2((flotaTransporteTmp.getInfoAdicional2() != null)
						? flotaTransporteTmp.getInfoAdicional2() : null);
				flotaTransporteDTO2.setKmhAsfalto(
						(flotaTransporteTmp.getKmhAsfalto() != null) ? flotaTransporteTmp.getKmhAsfalto() : null);
				flotaTransporteDTO2.setKmhTerraceria(
						(flotaTransporteTmp.getKmhTerraceria() != null) ? flotaTransporteTmp.getKmhTerraceria() : null);
				flotaTransporteDTO2
						.setNombre((flotaTransporteTmp.getNombre() != null) ? flotaTransporteTmp.getNombre() : null);
				flotaTransporteDTO2.setVelocidadMaxima((flotaTransporteTmp.getVelocidadMaxima() != null)
						? flotaTransporteTmp.getVelocidadMaxima() : null);
				flotaTransporteDTO2.setVelocidadMinima((flotaTransporteTmp.getVelocidadMinima() != null)
						? flotaTransporteTmp.getVelocidadMinima() : null);
				flotaTransporteDTO.add(flotaTransporteDTO2);
			}

			return flotaTransporteDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FlotaTransporte getFlotaTransporte(Long flotaTranspId) throws Exception {
		log.debug("getting FlotaTransporte instance");

		FlotaTransporte entity = null;

		try {
			entity = flotaTransporteDAO.findById(flotaTranspId);
		} catch (Exception e) {
			log.error("get FlotaTransporte failed", e);
			throw new ZMessManager().new FindingException("FlotaTransporte");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlotaTransporte> findPageFlotaTransporte(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<FlotaTransporte> entity = null;

		try {
			entity = flotaTransporteDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FlotaTransporte Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFlotaTransporte() throws Exception {
		Long entity = null;

		try {
			entity = flotaTransporteDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FlotaTransporte Count");
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
	public List<FlotaTransporte> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<FlotaTransporte> list = new ArrayList<FlotaTransporte>();
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
			list = flotaTransporteDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlotaTransporteDTO> findByCriteriaPageFlotaTransporte(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<FlotaTransporte> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = flotaTransporteDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<FlotaTransporteDTO> flotaTransporteDTO = new ArrayList<FlotaTransporteDTO>();

			for (FlotaTransporte flotaTransporteTmp : entity) {
				FlotaTransporteDTO flotaTransporteDTO2 = new FlotaTransporteDTO();

				flotaTransporteDTO2.setFlotaTranspId(flotaTransporteTmp.getFlotaTranspId());
				flotaTransporteDTO2
						.setCodigo((flotaTransporteTmp.getCodigo() != null) ? flotaTransporteTmp.getCodigo() : null);
				flotaTransporteDTO2.setCompania(
						(flotaTransporteTmp.getCompania() != null) ? flotaTransporteTmp.getCompania() : null);
				flotaTransporteDTO2
						.setEstado((flotaTransporteTmp.getEstado() != null) ? flotaTransporteTmp.getEstado() : null);
				flotaTransporteDTO2.setFechaCreacion(flotaTransporteTmp.getFechaCreacion());
				flotaTransporteDTO2.setFechaModificacion(flotaTransporteTmp.getFechaModificacion());
				flotaTransporteDTO2.setInfoAdicional(
						(flotaTransporteTmp.getInfoAdicional() != null) ? flotaTransporteTmp.getInfoAdicional() : null);
				flotaTransporteDTO2.setInfoAdicional2((flotaTransporteTmp.getInfoAdicional2() != null)
						? flotaTransporteTmp.getInfoAdicional2() : null);
				flotaTransporteDTO2.setKmhAsfalto(
						(flotaTransporteTmp.getKmhAsfalto() != null) ? flotaTransporteTmp.getKmhAsfalto() : null);
				flotaTransporteDTO2.setKmhTerraceria(
						(flotaTransporteTmp.getKmhTerraceria() != null) ? flotaTransporteTmp.getKmhTerraceria() : null);
				flotaTransporteDTO2
						.setNombre((flotaTransporteTmp.getNombre() != null) ? flotaTransporteTmp.getNombre() : null);
				flotaTransporteDTO2.setVelocidadMaxima((flotaTransporteTmp.getVelocidadMaxima() != null)
						? flotaTransporteTmp.getVelocidadMaxima() : null);
				flotaTransporteDTO2.setVelocidadMinima((flotaTransporteTmp.getVelocidadMinima() != null)
						? flotaTransporteTmp.getVelocidadMinima() : null);
				flotaTransporteDTO.add(flotaTransporteDTO2);
			}

			return flotaTransporteDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFlotaTransporte(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = flotaTransporteDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FlotaTransporte Count");
		} finally {
		}
		return entity;
	}
}
