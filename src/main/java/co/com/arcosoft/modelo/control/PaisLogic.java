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

import co.com.arcosoft.dataaccess.dao.IEstadoDAO;
import co.com.arcosoft.dataaccess.dao.IPaisDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Estado;
import co.com.arcosoft.modelo.Pais;
import co.com.arcosoft.modelo.dto.PaisDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PaisLogic")
public class PaisLogic implements IPaisLogic {
	private static final Logger log = LoggerFactory.getLogger(PaisLogic.class);

	/**
	 * DAO injected by Spring that manages Pais entities
	 *
	 */
	@Autowired
	private IPaisDAO paisDAO;

	/**
	 * DAO injected by Spring that manages Estado entities
	 *
	 */
	@Autowired
	private IEstadoDAO estadoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Pais> getPais() throws Exception {
		log.debug("finding all Pais instances");

		List<Pais> list = new ArrayList<Pais>();

		try {
			list = paisDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Pais failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Pais");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePais(Pais entity) throws Exception {
		log.debug("saving Pais instance");

		try {
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (entity.getPaisId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("paisId"); }
			 * 
			 * if ((entity.getPaisId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getPaisId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("paisId"); }
			 * 
			 * if (getPais(entity.getPaisId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			paisDAO.save(entity);

			log.debug("save Pais successful");
		} catch (Exception e) {
			log.error("save Pais failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePais(Pais entity) throws Exception {
		log.debug("deleting Pais instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Pais");
		}

		if (entity.getPaisId() == null) {
			throw new ZMessManager().new EmptyFieldException("paisId");
		}

		List<Estado> estados = null;

		try {
			estados = estadoDAO.findByProperty("pais.paisId", entity.getPaisId());

			if (Utilities.validationsList(estados) == true) {
				throw new ZMessManager().new DeletingException("estados");
			}

			paisDAO.delete(entity);

			log.debug("delete Pais successful");
		} catch (Exception e) {
			log.error("delete Pais failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePais(Pais entity) throws Exception {
		log.debug("updating Pais instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Pais");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getPaisId() == null) {
				throw new ZMessManager().new EmptyFieldException("paisId");
			}

			if ((entity.getPaisId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPaisId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("paisId");
			}

			paisDAO.update(entity);

			log.debug("update Pais successful");
		} catch (Exception e) {
			log.error("update Pais failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PaisDTO> getDataPais() throws Exception {
		try {
			List<Pais> pais = paisDAO.findAll();

			List<PaisDTO> paisDTO = new ArrayList<PaisDTO>();

			for (Pais paisTmp : pais) {
				PaisDTO paisDTO2 = new PaisDTO();

				paisDTO2.setPaisId(paisTmp.getPaisId());
				paisDTO2.setCodigo((paisTmp.getCodigo() != null) ? paisTmp.getCodigo() : null);
				paisDTO2.setEstado((paisTmp.getEstado() != null) ? paisTmp.getEstado() : null);
				paisDTO2.setFechaCreacion(paisTmp.getFechaCreacion());
				paisDTO2.setFechaModificacion(paisTmp.getFechaModificacion());
				paisDTO2.setInfoAdicional((paisTmp.getInfoAdicional() != null) ? paisTmp.getInfoAdicional() : null);
				paisDTO2.setInfoAdicional2((paisTmp.getInfoAdicional2() != null) ? paisTmp.getInfoAdicional2() : null);
				paisDTO2.setNombre((paisTmp.getNombre() != null) ? paisTmp.getNombre() : null);
				paisDTO.add(paisDTO2);
			}

			return paisDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Pais getPais(Long paisId) throws Exception {
		log.debug("getting Pais instance");

		Pais entity = null;

		try {
			entity = paisDAO.findById(paisId);
		} catch (Exception e) {
			log.error("get Pais failed", e);
			throw new ZMessManager().new FindingException("Pais");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pais> findPagePais(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Pais> entity = null;

		try {
			entity = paisDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pais Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPais() throws Exception {
		Long entity = null;

		try {
			entity = paisDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pais Count");
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
	public List<Pais> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Pais> list = new ArrayList<Pais>();
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
			list = paisDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
