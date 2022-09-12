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

import co.com.arcosoft.dataaccess.dao.IFabricanteEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IModeloEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IVehiculosTranspDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.FabricanteEquipo;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.FabricanteEquipoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("FabricanteEquipoLogic")
public class FabricanteEquipoLogic implements IFabricanteEquipoLogic {
	private static final Logger log = LoggerFactory.getLogger(FabricanteEquipoLogic.class);

	/**
	 * DAO injected by Spring that manages FabricanteEquipo entities
	 *
	 */
	@Autowired
	private IFabricanteEquipoDAO fabricanteEquipoDAO;

	/**
	 * DAO injected by Spring that manages ModeloEquipo entities
	 *
	 */
	@Autowired
	private IModeloEquipoDAO modeloEquipoDAO;

	/**
	 * DAO injected by Spring that manages VehiculosTransp entities
	 *
	 */
	@Autowired
	private IVehiculosTranspDAO vehiculosTranspDAO;

	@Override
	@Transactional(readOnly = true)
	public List<FabricanteEquipo> getFabricanteEquipo() throws Exception {
		log.debug("finding all FabricanteEquipo instances");

		List<FabricanteEquipo> list = new ArrayList<FabricanteEquipo>();

		try {
			list = fabricanteEquipoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all FabricanteEquipo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "FabricanteEquipo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		log.debug("saving FabricanteEquipo instance");

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

			/*
			 * if (entity.getFabricEquipId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "fabricEquipId"); }
			 * 
			 * if ((entity.getFabricEquipId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFabricEquipId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "fabricEquipId"); }
			 * 
			 * if (getFabricanteEquipo(entity.getFabricEquipId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			fabricanteEquipoDAO.save(entity);

			log.debug("save FabricanteEquipo successful");
		} catch (Exception e) {
			log.error("save FabricanteEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		log.debug("deleting FabricanteEquipo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("FabricanteEquipo");
		}

		if (entity.getFabricEquipId() == null) {
			throw new ZMessManager().new EmptyFieldException("fabricEquipId");
		}

		List<ModeloEquipo> modeloEquipos = null;
		List<VehiculosTransp> vehiculosTransps = null;

		try {
			modeloEquipos = modeloEquipoDAO.findByProperty("fabricanteEquipo.fabricEquipId", entity.getFabricEquipId());

			if (Utilities.validationsList(modeloEquipos) == true) {
				throw new ZMessManager().new DeletingException("modeloEquipos");
			}

			vehiculosTransps = vehiculosTranspDAO.findByProperty("fabricanteEquipo.fabricEquipId",
					entity.getFabricEquipId());

			if (Utilities.validationsList(vehiculosTransps) == true) {
				throw new ZMessManager().new DeletingException("vehiculosTransps");
			}

			fabricanteEquipoDAO.delete(entity);

			log.debug("delete FabricanteEquipo successful");
		} catch (Exception e) {
			log.error("delete FabricanteEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		log.debug("updating FabricanteEquipo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("FabricanteEquipo");
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

			if (entity.getFabricEquipId() == null) {
				throw new ZMessManager().new EmptyFieldException("fabricEquipId");
			}

			if ((entity.getFabricEquipId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFabricEquipId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fabricEquipId");
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

			fabricanteEquipoDAO.update(entity);

			log.debug("update FabricanteEquipo successful");
		} catch (Exception e) {
			log.error("update FabricanteEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<FabricanteEquipoDTO> getDataFabricanteEquipo() throws Exception {
		try {
			List<FabricanteEquipo> fabricanteEquipo = fabricanteEquipoDAO.findAll();

			List<FabricanteEquipoDTO> fabricanteEquipoDTO = new ArrayList<FabricanteEquipoDTO>();

			for (FabricanteEquipo fabricanteEquipoTmp : fabricanteEquipo) {
				FabricanteEquipoDTO fabricanteEquipoDTO2 = new FabricanteEquipoDTO();

				fabricanteEquipoDTO2.setFabricEquipId(fabricanteEquipoTmp.getFabricEquipId());
				fabricanteEquipoDTO2
						.setCodigo((fabricanteEquipoTmp.getCodigo() != null) ? fabricanteEquipoTmp.getCodigo() : null);
				fabricanteEquipoDTO2.setCompania(
						(fabricanteEquipoTmp.getCompania() != null) ? fabricanteEquipoTmp.getCompania() : null);
				fabricanteEquipoDTO2
						.setEstado((fabricanteEquipoTmp.getEstado() != null) ? fabricanteEquipoTmp.getEstado() : null);
				fabricanteEquipoDTO2.setFechaCreacion(fabricanteEquipoTmp.getFechaCreacion());
				fabricanteEquipoDTO2.setFechaModificacion(fabricanteEquipoTmp.getFechaModificacion());
				fabricanteEquipoDTO2.setInfoAdicional((fabricanteEquipoTmp.getInfoAdicional() != null)
						? fabricanteEquipoTmp.getInfoAdicional() : null);
				fabricanteEquipoDTO2.setInfoAdicional2((fabricanteEquipoTmp.getInfoAdicional2() != null)
						? fabricanteEquipoTmp.getInfoAdicional2() : null);
				fabricanteEquipoDTO2
						.setNombre((fabricanteEquipoTmp.getNombre() != null) ? fabricanteEquipoTmp.getNombre() : null);
				fabricanteEquipoDTO.add(fabricanteEquipoDTO2);
			}

			return fabricanteEquipoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FabricanteEquipo getFabricanteEquipo(Long fabricEquipId) throws Exception {
		log.debug("getting FabricanteEquipo instance");

		FabricanteEquipo entity = null;

		try {
			entity = fabricanteEquipoDAO.findById(fabricEquipId);
		} catch (Exception e) {
			log.error("get FabricanteEquipo failed", e);
			throw new ZMessManager().new FindingException("FabricanteEquipo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FabricanteEquipo> findPageFabricanteEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<FabricanteEquipo> entity = null;

		try {
			entity = fabricanteEquipoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FabricanteEquipo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberFabricanteEquipo() throws Exception {
		Long entity = null;

		try {
			entity = fabricanteEquipoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("FabricanteEquipo Count");
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
	public List<FabricanteEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<FabricanteEquipo> list = new ArrayList<FabricanteEquipo>();
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
			list = fabricanteEquipoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
