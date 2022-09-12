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

import co.com.arcosoft.dataaccess.dao.IVariedadDAO;
import co.com.arcosoft.dataaccess.dao.IVariedadNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.dto.VariedadDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("VariedadLogic")
public class VariedadLogic implements IVariedadLogic {
	private static final Logger log = LoggerFactory.getLogger(VariedadLogic.class);

	/**
	 * DAO injected by Spring that manages Variedad entities
	 *
	 */
	@Autowired
	private IVariedadDAO variedadDAO;

	/**
	 * DAO injected by Spring that manages VariedadNivel4 entities
	 *
	 */
	@Autowired
	private IVariedadNivel4DAO variedadNivel4DAO;

	/**
	 * Logic injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	ICultivoLogic logicCultivo1;

	@Override
	@Transactional(readOnly = true)
	public List<Variedad> getVariedad() throws Exception {
		log.debug("finding all Variedad instances");

		List<Variedad> list = new ArrayList<Variedad>();

		try {
			list = variedadDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Variedad failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Variedad");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVariedad(Variedad entity) throws Exception {
		log.debug("saving Variedad instance");

		try {
			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEdadCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadCosecha");
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

			if ((entity.getTipoMaduracion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoMaduracion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoMaduracion");
			}

			/*
			 * if (entity.getVariedId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("variedId"); }
			 * 
			 * if ((entity.getVariedId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getVariedId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("variedId"); }
			 * 
			 * if (getVariedad(entity.getVariedId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			variedadDAO.save(entity);

			log.debug("save Variedad successful");
		} catch (Exception e) {
			log.error("save Variedad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVariedad(Variedad entity) throws Exception {
		log.debug("deleting Variedad instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Variedad");
		}

		if (entity.getVariedId() == null) {
			throw new ZMessManager().new EmptyFieldException("variedId");
		}

		List<VariedadNivel4> variedadNivel4s = null;

		try {
			variedadNivel4s = variedadNivel4DAO.findByProperty("variedad.variedId", entity.getVariedId());

			if (Utilities.validationsList(variedadNivel4s) == true) {
				throw new ZMessManager().new DeletingException("variedadNivel4s");
			}

			variedadDAO.delete(entity);

			log.debug("delete Variedad successful");
		} catch (Exception e) {
			log.error("delete Variedad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVariedad(Variedad entity) throws Exception {
		log.debug("updating Variedad instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Variedad");
			}

			if (entity.getCultivo() == null) {
				throw new ZMessManager().new ForeignException("cultivo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEdadCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadCosecha");
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

			if ((entity.getTipoMaduracion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoMaduracion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoMaduracion");
			}

			if (entity.getVariedId() == null) {
				throw new ZMessManager().new EmptyFieldException("variedId");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			if (entity.getCultivo().getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId_Cultivo");
			}

			if ((entity.getCultivo().getCultivoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivo().getCultivoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId_Cultivo");
			}

			variedadDAO.update(entity);

			log.debug("update Variedad successful");
		} catch (Exception e) {
			log.error("update Variedad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<VariedadDTO> getDataVariedad() throws Exception {
		try {
			List<Variedad> variedad = variedadDAO.findAll();

			List<VariedadDTO> variedadDTO = new ArrayList<VariedadDTO>();

			for (Variedad variedadTmp : variedad) {
				VariedadDTO variedadDTO2 = new VariedadDTO();

				variedadDTO2.setVariedId(variedadTmp.getVariedId());
				variedadDTO2.setCodigo((variedadTmp.getCodigo() != null) ? variedadTmp.getCodigo() : null);
				variedadDTO2.setCompania((variedadTmp.getCompania() != null) ? variedadTmp.getCompania() : null);
				variedadDTO2
						.setEdadCosecha((variedadTmp.getEdadCosecha() != null) ? variedadTmp.getEdadCosecha() : null);
				variedadDTO2.setEstado((variedadTmp.getEstado() != null) ? variedadTmp.getEstado() : null);
				variedadDTO2.setFechaCreacion(variedadTmp.getFechaCreacion());
				variedadDTO2.setFechaModificacion(variedadTmp.getFechaModificacion());
				variedadDTO2.setInfoAdicional(
						(variedadTmp.getInfoAdicional() != null) ? variedadTmp.getInfoAdicional() : null);
				variedadDTO2.setInfoAdicional2(
						(variedadTmp.getInfoAdicional2() != null) ? variedadTmp.getInfoAdicional2() : null);
				variedadDTO2.setNombre((variedadTmp.getNombre() != null) ? variedadTmp.getNombre() : null);
				variedadDTO2.setTipoMaduracion(
						(variedadTmp.getTipoMaduracion() != null) ? variedadTmp.getTipoMaduracion() : null);

				if (variedadTmp.getCultivo() != null) {
					variedadDTO2.setCultivoId_Cultivo(variedadTmp.getCultivo().getCultivoId());
				} else {
					variedadDTO2.setCultivoId_Cultivo(null);
				}

				variedadDTO.add(variedadDTO2);
			}

			return variedadDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Variedad getVariedad(Long variedId) throws Exception {
		log.debug("getting Variedad instance");

		Variedad entity = null;

		try {
			entity = variedadDAO.findById(variedId);
		} catch (Exception e) {
			log.error("get Variedad failed", e);
			throw new ZMessManager().new FindingException("Variedad");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Variedad> findPageVariedad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Variedad> entity = null;

		try {
			entity = variedadDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Variedad Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberVariedad() throws Exception {
		Long entity = null;

		try {
			entity = variedadDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Variedad Count");
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
	public List<Variedad> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Variedad> list = new ArrayList<Variedad>();
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
			list = variedadDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
