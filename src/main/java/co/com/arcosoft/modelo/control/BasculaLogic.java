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

import co.com.arcosoft.dataaccess.dao.IBasculaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Bascula;
import co.com.arcosoft.modelo.dto.BasculaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("BasculaLogic")
public class BasculaLogic implements IBasculaLogic {
	private static final Logger log = LoggerFactory.getLogger(BasculaLogic.class);

	/**
	 * DAO injected by Spring that manages Bascula entities
	 *
	 */
	@Autowired
	private IBasculaDAO basculaDAO;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed1;

	@Override
	@Transactional(readOnly = true)
	public List<Bascula> getBascula() throws Exception {
		log.debug("finding all Bascula instances");

		List<Bascula> list = new ArrayList<Bascula>();

		try {
			list = basculaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Bascula failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Bascula");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveBascula(Bascula entity) throws Exception {
		log.debug("saving Bascula instance");

		try {
			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getBitDatos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getBitDatos(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("bitDatos");
			}

			if ((entity.getBitParada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getBitParada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("bitParada");
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

			if ((entity.getParidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getParidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("paridad");
			}

			if ((entity.getPuertoCom() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPuertoCom(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("puertoCom");
			}

			if ((entity.getTipoLectura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoLectura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoLectura");
			}

			if ((entity.getVelocidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidad(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidad");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			basculaDAO.save(entity);

			log.debug("save Bascula successful");
		} catch (Exception e) {
			log.error("save Bascula failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteBascula(Bascula entity) throws Exception {
		log.debug("deleting Bascula instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Bascula");
		}

		if (entity.getBasculaId() == null) {
			throw new ZMessManager().new EmptyFieldException("basculaId");
		}

		try {
			basculaDAO.delete(entity);

			log.debug("delete Bascula successful");
		} catch (Exception e) {
			log.error("delete Bascula failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateBascula(Bascula entity) throws Exception {
		log.debug("updating Bascula instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Bascula");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if (entity.getBasculaId() == null) {
				throw new ZMessManager().new EmptyFieldException("basculaId");
			}

			if ((entity.getBasculaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getBasculaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("basculaId");
			}

			if ((entity.getBitDatos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getBitDatos(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("bitDatos");
			}

			if ((entity.getBitParada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getBitParada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("bitParada");
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

			if ((entity.getParidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getParidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("paridad");
			}

			if ((entity.getPuertoCom() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPuertoCom(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("puertoCom");
			}

			if ((entity.getTipoLectura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoLectura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoLectura");
			}

			if ((entity.getVelocidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidad(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidad");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			basculaDAO.update(entity);

			log.debug("update Bascula successful");
		} catch (Exception e) {
			log.error("update Bascula failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<BasculaDTO> getDataBascula() throws Exception {
		try {
			List<Bascula> bascula = basculaDAO.findAll();

			List<BasculaDTO> basculaDTO = new ArrayList<BasculaDTO>();

			for (Bascula basculaTmp : bascula) {
				BasculaDTO basculaDTO2 = new BasculaDTO();

				basculaDTO2.setBasculaId(basculaTmp.getBasculaId());
				basculaDTO2.setBitDatos((basculaTmp.getBitDatos() != null) ? basculaTmp.getBitDatos() : null);
				basculaDTO2.setBitParada((basculaTmp.getBitParada() != null) ? basculaTmp.getBitParada() : null);
				basculaDTO2.setCodigo((basculaTmp.getCodigo() != null) ? basculaTmp.getCodigo() : null);
				basculaDTO2.setCompania((basculaTmp.getCompania() != null) ? basculaTmp.getCompania() : null);
				basculaDTO2.setEstado((basculaTmp.getEstado() != null) ? basculaTmp.getEstado() : null);
				basculaDTO2.setFechaCreacion(basculaTmp.getFechaCreacion());
				basculaDTO2.setFechaModificacion(basculaTmp.getFechaModificacion());
				basculaDTO2.setInfoAdicional(
						(basculaTmp.getInfoAdicional() != null) ? basculaTmp.getInfoAdicional() : null);
				basculaDTO2.setInfoAdicional2(
						(basculaTmp.getInfoAdicional2() != null) ? basculaTmp.getInfoAdicional2() : null);
				basculaDTO2.setNombre((basculaTmp.getNombre() != null) ? basculaTmp.getNombre() : null);
				basculaDTO2.setParidad((basculaTmp.getParidad() != null) ? basculaTmp.getParidad() : null);
				basculaDTO2.setPuertoCom((basculaTmp.getPuertoCom() != null) ? basculaTmp.getPuertoCom() : null);
				basculaDTO2.setTipoLectura((basculaTmp.getTipoLectura() != null) ? basculaTmp.getTipoLectura() : null);
				basculaDTO2.setVelocidad((basculaTmp.getVelocidad() != null) ? basculaTmp.getVelocidad() : null);
				basculaDTO2.setUdadMedId_UdadMed((basculaTmp.getUdadMed().getUdadMedId() != null)
						? basculaTmp.getUdadMed().getUdadMedId() : null);
				basculaDTO.add(basculaDTO2);
			}

			return basculaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Bascula getBascula(Long basculaId) throws Exception {
		log.debug("getting Bascula instance");

		Bascula entity = null;

		try {
			entity = basculaDAO.findById(basculaId);
		} catch (Exception e) {
			log.error("get Bascula failed", e);
			throw new ZMessManager().new FindingException("Bascula");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bascula> findPageBascula(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Bascula> entity = null;

		try {
			entity = basculaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Bascula Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberBascula() throws Exception {
		Long entity = null;

		try {
			entity = basculaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Bascula Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<Bascula> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Bascula> list = new ArrayList<Bascula>();
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
			list = basculaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
