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

import co.com.arcosoft.dataaccess.dao.IConceptoNominaDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDAO;
import co.com.arcosoft.dataaccess.dao.ILimiteCeptoNominaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.LimiteCeptoNomina;
import co.com.arcosoft.modelo.dto.ConceptoNominaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ConceptoNominaLogic")
public class ConceptoNominaLogic implements IConceptoNominaLogic {
	private static final Logger log = LoggerFactory.getLogger(ConceptoNominaLogic.class);

	/**
	 * DAO injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	private IConceptoNominaDAO conceptoNominaDAO;

	/**
	 * DAO injected by Spring that manages DatPlanillaNomina entities
	 *
	 */
	@Autowired
	private IDatPlanillaNominaDAO datPlanillaNominaDAO;

	/**
	 * DAO injected by Spring that manages LimiteCeptoNomina entities
	 *
	 */
	@Autowired
	private ILimiteCeptoNominaDAO limiteCeptoNominaDAO;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto1;

	@Override
	@Transactional(readOnly = true)
	public List<ConceptoNomina> getConceptoNomina() throws Exception {
		log.debug("finding all ConceptoNomina instances");

		List<ConceptoNomina> list = new ArrayList<ConceptoNomina>();

		try {
			list = conceptoNominaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ConceptoNomina failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ConceptoNomina");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveConceptoNomina(ConceptoNomina entity) throws Exception {
		log.debug("saving ConceptoNomina instance");

		try {
			/*
			 * if (entity.getElementoCosto() == null) { throw new
			 * ZMessManager().new ForeignException("elementoCosto"); }
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

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (entity.getElementoCosto().getElemCostoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "elemCostoId_ElementoCosto"); }
			 */

			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			/*
			 * if (entity.getCeptoNominaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ceptoNominaId"); }
			 * 
			 * if ((entity.getCeptoNominaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCeptoNominaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "ceptoNominaId"); }
			 * 
			 * if (getConceptoNomina(entity.getCeptoNominaId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			conceptoNominaDAO.save(entity);

			log.debug("save ConceptoNomina successful");
		} catch (Exception e) {
			log.error("save ConceptoNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteConceptoNomina(ConceptoNomina entity) throws Exception {
		log.debug("deleting ConceptoNomina instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ConceptoNomina");
		}

		if (entity.getCeptoNominaId() == null) {
			throw new ZMessManager().new EmptyFieldException("ceptoNominaId");
		}

		List<DatPlanillaNomina> datPlanillaNominas = null;
		List<LimiteCeptoNomina> limiteCeptoNominas = null;

		try {
			datPlanillaNominas = datPlanillaNominaDAO.findByProperty("conceptoNomina.ceptoNominaId",
					entity.getCeptoNominaId());

			if (Utilities.validationsList(datPlanillaNominas) == true) {
				throw new ZMessManager().new DeletingException("datPlanillaNominas");
			}

			limiteCeptoNominas = limiteCeptoNominaDAO.findByProperty("conceptoNomina.ceptoNominaId",
					entity.getCeptoNominaId());

			if (Utilities.validationsList(limiteCeptoNominas) == true) {
				throw new ZMessManager().new DeletingException("limiteCeptoNominas");
			}

			conceptoNominaDAO.delete(entity);

			log.debug("delete ConceptoNomina successful");
		} catch (Exception e) {
			log.error("delete ConceptoNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateConceptoNomina(ConceptoNomina entity) throws Exception {
		log.debug("updating ConceptoNomina instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ConceptoNomina");
			}

			/*
			 * if (entity.getElementoCosto() == null) { throw new
			 * ZMessManager().new ForeignException("elementoCosto"); }
			 */

			if (entity.getCeptoNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId");
			}

			if ((entity.getCeptoNominaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCeptoNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ceptoNominaId");
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

			/*
			 * if (entity.getElementoCosto() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "elemCostoId_ElementoCosto"); }
			 */
			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			conceptoNominaDAO.update(entity);

			log.debug("update ConceptoNomina successful");
		} catch (Exception e) {
			log.error("update ConceptoNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConceptoNominaDTO> getDataConceptoNomina() throws Exception {
		try {
			List<ConceptoNomina> conceptoNomina = conceptoNominaDAO.findAll();

			List<ConceptoNominaDTO> conceptoNominaDTO = new ArrayList<ConceptoNominaDTO>();

			for (ConceptoNomina conceptoNominaTmp : conceptoNomina) {
				ConceptoNominaDTO conceptoNominaDTO2 = new ConceptoNominaDTO();

				conceptoNominaDTO2.setCeptoNominaId(conceptoNominaTmp.getCeptoNominaId());
				conceptoNominaDTO2
						.setCodigo((conceptoNominaTmp.getCodigo() != null) ? conceptoNominaTmp.getCodigo() : null);
				conceptoNominaDTO2.setCompania(
						(conceptoNominaTmp.getCompania() != null) ? conceptoNominaTmp.getCompania() : null);
				conceptoNominaDTO2
						.setEstado((conceptoNominaTmp.getEstado() != null) ? conceptoNominaTmp.getEstado() : null);
				conceptoNominaDTO2.setFechaCreacion(conceptoNominaTmp.getFechaCreacion());
				conceptoNominaDTO2.setFechaModificacion(conceptoNominaTmp.getFechaModificacion());
				conceptoNominaDTO2.setInfoAdicional(
						(conceptoNominaTmp.getInfoAdicional() != null) ? conceptoNominaTmp.getInfoAdicional() : null);
				conceptoNominaDTO2.setInfoAdicional2(
						(conceptoNominaTmp.getInfoAdicional2() != null) ? conceptoNominaTmp.getInfoAdicional2() : null);
				conceptoNominaDTO2
						.setNombre((conceptoNominaTmp.getNombre() != null) ? conceptoNominaTmp.getNombre() : null);
				conceptoNominaDTO2.setElemCostoId_ElementoCosto(
						(conceptoNominaTmp.getElementoCosto() != null) ? conceptoNominaTmp.getElementoCosto() : null);
				conceptoNominaDTO2.setCuentaContable(
						(conceptoNominaTmp.getCuentaContable() != null) ? conceptoNominaTmp.getCuentaContable() : null);
				
				conceptoNominaDTO2.setCeptoNominaId(
						(conceptoNominaTmp.getCeptoNominaId() != null) ? conceptoNominaTmp.getCeptoNominaId() : null);
				
				conceptoNominaDTO2.setTipoConcepto(
						(conceptoNominaTmp.getTipoConcepto() != null) ? conceptoNominaTmp.getTipoConcepto() : null);
				
				
				conceptoNominaDTO.add(conceptoNominaDTO2);
			}

			return conceptoNominaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ConceptoNomina getConceptoNomina(Long ceptoNominaId) throws Exception {
		log.debug("getting ConceptoNomina instance");

		ConceptoNomina entity = null;

		try {
			entity = conceptoNominaDAO.findById(ceptoNominaId);
		} catch (Exception e) {
			log.error("get ConceptoNomina failed", e);
			throw new ZMessManager().new FindingException("ConceptoNomina");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConceptoNomina> findPageConceptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ConceptoNomina> entity = null;

		try {
			entity = conceptoNominaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ConceptoNomina Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberConceptoNomina() throws Exception {
		Long entity = null;

		try {
			entity = conceptoNominaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ConceptoNomina Count");
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
	public List<ConceptoNomina> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ConceptoNomina> list = new ArrayList<ConceptoNomina>();
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
			list = conceptoNominaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
