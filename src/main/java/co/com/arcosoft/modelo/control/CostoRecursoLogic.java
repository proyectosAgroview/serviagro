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
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CostoRecurso;
import co.com.arcosoft.modelo.CostoRecursoId;
import co.com.arcosoft.modelo.dto.CostoRecursoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CostoRecursoLogic")
public class CostoRecursoLogic implements ICostoRecursoLogic {
	private static final Logger log = LoggerFactory.getLogger(CostoRecursoLogic.class);

	/**
	 * DAO injected by Spring that manages CostoRecurso entities
	 *
	 */
	@Autowired
	private ICostoRecursoDAO costoRecursoDAO;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto1;

	/**
	 * Logic injected by Spring that manages Recurso entities
	 *
	 */
	@Autowired
	IRecursoLogic logicRecurso2;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed3;

	@Override
	@Transactional(readOnly = true)
	public List<CostoRecurso> getCostoRecurso() throws Exception {
		log.debug("finding all CostoRecurso instances");

		List<CostoRecurso> list = new ArrayList<CostoRecurso>();

		try {
			list = costoRecursoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all CostoRecurso failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "CostoRecurso");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCostoRecurso(CostoRecurso entity) throws Exception {
		log.debug("saving CostoRecurso instance");

		try {
			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getRecurso() == null) {
				throw new ZMessManager().new ForeignException("recurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if (entity.getId().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getId().getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getId().getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId");
			}

			if ((entity.getId().getUdadMedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId");
			}

			if (entity.getId().getValorUnitEst() == null) {
				throw new ZMessManager().new EmptyFieldException("valorUnitEst");
			}

			if ((entity.getId().getValorUnitEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getValorUnitEst(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitEst");
			}

			if (entity.getId().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId");
			}

			if ((entity.getId().getElemCostoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getElemCostoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId");
			}

			if (entity.getId().getInfoAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional");
			}

			if ((entity.getId().getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if (entity.getId().getInfoAdicional2() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional2");
			}

			if ((entity.getId().getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getId().getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaCreacion");
			}

			if (entity.getId().getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaModificacion");
			}

			if (entity.getId().getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getId().getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if ((entity.getElementoCosto().getElemCostoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getElementoCosto().getElemCostoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			if (entity.getRecurso().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId_Recurso");
			}

			if ((entity.getRecurso().getRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecurso().getRecursoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId_Recurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (getCostoRecurso(entity.getId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			costoRecursoDAO.save(entity);

			log.debug("save CostoRecurso successful");
		} catch (Exception e) {
			log.error("save CostoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCostoRecurso(CostoRecurso entity) throws Exception {
		log.debug("deleting CostoRecurso instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CostoRecurso");
		}

		if (entity.getId().getRecursoId() == null) {
			throw new ZMessManager().new EmptyFieldException("recursoId");
		}

		if (entity.getId().getCompania() == null) {
			throw new ZMessManager().new EmptyFieldException("compania");
		}

		if (entity.getId().getUdadMedId() == null) {
			throw new ZMessManager().new EmptyFieldException("udadMedId");
		}

		if (entity.getId().getValorUnitEst() == null) {
			throw new ZMessManager().new EmptyFieldException("valorUnitEst");
		}

		if (entity.getId().getElemCostoId() == null) {
			throw new ZMessManager().new EmptyFieldException("elemCostoId");
		}

		if (entity.getId().getInfoAdicional() == null) {
			throw new ZMessManager().new EmptyFieldException("infoAdicional");
		}

		if (entity.getId().getInfoAdicional2() == null) {
			throw new ZMessManager().new EmptyFieldException("infoAdicional2");
		}

		if (entity.getId().getEstado() == null) {
			throw new ZMessManager().new EmptyFieldException("estado");
		}

		try {
			costoRecursoDAO.delete(entity);

			log.debug("delete CostoRecurso successful");
		} catch (Exception e) {
			log.error("delete CostoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCostoRecurso(CostoRecurso entity) throws Exception {
		log.debug("updating CostoRecurso instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("CostoRecurso");
			}

			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getRecurso() == null) {
				throw new ZMessManager().new ForeignException("recurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if (entity.getId().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId");
			}

			if ((entity.getId().getRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId");
			}

			if (entity.getId().getCompania() == null) {
				throw new ZMessManager().new EmptyFieldException("compania");
			}

			if ((entity.getId().getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getId().getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getId().getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId");
			}

			if ((entity.getId().getUdadMedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId");
			}

			if (entity.getId().getValorUnitEst() == null) {
				throw new ZMessManager().new EmptyFieldException("valorUnitEst");
			}

			if ((entity.getId().getValorUnitEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getValorUnitEst(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitEst");
			}

			if (entity.getId().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId");
			}

			if ((entity.getId().getElemCostoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId().getElemCostoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId");
			}

			if (entity.getId().getInfoAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional");
			}

			if ((entity.getId().getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if (entity.getId().getInfoAdicional2() == null) {
				throw new ZMessManager().new EmptyFieldException("infoAdicional2");
			}

			if ((entity.getId().getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getId().getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaCreacion");
			}

			if (entity.getId().getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaModificacion");
			}

			if (entity.getId().getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getId().getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getId().getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if ((entity.getElementoCosto().getElemCostoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getElementoCosto().getElemCostoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			if (entity.getRecurso().getRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("recursoId_Recurso");
			}

			if ((entity.getRecurso().getRecursoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRecurso().getRecursoId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("recursoId_Recurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			costoRecursoDAO.update(entity);

			log.debug("update CostoRecurso successful");
		} catch (Exception e) {
			log.error("update CostoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CostoRecursoDTO> getDataCostoRecurso() throws Exception {
		try {
			List<CostoRecurso> costoRecurso = costoRecursoDAO.findAll();

			List<CostoRecursoDTO> costoRecursoDTO = new ArrayList<CostoRecursoDTO>();

			for (CostoRecurso costoRecursoTmp : costoRecurso) {
				CostoRecursoDTO costoRecursoDTO2 = new CostoRecursoDTO();

				costoRecursoDTO2.setRecursoId(costoRecursoTmp.getId().getRecursoId());
				costoRecursoDTO2.setCompania(costoRecursoTmp.getId().getCompania());
				costoRecursoDTO2.setFechaInicial(costoRecursoTmp.getId().getFechaInicial());
				costoRecursoDTO2.setFechaFinal(costoRecursoTmp.getId().getFechaFinal());
				costoRecursoDTO2.setUdadMedId(costoRecursoTmp.getId().getUdadMedId());
				costoRecursoDTO2.setValorUnitEst(costoRecursoTmp.getId().getValorUnitEst());
				costoRecursoDTO2.setElemCostoId(costoRecursoTmp.getId().getElemCostoId());
				costoRecursoDTO2.setInfoAdicional(costoRecursoTmp.getId().getInfoAdicional());
				costoRecursoDTO2.setInfoAdicional2(costoRecursoTmp.getId().getInfoAdicional2());
				costoRecursoDTO2.setFechaCreacion(costoRecursoTmp.getId().getFechaCreacion());
				costoRecursoDTO2.setFechaModificacion(costoRecursoTmp.getId().getFechaModificacion());
				costoRecursoDTO2.setEstado(costoRecursoTmp.getId().getEstado());
				costoRecursoDTO2
						.setElemCostoId_ElementoCosto((costoRecursoTmp.getElementoCosto().getElemCostoId() != null)
								? costoRecursoTmp.getElementoCosto().getElemCostoId() : null);
				costoRecursoDTO2.setRecursoId_Recurso((costoRecursoTmp.getRecurso().getRecursoId() != null)
						? costoRecursoTmp.getRecurso().getRecursoId() : null);
				costoRecursoDTO2.setUdadMedId_UdadMed((costoRecursoTmp.getUdadMed().getUdadMedId() != null)
						? costoRecursoTmp.getUdadMed().getUdadMedId() : null);
				costoRecursoDTO.add(costoRecursoDTO2);
			}

			return costoRecursoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CostoRecurso getCostoRecurso(CostoRecursoId id) throws Exception {
		log.debug("getting CostoRecurso instance");

		CostoRecurso entity = null;

		try {
			entity = costoRecursoDAO.findById(id);
		} catch (Exception e) {
			log.error("get CostoRecurso failed", e);
			throw new ZMessManager().new FindingException("CostoRecurso");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CostoRecurso> findPageCostoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<CostoRecurso> entity = null;

		try {
			entity = costoRecursoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CostoRecurso Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCostoRecurso() throws Exception {
		Long entity = null;

		try {
			entity = costoRecursoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CostoRecurso Count");
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
	public List<CostoRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<CostoRecurso> list = new ArrayList<CostoRecurso>();
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
			list = costoRecursoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
