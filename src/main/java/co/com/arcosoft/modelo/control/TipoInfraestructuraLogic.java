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

import co.com.arcosoft.dataaccess.dao.IInfraestructuraDAO;
import co.com.arcosoft.dataaccess.dao.ITipoInfraestructuraDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.TipoInfraestructura;
import co.com.arcosoft.modelo.dto.TipoInfraestructuraDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoInfraestructuraLogic")
public class TipoInfraestructuraLogic implements ITipoInfraestructuraLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoInfraestructuraLogic.class);

	/**
	 * DAO injected by Spring that manages TipoInfraestructura entities
	 *
	 */
	@Autowired
	private ITipoInfraestructuraDAO tipoInfraestructuraDAO;

	/**
	 * DAO injected by Spring that manages Infraestructura entities
	 *
	 */
	@Autowired
	private IInfraestructuraDAO infraestructuraDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoInfraestructura> getTipoInfraestructura() throws Exception {
		log.debug("finding all TipoInfraestructura instances");

		List<TipoInfraestructura> list = new ArrayList<TipoInfraestructura>();

		try {
			list = tipoInfraestructuraDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoInfraestructura failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoInfraestructura");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		log.debug("saving TipoInfraestructura instance");

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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			/*
			 * if (entity.getTipoInfraId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("tipoInfraId"); }
			 * 
			 * if ((entity.getTipoInfraId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoInfraId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "tipoInfraId"); }
			 * 
			 * if (getTipoInfraestructura(entity.getTipoInfraId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			tipoInfraestructuraDAO.save(entity);

			log.debug("save TipoInfraestructura successful");
		} catch (Exception e) {
			log.error("save TipoInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		log.debug("deleting TipoInfraestructura instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoInfraestructura");
		}

		if (entity.getTipoInfraId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoInfraId");
		}

		List<Infraestructura> infraestructuras = null;

		try {
			infraestructuras = infraestructuraDAO.findByProperty("tipoInfraestructura.tipoInfraId",
					entity.getTipoInfraId());

			if (Utilities.validationsList(infraestructuras) == true) {
				throw new ZMessManager().new DeletingException("infraestructuras");
			}

			tipoInfraestructuraDAO.delete(entity);

			log.debug("delete TipoInfraestructura successful");
		} catch (Exception e) {
			log.error("delete TipoInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		log.debug("updating TipoInfraestructura instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoInfraestructura");
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

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if (entity.getTipoInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoInfraId");
			}

			if ((entity.getTipoInfraId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTipoInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoInfraId");
			}

			tipoInfraestructuraDAO.update(entity);

			log.debug("update TipoInfraestructura successful");
		} catch (Exception e) {
			log.error("update TipoInfraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoInfraestructuraDTO> getDataTipoInfraestructura() throws Exception {
		try {
			List<TipoInfraestructura> tipoInfraestructura = tipoInfraestructuraDAO.findAll();

			List<TipoInfraestructuraDTO> tipoInfraestructuraDTO = new ArrayList<TipoInfraestructuraDTO>();

			for (TipoInfraestructura tipoInfraestructuraTmp : tipoInfraestructura) {
				TipoInfraestructuraDTO tipoInfraestructuraDTO2 = new TipoInfraestructuraDTO();

				tipoInfraestructuraDTO2.setTipoInfraId(tipoInfraestructuraTmp.getTipoInfraId());
				tipoInfraestructuraDTO2.setCodigo(
						(tipoInfraestructuraTmp.getCodigo() != null) ? tipoInfraestructuraTmp.getCodigo() : null);
				tipoInfraestructuraDTO2.setCompania(
						(tipoInfraestructuraTmp.getCompania() != null) ? tipoInfraestructuraTmp.getCompania() : null);
				tipoInfraestructuraDTO2.setEstado(
						(tipoInfraestructuraTmp.getEstado() != null) ? tipoInfraestructuraTmp.getEstado() : null);
				tipoInfraestructuraDTO2.setFechaCreacion(tipoInfraestructuraTmp.getFechaCreacion());
				tipoInfraestructuraDTO2.setFechaModificacion(tipoInfraestructuraTmp.getFechaModificacion());
				tipoInfraestructuraDTO2.setInfoAdicional((tipoInfraestructuraTmp.getInfoAdicional() != null)
						? tipoInfraestructuraTmp.getInfoAdicional() : null);
				tipoInfraestructuraDTO2.setInfoAdicional2((tipoInfraestructuraTmp.getInfoAdicional2() != null)
						? tipoInfraestructuraTmp.getInfoAdicional2() : null);
				tipoInfraestructuraDTO2.setNombre(
						(tipoInfraestructuraTmp.getNombre() != null) ? tipoInfraestructuraTmp.getNombre() : null);
				tipoInfraestructuraDTO2.setObservacion((tipoInfraestructuraTmp.getObservacion() != null)
						? tipoInfraestructuraTmp.getObservacion() : null);
				tipoInfraestructuraDTO.add(tipoInfraestructuraDTO2);
			}

			return tipoInfraestructuraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoInfraestructura getTipoInfraestructura(Long tipoInfraId) throws Exception {
		log.debug("getting TipoInfraestructura instance");

		TipoInfraestructura entity = null;

		try {
			entity = tipoInfraestructuraDAO.findById(tipoInfraId);
		} catch (Exception e) {
			log.error("get TipoInfraestructura failed", e);
			throw new ZMessManager().new FindingException("TipoInfraestructura");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoInfraestructura> findPageTipoInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TipoInfraestructura> entity = null;

		try {
			entity = tipoInfraestructuraDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoInfraestructura Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoInfraestructura() throws Exception {
		Long entity = null;

		try {
			entity = tipoInfraestructuraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoInfraestructura Count");
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
	public List<TipoInfraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoInfraestructura> list = new ArrayList<TipoInfraestructura>();
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
			list = tipoInfraestructuraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
