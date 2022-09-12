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

import co.com.arcosoft.dataaccess.dao.IDatTransProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IEmpaqueDAO;
import co.com.arcosoft.dataaccess.dao.IEmpaqueProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.EmpaqueProducto;
import co.com.arcosoft.modelo.dto.EmpaqueDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EmpaqueLogic")
public class EmpaqueLogic implements IEmpaqueLogic {
	private static final Logger log = LoggerFactory.getLogger(EmpaqueLogic.class);

	/**
	 * DAO injected by Spring that manages Empaque entities
	 *
	 */
	@Autowired
	private IEmpaqueDAO empaqueDAO;

	/**
	 * DAO injected by Spring that manages DatTransProdDet entities
	 *
	 */
	@Autowired
	private IDatTransProdDetDAO datTransProdDetDAO;

	/**
	 * DAO injected by Spring that manages EmpaqueProducto entities
	 *
	 */
	@Autowired
	private IEmpaqueProductoDAO empaqueProductoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Empaque> getEmpaque() throws Exception {
		log.debug("finding all Empaque instances");

		List<Empaque> list = new ArrayList<Empaque>();

		try {
			list = empaqueDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Empaque failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Empaque");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEmpaque(Empaque entity) throws Exception {
		log.debug("saving Empaque instance");

		try {
			if ((entity.getCapacidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidad");
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

			if ((entity.getTara() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTara(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tara");
			}

			if ((entity.getTolerancia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTolerancia(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tolerancia");
			}

			/*
			 * if (entity.getEmpaqueId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("empaqueId"); }
			 * 
			 * if ((entity.getEmpaqueId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEmpaqueId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "empaqueId"); } if
			 * (getEmpaque(entity.getEmpaqueId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			empaqueDAO.save(entity);

			log.debug("save Empaque successful");
		} catch (Exception e) {
			log.error("save Empaque failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEmpaque(Empaque entity) throws Exception {
		log.debug("deleting Empaque instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Empaque");
		}

		if (entity.getEmpaqueId() == null) {
			throw new ZMessManager().new EmptyFieldException("empaqueId");
		}

		List<DatTransProdDet> datTransProdDets = null;
		List<EmpaqueProducto> empaqueProductos = null;

		try {
			datTransProdDets = datTransProdDetDAO.findByProperty("empaque.empaqueId", entity.getEmpaqueId());

			if (Utilities.validationsList(datTransProdDets) == true) {
				throw new ZMessManager().new DeletingException("datTransProdDets");
			}

			empaqueProductos = empaqueProductoDAO.findByProperty("empaque.empaqueId", entity.getEmpaqueId());

			if (Utilities.validationsList(empaqueProductos) == true) {
				throw new ZMessManager().new DeletingException("empaqueProductos");
			}

			empaqueDAO.delete(entity);

			log.debug("delete Empaque successful");
		} catch (Exception e) {
			log.error("delete Empaque failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEmpaque(Empaque entity) throws Exception {
		log.debug("updating Empaque instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Empaque");
			}

			if ((entity.getCapacidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCapacidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("capacidad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getEmpaqueId() == null) {
				throw new ZMessManager().new EmptyFieldException("empaqueId");
			}

			if ((entity.getEmpaqueId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpaqueId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empaqueId");
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

			if ((entity.getTara() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTara(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tara");
			}

			if ((entity.getTolerancia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTolerancia(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tolerancia");
			}

			empaqueDAO.update(entity);

			log.debug("update Empaque successful");
		} catch (Exception e) {
			log.error("update Empaque failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmpaqueDTO> getDataEmpaque() throws Exception {
		try {
			List<Empaque> empaque = empaqueDAO.findAll();

			List<EmpaqueDTO> empaqueDTO = new ArrayList<EmpaqueDTO>();

			for (Empaque empaqueTmp : empaque) {
				EmpaqueDTO empaqueDTO2 = new EmpaqueDTO();

				empaqueDTO2.setEmpaqueId(empaqueTmp.getEmpaqueId());
				empaqueDTO2.setCapacidad((empaqueTmp.getCapacidad() != null) ? empaqueTmp.getCapacidad() : null);
				empaqueDTO2.setCodigo((empaqueTmp.getCodigo() != null) ? empaqueTmp.getCodigo() : null);
				empaqueDTO2.setCompania((empaqueTmp.getCompania() != null) ? empaqueTmp.getCompania() : null);
				empaqueDTO2.setEstado((empaqueTmp.getEstado() != null) ? empaqueTmp.getEstado() : null);
				empaqueDTO2.setFechaCreacion(empaqueTmp.getFechaCreacion());
				empaqueDTO2.setFechaModificacion(empaqueTmp.getFechaModificacion());
				empaqueDTO2.setInfoAdicional(
						(empaqueTmp.getInfoAdicional() != null) ? empaqueTmp.getInfoAdicional() : null);
				empaqueDTO2.setInfoAdicional2(
						(empaqueTmp.getInfoAdicional2() != null) ? empaqueTmp.getInfoAdicional2() : null);
				empaqueDTO2.setNombre((empaqueTmp.getNombre() != null) ? empaqueTmp.getNombre() : null);
				empaqueDTO2.setTara((empaqueTmp.getTara() != null) ? empaqueTmp.getTara() : null);
				empaqueDTO2.setTolerancia((empaqueTmp.getTolerancia() != null) ? empaqueTmp.getTolerancia() : null);
				empaqueDTO.add(empaqueDTO2);
			}

			return empaqueDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Empaque getEmpaque(Long empaqueId) throws Exception {
		log.debug("getting Empaque instance");

		Empaque entity = null;

		try {
			entity = empaqueDAO.findById(empaqueId);
		} catch (Exception e) {
			log.error("get Empaque failed", e);
			throw new ZMessManager().new FindingException("Empaque");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empaque> findPageEmpaque(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Empaque> entity = null;

		try {
			entity = empaqueDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Empaque Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEmpaque() throws Exception {
		Long entity = null;

		try {
			entity = empaqueDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Empaque Count");
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
	public List<Empaque> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Empaque> list = new ArrayList<Empaque>();
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
			list = empaqueDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
