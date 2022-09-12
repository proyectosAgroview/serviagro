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

import co.com.arcosoft.dataaccess.dao.ICultivoDAO;
import co.com.arcosoft.dataaccess.dao.ICultivoFitosanidadDAO;
import co.com.arcosoft.dataaccess.dao.IFitosanidadDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.CultivoFitosanidad;
import co.com.arcosoft.modelo.CultivoFitosanidadId;
import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.dto.FitosanidadDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("FitosanidadLogic")
public class FitosanidadLogic implements IFitosanidadLogic {
	private static final Logger log = LoggerFactory.getLogger(FitosanidadLogic.class);

	/**
	 * DAO injected by Spring that manages Fitosanidad entities
	 *
	 */
	@Autowired
	private IFitosanidadDAO fitosanidadDAO;

	/**
	 * DAO injected by Spring that manages CultivoFitosanidad entities
	 *
	 */
	@Autowired
	private ICultivoFitosanidadDAO cultivoFitosanidadDAO;

	@Autowired
	private ICultivoDAO cultivoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Fitosanidad> getFitosanidad() throws Exception {
		log.debug("finding all Fitosanidad instances");

		List<Fitosanidad> list = new ArrayList<Fitosanidad>();

		try {
			list = fitosanidadDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Fitosanidad failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Fitosanidad");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception {
		log.debug("saving Fitosanidad instance");

		try {
			if ((entity.getClaseFitosanidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseFitosanidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseFitosanidad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getFitosanidadId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "fitosanidadId"); }
			 * 
			 * if ((entity.getFitosanidadId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFitosanidadId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "fitosanidadId"); }
			 */

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNombreCientifico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombreCientifico(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombreCientifico");
			}

			if ((entity.getTipoFitosanidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoFitosanidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoFitosanidad");
			}

			/*
			 * if (getFitosanidad(entity.getFitosanidadId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			fitosanidadDAO.save(entity);

			for (String cultivo : selectedCultivos) {

				Long cultivoId = new Long(cultivo);

				Cultivo cul = cultivoDAO.findById(cultivoId);

				// Construir la llave primaria compuesta
				CultivoFitosanidadId cultivoFitosanidadId = new CultivoFitosanidadId();
				cultivoFitosanidadId.setCultivoId(cul.getCultivoId());
				cultivoFitosanidadId.setFitosanidadId(entity.getFitosanidadId());

				// Guardamos en la tabla Cultivo_Fitosanidad
				CultivoFitosanidad cultivoFitosanidad = new CultivoFitosanidad();
				cultivoFitosanidad.setCultivo(cul);
				cultivoFitosanidad.setFitosanidad(entity);
				cultivoFitosanidad.setId(cultivoFitosanidadId);

				cultivoFitosanidadDAO.save(cultivoFitosanidad);

			}

			log.debug("save Fitosanidad successful");
		} catch (Exception e) {
			log.error("save Fitosanidad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteFitosanidad(Fitosanidad entity) throws Exception {
		log.debug("deleting Fitosanidad instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Fitosanidad");
		}

		if (entity.getFitosanidadId() == null) {
			throw new ZMessManager().new EmptyFieldException("fitosanidadId");
		}

		List<CultivoFitosanidad> cultivoFitosanidads = null;

		try {
			cultivoFitosanidads = cultivoFitosanidadDAO.findByProperty("fitosanidad.fitosanidadId",
					entity.getFitosanidadId());

			if (Utilities.validationsList(cultivoFitosanidads) == true) {
				throw new ZMessManager().new DeletingException("cultivoFitosanidads");
			}

			fitosanidadDAO.delete(entity);

			log.debug("delete Fitosanidad successful");
		} catch (Exception e) {
			log.error("delete Fitosanidad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception {
		log.debug("updating Fitosanidad instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Fitosanidad");
			}

			if ((entity.getClaseFitosanidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseFitosanidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseFitosanidad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getFitosanidadId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "fitosanidadId"); }
			 * 
			 * if ((entity.getFitosanidadId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFitosanidadId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "fitosanidadId"); }
			 */

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNombreCientifico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombreCientifico(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombreCientifico");
			}

			if ((entity.getTipoFitosanidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoFitosanidad(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoFitosanidad");
			}

			fitosanidadDAO.update(entity);
			cultivoFitosanidadDAO.deleteByProperty("CultivoFitosanidad", "fitosanidad.fitosanidadId",
					entity.getFitosanidadId());

			for (String cultivo : selectedCultivos) {

				Long cultivoId = new Long(cultivo);

				Cultivo cul = cultivoDAO.findById(cultivoId);

				// Construir la llave primaria compuesta
				CultivoFitosanidadId cultivoFitosanidadId = new CultivoFitosanidadId();
				cultivoFitosanidadId.setCultivoId(cul.getCultivoId());
				cultivoFitosanidadId.setFitosanidadId(entity.getFitosanidadId());

				// Guardamos en la tabla Cultivo_Fitosanidad
				CultivoFitosanidad cultivoFitosanidad = new CultivoFitosanidad();
				cultivoFitosanidad.setCultivo(cul);
				cultivoFitosanidad.setFitosanidad(entity);
				cultivoFitosanidad.setId(cultivoFitosanidadId);

				cultivoFitosanidadDAO.save(cultivoFitosanidad);
			}

			log.debug("update Fitosanidad successful");
		} catch (Exception e) {
			log.error("update Fitosanidad failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<FitosanidadDTO> getDataFitosanidad() throws Exception {
		try {
			List<Fitosanidad> fitosanidad = fitosanidadDAO.findAll();
			List<FitosanidadDTO> fitosanidadDTO = new ArrayList<FitosanidadDTO>();

			for (Fitosanidad fitosanidadTmp : fitosanidad) {

				FitosanidadDTO fitosanidadDTO2 = new FitosanidadDTO();

				fitosanidadDTO2.setFitosanidadId(fitosanidadTmp.getFitosanidadId());
				fitosanidadDTO2.setClaseFitosanidad(
						(fitosanidadTmp.getClaseFitosanidad() != null) ? fitosanidadTmp.getClaseFitosanidad() : null);
				fitosanidadDTO2.setCodigo((fitosanidadTmp.getCodigo() != null) ? fitosanidadTmp.getCodigo() : null);
				fitosanidadDTO2
						.setCompania((fitosanidadTmp.getCompania() != null) ? fitosanidadDTO2.getCompania() : null);
				fitosanidadDTO2.setEstado((fitosanidadTmp.getEstado() != null) ? fitosanidadTmp.getEstado() : null);
				fitosanidadDTO2.setFechaCreacion(fitosanidadTmp.getFechaCreacion());
				fitosanidadDTO2.setFechaModificacion(fitosanidadTmp.getFechaModificacion());
				fitosanidadDTO2.setInfoAdicional(
						(fitosanidadTmp.getInfoAdicional() != null) ? fitosanidadTmp.getInfoAdicional() : null);
				fitosanidadDTO2.setInfoAdicional2(
						(fitosanidadTmp.getInfoAdicional2() != null) ? fitosanidadTmp.getInfoAdicional2() : null);
				fitosanidadDTO2.setNombre((fitosanidadTmp.getNombre() != null) ? fitosanidadTmp.getNombre() : null);
				fitosanidadDTO2.setNombreCientifico(
						(fitosanidadTmp.getNombreCientifico() != null) ? fitosanidadTmp.getNombreCientifico() : null);
				fitosanidadDTO2.setTipoFitosanidad(
						(fitosanidadTmp.getTipoFitosanidad() != null) ? fitosanidadTmp.getTipoFitosanidad() : null);

				Object[] cultivoFitosanidads = fitosanidadTmp.getCultivoFitosanidads().toArray();
				String cultivos = "";

				for (int i = 0; i < cultivoFitosanidads.length; i++) {

					CultivoFitosanidad cultivoFitosanidad = (CultivoFitosanidad) cultivoFitosanidads[i];
					cultivos += cultivoFitosanidad.getCultivo().getNombre() + " " + "\n";

				}

				fitosanidadDTO2.setCultivos(cultivos);
				fitosanidadDTO.add(fitosanidadDTO2);

			}

			return fitosanidadDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Fitosanidad getFitosanidad(Long fitosanidadId) throws Exception {
		log.debug("getting Fitosanidad instance");

		Fitosanidad entity = null;

		try {
			entity = fitosanidadDAO.findById(fitosanidadId);
		} catch (Exception e) {
			log.error("get Fitosanidad failed", e);
			throw new ZMessManager().new FindingException("Fitosanidad");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fitosanidad> findPageFitosanidad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Fitosanidad> entity = null;

		try {
			entity = fitosanidadDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Fitosanidad Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFitosanidad() throws Exception {
		Long entity = null;

		try {
			entity = fitosanidadDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Fitosanidad Count");
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
	public List<Fitosanidad> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Fitosanidad> list = new ArrayList<Fitosanidad>();
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
			list = fitosanidadDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
