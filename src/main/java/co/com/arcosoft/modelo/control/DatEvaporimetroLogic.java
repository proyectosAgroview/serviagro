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

import co.com.arcosoft.dataaccess.dao.IDatEvaporimetroDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatEvaporimetro;
import co.com.arcosoft.modelo.EstEvaporimetro;
import co.com.arcosoft.modelo.dto.DatEvaporimetroDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatEvaporimetroLogic")
public class DatEvaporimetroLogic implements IDatEvaporimetroLogic {
	private static final Logger log = LoggerFactory.getLogger(DatEvaporimetroLogic.class);

	/**
	 * DAO injected by Spring that manages DatEvaporimetro entities
	 *
	 */
	@Autowired
	private IDatEvaporimetroDAO datEvaporimetroDAO;

	/**
	 * Logic injected by Spring that manages EstEvaporimetro entities
	 *
	 */
	@Autowired
	IEstEvaporimetroLogic logicEstEvaporimetro1;

	@Override
	@Transactional(readOnly = true)
	public List<DatEvaporimetro> getDatEvaporimetro() throws Exception {
		log.debug("finding all DatEvaporimetro instances");

		List<DatEvaporimetro> list = new ArrayList<DatEvaporimetro>();

		try {
			list = datEvaporimetroDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatEvaporimetro failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatEvaporimetro");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		log.debug("saving DatEvaporimetro instance");

		try {
			if (entity.getEstEvaporimetro() == null) {
				throw new ZMessManager().new ForeignException("estEvaporimetro");
			}

			/*
			 * if ((entity.getCodigo() != null) &&
			 * (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) ==
			 * false)) { throw new ZMessManager().new
			 * NotValidFormatException("codigo"); }
			 */

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getDatEvaporimetroId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datEvaporimetroId"); }
			 */

			/*
			 * if ((entity.getDatEvaporimetroId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatEvaporimetroId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datEvaporimetroId");
			 * }
			 */

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEvaporacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTemperaturaMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMaxima(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMaxima");
			}

			if ((entity.getTemperaturaMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMedia(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMedia");
			}

			if ((entity.getTemperaturaMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMinima(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMinima");
			}

			if (entity.getEstEvaporimetro().getEstEvaporimetroId() == null) {
				throw new ZMessManager().new EmptyFieldException("estEvaporimetroId_EstEvaporimetro");
			}

			if ((entity.getEstEvaporimetro().getEstEvaporimetroId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getEstEvaporimetro().getEstEvaporimetroId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estEvaporimetroId_EstEvaporimetro");
			}

			/*
			 * if (getDatEvaporimetro(entity.getDatEvaporimetroId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datEvaporimetroDAO.save(entity);

			log.debug("save DatEvaporimetro successful");
		} catch (Exception e) {
			log.error("save DatEvaporimetro failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		log.debug("deleting DatEvaporimetro instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatEvaporimetro");
		}

		if (entity.getDatEvaporimetroId() == null) {
			throw new ZMessManager().new EmptyFieldException("datEvaporimetroId");
		}

		try {
			datEvaporimetroDAO.delete(entity);

			log.debug("delete DatEvaporimetro successful");
		} catch (Exception e) {
			log.error("delete DatEvaporimetro failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		log.debug("updating DatEvaporimetro instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatEvaporimetro");
			}

			if (entity.getEstEvaporimetro() == null) {
				throw new ZMessManager().new ForeignException("estEvaporimetro");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getDatEvaporimetroId() == null) {
				throw new ZMessManager().new EmptyFieldException("datEvaporimetroId");
			}

			if ((entity.getDatEvaporimetroId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatEvaporimetroId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datEvaporimetroId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEvaporacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTemperaturaMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMaxima(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMaxima");
			}

			if ((entity.getTemperaturaMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMedia(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMedia");
			}

			if ((entity.getTemperaturaMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMinima(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMinima");
			}

			if (entity.getEstEvaporimetro().getEstEvaporimetroId() == null) {
				throw new ZMessManager().new EmptyFieldException("estEvaporimetroId_EstEvaporimetro");
			}

			if ((entity.getEstEvaporimetro().getEstEvaporimetroId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getEstEvaporimetro().getEstEvaporimetroId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estEvaporimetroId_EstEvaporimetro");
			}

			datEvaporimetroDAO.update(entity);

			log.debug("update DatEvaporimetro successful");
		} catch (Exception e) {
			log.error("update DatEvaporimetro failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEvaporimetroDTO> getDataDatEvaporimetro() throws Exception {
		try {
			List<DatEvaporimetro> datEvaporimetro = datEvaporimetroDAO.findAll();
			List<DatEvaporimetroDTO> datEvaporimetroDTO = new ArrayList<DatEvaporimetroDTO>();

			for (DatEvaporimetro datEvaporimetroTmp : datEvaporimetro) {
				DatEvaporimetroDTO datEvaporimetroDTO2 = new DatEvaporimetroDTO();

				datEvaporimetroDTO2.setDatEvaporimetroId(datEvaporimetroTmp.getDatEvaporimetroId());
				datEvaporimetroDTO2.setCompania(
						(datEvaporimetroTmp.getCompania() != null) ? datEvaporimetroTmp.getCompania() : null);
				datEvaporimetroDTO2
						.setEstado((datEvaporimetroTmp.getEstado() != null) ? datEvaporimetroTmp.getEstado() : null);
				datEvaporimetroDTO2.setEvaporacion(
						(datEvaporimetroTmp.getEvaporacion() != null) ? datEvaporimetroTmp.getEvaporacion() : null);
				datEvaporimetroDTO2.setFechaCreacion(datEvaporimetroTmp.getFechaCreacion());
				datEvaporimetroDTO2.setFechaEvaporacion(datEvaporimetroTmp.getFechaEvaporacion());
				datEvaporimetroDTO2.setFechaModificacion(datEvaporimetroTmp.getFechaModificacion());
				datEvaporimetroDTO2.setInfoAdicional(
						(datEvaporimetroTmp.getInfoAdicional() != null) ? datEvaporimetroTmp.getInfoAdicional() : null);
				datEvaporimetroDTO2.setInfoAdicional2((datEvaporimetroTmp.getInfoAdicional2() != null)
						? datEvaporimetroTmp.getInfoAdicional2() : null);
				datEvaporimetroDTO2.setObservacion(
						(datEvaporimetroTmp.getObservacion() != null) ? datEvaporimetroTmp.getObservacion() : null);
				datEvaporimetroDTO2.setObservacionAnularReg((datEvaporimetroTmp.getObservacionAnularReg() != null)
						? datEvaporimetroTmp.getObservacionAnularReg() : null);
				datEvaporimetroDTO2.setTemperaturaMaxima((datEvaporimetroTmp.getTemperaturaMaxima() != null)
						? datEvaporimetroTmp.getTemperaturaMaxima() : null);
				datEvaporimetroDTO2.setTemperaturaMedia((datEvaporimetroTmp.getTemperaturaMedia() != null)
						? datEvaporimetroTmp.getTemperaturaMedia() : null);
				datEvaporimetroDTO2.setTemperaturaMinima((datEvaporimetroTmp.getTemperaturaMinima() != null)
						? datEvaporimetroTmp.getTemperaturaMinima() : null);
				datEvaporimetroDTO2.setEstEvaporimetroId_EstEvaporimetro(
						(datEvaporimetroTmp.getEstEvaporimetro().getEstEvaporimetroId() != null)
								? datEvaporimetroTmp.getEstEvaporimetro().getEstEvaporimetroId() : null);

				EstEvaporimetro estacion = datEvaporimetroTmp.getEstEvaporimetro();
				String e = estacion.getNombre();
				datEvaporimetroDTO2.setEstacionEvaporimetro(e);

				String estadoEstrue = "false";
				if (datEvaporimetroTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datEvaporimetroDTO2.setEstadoTrue(estadoEstrue);
				}
				datEvaporimetroDTO2.setEstadoTrue(estadoEstrue);

				datEvaporimetroDTO.add(datEvaporimetroDTO2);
			}

			return datEvaporimetroDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatEvaporimetro getDatEvaporimetro(Long datEvaporimetroId) throws Exception {
		log.debug("getting DatEvaporimetro instance");

		DatEvaporimetro entity = null;

		try {
			entity = datEvaporimetroDAO.findById(datEvaporimetroId);
		} catch (Exception e) {
			log.error("get DatEvaporimetro failed", e);
			throw new ZMessManager().new FindingException("DatEvaporimetro");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEvaporimetro> findPageDatEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatEvaporimetro> entity = null;

		try {
			entity = datEvaporimetroDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEvaporimetro Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatEvaporimetro() throws Exception {
		Long entity = null;

		try {
			entity = datEvaporimetroDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEvaporimetro Count");
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
	public List<DatEvaporimetro> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatEvaporimetro> list = new ArrayList<DatEvaporimetro>();
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
			list = datEvaporimetroDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEvaporimetroDTO> findByCriteriaPageDatEvaporimetro(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatEvaporimetro> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = datEvaporimetroDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatEvaporimetroDTO> datEvaporimetroDTO = new ArrayList<DatEvaporimetroDTO>();

			for (DatEvaporimetro datEvaporimetroTmp : entity) {
				DatEvaporimetroDTO datEvaporimetroDTO2 = new DatEvaporimetroDTO();

				datEvaporimetroDTO2.setDatEvaporimetroId(datEvaporimetroTmp.getDatEvaporimetroId());
				datEvaporimetroDTO2.setCompania(
						(datEvaporimetroTmp.getCompania() != null) ? datEvaporimetroTmp.getCompania() : null);
				datEvaporimetroDTO2
						.setEstado((datEvaporimetroTmp.getEstado() != null) ? datEvaporimetroTmp.getEstado() : null);
				datEvaporimetroDTO2.setEvaporacion(
						(datEvaporimetroTmp.getEvaporacion() != null) ? datEvaporimetroTmp.getEvaporacion() : null);
				datEvaporimetroDTO2.setFechaCreacion(datEvaporimetroTmp.getFechaCreacion());
				datEvaporimetroDTO2.setFechaEvaporacion(datEvaporimetroTmp.getFechaEvaporacion());
				datEvaporimetroDTO2.setFechaModificacion(datEvaporimetroTmp.getFechaModificacion());
				datEvaporimetroDTO2.setInfoAdicional(
						(datEvaporimetroTmp.getInfoAdicional() != null) ? datEvaporimetroTmp.getInfoAdicional() : null);
				datEvaporimetroDTO2.setInfoAdicional2((datEvaporimetroTmp.getInfoAdicional2() != null)
						? datEvaporimetroTmp.getInfoAdicional2() : null);
				datEvaporimetroDTO2.setObservacion(
						(datEvaporimetroTmp.getObservacion() != null) ? datEvaporimetroTmp.getObservacion() : null);
				datEvaporimetroDTO2.setObservacionAnularReg((datEvaporimetroTmp.getObservacionAnularReg() != null)
						? datEvaporimetroTmp.getObservacionAnularReg() : null);
				datEvaporimetroDTO2.setTemperaturaMaxima((datEvaporimetroTmp.getTemperaturaMaxima() != null)
						? datEvaporimetroTmp.getTemperaturaMaxima() : null);
				datEvaporimetroDTO2.setTemperaturaMedia((datEvaporimetroTmp.getTemperaturaMedia() != null)
						? datEvaporimetroTmp.getTemperaturaMedia() : null);
				datEvaporimetroDTO2.setTemperaturaMinima((datEvaporimetroTmp.getTemperaturaMinima() != null)
						? datEvaporimetroTmp.getTemperaturaMinima() : null);
				datEvaporimetroDTO2.setEstEvaporimetroId_EstEvaporimetro(
						(datEvaporimetroTmp.getEstEvaporimetro().getEstEvaporimetroId() != null)
								? datEvaporimetroTmp.getEstEvaporimetro().getEstEvaporimetroId() : null);

				EstEvaporimetro estacion = datEvaporimetroTmp.getEstEvaporimetro();
				String e = estacion.getNombre();
				datEvaporimetroDTO2.setEstacionEvaporimetro(e);

				String estadoEstrue = "false";
				if (datEvaporimetroTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datEvaporimetroDTO2.setEstadoTrue(estadoEstrue);
				}
				datEvaporimetroDTO2.setEstadoTrue(estadoEstrue);

				datEvaporimetroDTO.add(datEvaporimetroDTO2);
			}

			return datEvaporimetroDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatEvaporimetro(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = datEvaporimetroDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEvaporimetro Count");
		} finally {
		}
		return entity;
	}
}
