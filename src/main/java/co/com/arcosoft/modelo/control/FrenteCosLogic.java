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

import co.com.arcosoft.dataaccess.dao.IDatTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IFrenteCosDAO;
import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.dto.FrenteCosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("FrenteCosLogic")
public class FrenteCosLogic implements IFrenteCosLogic {
	private static final Logger log = LoggerFactory.getLogger(FrenteCosLogic.class);

	/**
	 * DAO injected by Spring that manages FrenteCos entities
	 *
	 */
	@Autowired
	private IFrenteCosDAO frenteCosDAO;

	/**
	 * DAO injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	private IDatTransProdDAO datTransProdDAO;

	/**
	 * DAO injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	private INivel2DAO nivel2DAO;

	@Override
	@Transactional(readOnly = true)
	public List<FrenteCos> getFrenteCos() throws Exception {
		log.debug("finding all FrenteCos instances");

		List<FrenteCos> list = new ArrayList<FrenteCos>();

		try {
			list = frenteCosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all FrenteCos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "FrenteCos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveFrenteCos(FrenteCos entity) throws Exception {
		log.debug("saving FrenteCos instance");

		try {
			if ((entity.getCapacidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
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

			if ((entity.getTipo() != null) && (Utilities.checkWordAndCheckWithlength(entity.getTipo(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipo");
			}

			/*
			 * if (entity.getFrtCosId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("frtCosId"); }
			 * 
			 * if ((entity.getFrtCosId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFrtCosId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("frtCosId"); }
			 * 
			 * if (getFrenteCos(entity.getFrtCosId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			frenteCosDAO.save(entity);

			log.debug("save FrenteCos successful");
		} catch (Exception e) {
			log.error("save FrenteCos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteFrenteCos(FrenteCos entity) throws Exception {
		log.debug("deleting FrenteCos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("FrenteCos");
		}

		if (entity.getFrtCosId() == null) {
			throw new ZMessManager().new EmptyFieldException("frtCosId");
		}

		List<DatTransProd> datTransProds = null;
		List<Nivel2> nivel2s = null;

		try {
			datTransProds = datTransProdDAO.findByProperty("frenteCos.frtCosId", entity.getFrtCosId());

			if (Utilities.validationsList(datTransProds) == true) {
				throw new ZMessManager().new DeletingException("datTransProds");
			}

			nivel2s = nivel2DAO.findByProperty("frenteCos.frtCosId", entity.getFrtCosId());

			if (Utilities.validationsList(nivel2s) == true) {
				throw new ZMessManager().new DeletingException("nivel2s");
			}

			frenteCosDAO.delete(entity);

			log.debug("delete FrenteCos successful");
		} catch (Exception e) {
			log.error("delete FrenteCos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateFrenteCos(FrenteCos entity) throws Exception {
		log.debug("updating FrenteCos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("FrenteCos");
			}

			if ((entity.getCapacidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if (entity.getFrtCosId() == null) {
				throw new ZMessManager().new EmptyFieldException("frtCosId");
			}

			if ((entity.getFrtCosId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFrtCosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("frtCosId");
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

			if ((entity.getTipo() != null) && (Utilities.checkWordAndCheckWithlength(entity.getTipo(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipo");
			}

			frenteCosDAO.update(entity);

			log.debug("update FrenteCos successful");
		} catch (Exception e) {
			log.error("update FrenteCos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<FrenteCosDTO> getDataFrenteCos() throws Exception {
		try {
			List<FrenteCos> frenteCos = frenteCosDAO.findAll();

			List<FrenteCosDTO> frenteCosDTO = new ArrayList<FrenteCosDTO>();

			for (FrenteCos frenteCosTmp : frenteCos) {
				FrenteCosDTO frenteCosDTO2 = new FrenteCosDTO();

				frenteCosDTO2.setFrtCosId(frenteCosTmp.getFrtCosId());
				frenteCosDTO2.setCapacidad((frenteCosTmp.getCapacidad() != null) ? frenteCosTmp.getCapacidad() : null);
				frenteCosDTO2.setCodigo((frenteCosTmp.getCodigo() != null) ? frenteCosTmp.getCodigo() : null);
				frenteCosDTO2.setColor((frenteCosTmp.getColor() != null) ? frenteCosTmp.getColor() : null);
				frenteCosDTO2.setCompania((frenteCosTmp.getCompania() != null) ? frenteCosTmp.getCompania() : null);
				frenteCosDTO2.setEstado((frenteCosTmp.getEstado() != null) ? frenteCosTmp.getEstado() : null);
				frenteCosDTO2.setFechaCreacion(frenteCosTmp.getFechaCreacion());
				frenteCosDTO2.setFechaModificacion(frenteCosTmp.getFechaModificacion());
				frenteCosDTO2.setInfoAdicional(
						(frenteCosTmp.getInfoAdicional() != null) ? frenteCosTmp.getInfoAdicional() : null);
				frenteCosDTO2.setInfoAdicional2(
						(frenteCosTmp.getInfoAdicional2() != null) ? frenteCosTmp.getInfoAdicional2() : null);
				frenteCosDTO2.setNombre((frenteCosTmp.getNombre() != null) ? frenteCosTmp.getNombre() : null);
				frenteCosDTO2.setTipo((frenteCosTmp.getTipo() != null) ? frenteCosTmp.getTipo() : null);
				frenteCosDTO.add(frenteCosDTO2);
			}

			return frenteCosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FrenteCos getFrenteCos(Long frtCosId) throws Exception {
		log.debug("getting FrenteCos instance");

		FrenteCos entity = null;

		try {
			entity = frenteCosDAO.findById(frtCosId);
		} catch (Exception e) {
			log.error("get FrenteCos failed", e);
			throw new ZMessManager().new FindingException("FrenteCos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FrenteCos> findPageFrenteCos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<FrenteCos> entity = null;

		try {
			entity = frenteCosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FrenteCos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFrenteCos() throws Exception {
		Long entity = null;

		try {
			entity = frenteCosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FrenteCos Count");
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
	public List<FrenteCos> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<FrenteCos> list = new ArrayList<FrenteCos>();
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
			list = frenteCosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
