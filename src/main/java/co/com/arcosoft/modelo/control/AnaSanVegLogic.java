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

import co.com.arcosoft.dataaccess.dao.IAnaCultivoDAO;
import co.com.arcosoft.dataaccess.dao.IAnaSanVegDAO;
import co.com.arcosoft.dataaccess.dao.ICultivoDAO;
import co.com.arcosoft.dataaccess.dao.IVariableDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaCultivo;
import co.com.arcosoft.modelo.AnaSanVeg;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Variable;
import co.com.arcosoft.modelo.dto.AnaSanVegDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AnaSanVegLogic")
public class AnaSanVegLogic implements IAnaSanVegLogic {
	private static final Logger log = LoggerFactory.getLogger(AnaSanVegLogic.class);

	/**
	 * DAO injected by Spring that manages AnaSanVeg entities
	 *
	 */
	@Autowired
	private IAnaSanVegDAO anaSanVegDAO;

	/**
	 * DAO injected by Spring that manages AnaCultivo entities
	 *
	 */
	@Autowired
	private IAnaCultivoDAO anaCultivoDAO;

	/**
	 * DAO injected by Spring that manages Variable entities
	 *
	 */
	@Autowired
	private IVariableDAO variableDAO;

	@Autowired
	private ICultivoDAO cultivoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<AnaSanVeg> getAnaSanVeg() throws Exception {
		log.debug("finding all AnaSanVeg instances");

		List<AnaSanVeg> list = new ArrayList<AnaSanVeg>();

		try {
			list = anaSanVegDAO.findAll();
		} catch (Exception e) {
			log.error("finding all AnaSanVeg failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "AnaSanVeg");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception {
		log.debug("saving AnaSanVeg instance");

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

			if ((entity.getNivelRequerido() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivelRequerido(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivelRequerido");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (getAnaSanVeg(entity.getAnaSanVegId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			anaSanVegDAO.save(entity);

			for (String cultivo : selectedCultivos) {

				Long cultivoId = new Long(cultivo);

				Cultivo cul = cultivoDAO.findById(cultivoId);

				// Guardamos en la tabla Analisis Cultivo
				AnaCultivo anaCultivo = new AnaCultivo();
				anaCultivo.setCultivo(cul);
				anaCultivo.setAnaSanVeg(entity);
				anaCultivo.setCompania(entity.getCompania());
				anaCultivo.setFechaCreacion(new Date());
				anaCultivo.setFechaModificacion(new Date());

				anaCultivoDAO.save(anaCultivo);
			}

			log.debug("save AnaSanVeg successful");
		} catch (Exception e) {
			log.error("save AnaSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAnaSanVeg(AnaSanVeg entity) throws Exception {
		log.debug("deleting AnaSanVeg instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("AnaSanVeg");
		}

		if (entity.getAnaSanVegId() == null) {
			throw new ZMessManager().new EmptyFieldException("anaSanVegId");
		}

		List<AnaCultivo> anaCultivos = null;
		List<Variable> variables = null;

		try {
			anaCultivos = anaCultivoDAO.findByProperty("anaSanVeg.anaSanVegId", entity.getAnaSanVegId());

			if (Utilities.validationsList(anaCultivos) == true) {
				throw new ZMessManager().new DeletingException("anaCultivos");
			}

			variables = variableDAO.findByProperty("anaSanVeg.anaSanVegId", entity.getAnaSanVegId());

			if (Utilities.validationsList(variables) == true) {
				throw new ZMessManager().new DeletingException("variables");
			}

			anaSanVegDAO.delete(entity);

			log.debug("delete AnaSanVeg successful");
		} catch (Exception e) {
			log.error("delete AnaSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception {
		log.debug("updating AnaSanVeg instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("AnaSanVeg");
			}

			if (entity.getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId");
			}

			if ((entity.getAnaSanVegId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVegId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId");
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

			if ((entity.getNivelRequerido() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivelRequerido(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivelRequerido");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			anaSanVegDAO.update(entity);

			anaCultivoDAO.deleteByProperty("AnaCultivo", "anaSanVeg.anaSanVegId", entity.getAnaSanVegId());

			for (String cultivo : selectedCultivos) {

				Long cultivoId = new Long(cultivo);

				Cultivo cul = cultivoDAO.findById(cultivoId);

				// Guardamos en la tabla Analisis Cultivo
				AnaCultivo anaCultivo = new AnaCultivo();
				anaCultivo.setCultivo(cul);
				anaCultivo.setAnaSanVeg(entity);
				anaCultivo.setCompania(entity.getCompania());
				anaCultivo.setFechaCreacion(new Date());
				anaCultivo.setFechaModificacion(new Date());

				anaCultivoDAO.save(anaCultivo);
			}

			log.debug("update AnaSanVeg successful");
		} catch (Exception e) {
			log.error("update AnaSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaSanVegDTO> getDataAnaSanVeg() throws Exception {
		try {
			List<AnaSanVeg> anaSanVeg = anaSanVegDAO.findAll();

			List<AnaSanVegDTO> anaSanVegDTO = new ArrayList<AnaSanVegDTO>();

			for (AnaSanVeg anaSanVegTmp : anaSanVeg) {
				AnaSanVegDTO anaSanVegDTO2 = new AnaSanVegDTO();

				anaSanVegDTO2.setAnaSanVegId(anaSanVegTmp.getAnaSanVegId());
				anaSanVegDTO2.setCodigo((anaSanVegTmp.getCodigo() != null) ? anaSanVegTmp.getCodigo() : null);
				anaSanVegDTO2.setCompania((anaSanVegTmp.getCompania() != null) ? anaSanVegTmp.getCompania() : null);
				anaSanVegDTO2.setEstado((anaSanVegTmp.getEstado() != null) ? anaSanVegTmp.getEstado() : null);
				anaSanVegDTO2.setFechaCreacion(anaSanVegTmp.getFechaCreacion());
				anaSanVegDTO2.setFechaModificacion(anaSanVegTmp.getFechaModificacion());
				anaSanVegDTO2.setInfoAdicional(
						(anaSanVegTmp.getInfoAdicional() != null) ? anaSanVegTmp.getInfoAdicional() : null);
				anaSanVegDTO2.setInfoAdicional2(
						(anaSanVegTmp.getInfoAdicional2() != null) ? anaSanVegTmp.getInfoAdicional2() : null);
				anaSanVegDTO2.setNivelRequerido(
						(anaSanVegTmp.getNivelRequerido() != null) ? anaSanVegTmp.getNivelRequerido() : null);
				anaSanVegDTO2.setNombre((anaSanVegTmp.getNombre() != null) ? anaSanVegTmp.getNombre() : null);

				Object[] anaCultivos = anaSanVegTmp.getAnaCultivos().toArray();
				String cultivos = "";

				for (int i = 0; i < anaCultivos.length; i++) {

					AnaCultivo anaCultivo = (AnaCultivo) anaCultivos[i];
					cultivos += anaCultivo.getCultivo().getNombre() + " " + "\n";

				}

				anaSanVegDTO2.setCultivos(cultivos);
				anaSanVegDTO.add(anaSanVegDTO2);

			}

			return anaSanVegDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public AnaSanVeg getAnaSanVeg(Long anaSanVegId) throws Exception {
		log.debug("getting AnaSanVeg instance");

		AnaSanVeg entity = null;

		try {
			entity = anaSanVegDAO.findById(anaSanVegId);
		} catch (Exception e) {
			log.error("get AnaSanVeg failed", e);
			throw new ZMessManager().new FindingException("AnaSanVeg");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnaSanVeg> findPageAnaSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<AnaSanVeg> entity = null;

		try {
			entity = anaSanVegDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaSanVeg Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAnaSanVeg() throws Exception {
		Long entity = null;

		try {
			entity = anaSanVegDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AnaSanVeg Count");
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
	public List<AnaSanVeg> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<AnaSanVeg> list = new ArrayList<AnaSanVeg>();
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
			list = anaSanVegDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
