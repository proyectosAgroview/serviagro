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

import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatOtrosCostosNivel4;
import co.com.arcosoft.modelo.dto.DatOtrosCostosNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatOtrosCostosNivel4Logic")
public class DatOtrosCostosNivel4Logic implements IDatOtrosCostosNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages DatOtrosCostosNivel4 entities
	 *
	 */
	@Autowired
	private IDatOtrosCostosNivel4DAO datOtrosCostosNivel4DAO;

	/**
	 * Logic injected by Spring that manages DatOtrosCostos entities
	 *
	 */
	@Autowired
	IDatOtrosCostosLogic logicDatOtrosCostos1;

	/**
	 * Logic injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	INivel2Logic logicNivel22;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel43;

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostosNivel4> getDatOtrosCostosNivel4() throws Exception {
		log.debug("finding all DatOtrosCostosNivel4 instances");

		List<DatOtrosCostosNivel4> list = new ArrayList<DatOtrosCostosNivel4>();

		try {
			list = datOtrosCostosNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatOtrosCostosNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatOtrosCostosNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		log.debug("saving DatOtrosCostosNivel4 instance");

		try {
			if (entity.getDatOtrosCostos() == null) {
				throw new ZMessManager().new ForeignException("datOtrosCostos");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getDatOtrosCostosNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosNivel4Id");
			}

			if ((entity.getDatOtrosCostosNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatOtrosCostosNivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosNivel4Id");
			}

			if (entity.getDatOtrosCostos().getDatOtrosCostosId() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosId_DatOtrosCostos");
			}

			if ((entity.getDatOtrosCostos().getDatOtrosCostosId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatOtrosCostos().getDatOtrosCostosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosId_DatOtrosCostos");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (getDatOtrosCostosNivel4(entity.getDatOtrosCostosNivel4Id()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datOtrosCostosNivel4DAO.save(entity);

			log.debug("save DatOtrosCostosNivel4 successful");
		} catch (Exception e) {
			log.error("save DatOtrosCostosNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		log.debug("deleting DatOtrosCostosNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostosNivel4");
		}

		if (entity.getDatOtrosCostosNivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("datOtrosCostosNivel4Id");
		}

		try {
			datOtrosCostosNivel4DAO.delete(entity);

			log.debug("delete DatOtrosCostosNivel4 successful");
		} catch (Exception e) {
			log.error("delete DatOtrosCostosNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		log.debug("updating DatOtrosCostosNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostosNivel4");
			}

			if (entity.getDatOtrosCostos() == null) {
				throw new ZMessManager().new ForeignException("datOtrosCostos");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getDatOtrosCostosNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosNivel4Id");
			}

			if ((entity.getDatOtrosCostosNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatOtrosCostosNivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosNivel4Id");
			}

			if (entity.getDatOtrosCostos().getDatOtrosCostosId() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosId_DatOtrosCostos");
			}

			if ((entity.getDatOtrosCostos().getDatOtrosCostosId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatOtrosCostos().getDatOtrosCostosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosId_DatOtrosCostos");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			datOtrosCostosNivel4DAO.update(entity);

			log.debug("update DatOtrosCostosNivel4 successful");
		} catch (Exception e) {
			log.error("update DatOtrosCostosNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4() throws Exception {
		try {
			List<DatOtrosCostosNivel4> datOtrosCostosNivel4 = datOtrosCostosNivel4DAO.findAll();

			List<DatOtrosCostosNivel4DTO> datOtrosCostosNivel4DTO = new ArrayList<DatOtrosCostosNivel4DTO>();

			for (DatOtrosCostosNivel4 datOtrosCostosNivel4Tmp : datOtrosCostosNivel4) {
				DatOtrosCostosNivel4DTO datOtrosCostosNivel4DTO2 = new DatOtrosCostosNivel4DTO();

				datOtrosCostosNivel4DTO2.setDatOtrosCostosNivel4Id(datOtrosCostosNivel4Tmp.getDatOtrosCostosNivel4Id());
				datOtrosCostosNivel4DTO2.setDatOtrosCostosId_DatOtrosCostos(
						(datOtrosCostosNivel4Tmp.getDatOtrosCostos().getDatOtrosCostosId() != null)
								? datOtrosCostosNivel4Tmp.getDatOtrosCostos().getDatOtrosCostosId() : null);
				
				datOtrosCostosNivel4DTO2.setEtapaId((datOtrosCostosNivel4Tmp.getEtapaId() != null)
								? datOtrosCostosNivel4Tmp.getEtapaId() : null);
				datOtrosCostosNivel4DTO2.setVariedId((datOtrosCostosNivel4Tmp.getVariedId() != null)
						? datOtrosCostosNivel4Tmp.getVariedId() : null);

				if (datOtrosCostosNivel4Tmp.getNivel2() != null) {
					datOtrosCostosNivel4DTO2.setNivel2Id_Nivel2(datOtrosCostosNivel4Tmp.getNivel2());
				} else {
					datOtrosCostosNivel4DTO2.setNivel2Id_Nivel2(null);
				}

				if (datOtrosCostosNivel4Tmp.getNivel4() != null) {
					datOtrosCostosNivel4DTO2.setNivel4Id_Nivel4(datOtrosCostosNivel4Tmp.getNivel4());
				} else {
					datOtrosCostosNivel4DTO2.setNivel4Id_Nivel4(null);
				}

				datOtrosCostosNivel4DTO.add(datOtrosCostosNivel4DTO2);
			}

			return datOtrosCostosNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatOtrosCostosNivel4 getDatOtrosCostosNivel4(Long datOtrosCostosNivel4Id) throws Exception {
		log.debug("getting DatOtrosCostosNivel4 instance");

		DatOtrosCostosNivel4 entity = null;

		try {
			entity = datOtrosCostosNivel4DAO.findById(datOtrosCostosNivel4Id);
		} catch (Exception e) {
			log.error("get DatOtrosCostosNivel4 failed", e);
			throw new ZMessManager().new FindingException("DatOtrosCostosNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostosNivel4> findPageDatOtrosCostosNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatOtrosCostosNivel4> entity = null;

		try {
			entity = datOtrosCostosNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatOtrosCostosNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatOtrosCostosNivel4() throws Exception {
		Long entity = null;

		try {
			entity = datOtrosCostosNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatOtrosCostosNivel4 Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<DatOtrosCostosNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatOtrosCostosNivel4> list = new ArrayList<DatOtrosCostosNivel4>();
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
			list = datOtrosCostosNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4ByNivel4(Long idOtrosCostos) throws Exception {
		try {
			List<DatOtrosCostosNivel4> datOtrosCostosNivel4 = datOtrosCostosNivel4DAO
					.findByCriteria("datOtrosCostos.datOtrosCostosId= " + idOtrosCostos);
			List<DatOtrosCostosNivel4DTO> datOtrosCostosNivel4DTO = new ArrayList<DatOtrosCostosNivel4DTO>();

			for (DatOtrosCostosNivel4 datOtrosCostosNivel4Tmp : datOtrosCostosNivel4) {
				DatOtrosCostosNivel4DTO datOtrosCostosNivel4DTO2 = new DatOtrosCostosNivel4DTO();

				datOtrosCostosNivel4DTO2.setDatOtrosCostosNivel4Id(datOtrosCostosNivel4Tmp.getDatOtrosCostosNivel4Id());
				datOtrosCostosNivel4DTO2.setDatOtrosCostosId_DatOtrosCostos(
						(datOtrosCostosNivel4Tmp.getDatOtrosCostos().getDatOtrosCostosId() != null)
								? datOtrosCostosNivel4Tmp.getDatOtrosCostos().getDatOtrosCostosId() : null);

				if (datOtrosCostosNivel4Tmp.getNivel2() != null) {
					datOtrosCostosNivel4DTO2.setNivel2Id_Nivel2(datOtrosCostosNivel4Tmp.getNivel2());
				} else {
					datOtrosCostosNivel4DTO2.setNivel2Id_Nivel2(null);
				}

				if (datOtrosCostosNivel4Tmp.getNivel2() != null) {
					datOtrosCostosNivel4DTO2.setNombreNivel2(datOtrosCostosNivel4Tmp.getNivel2().getNombre());
				} else {
					datOtrosCostosNivel4DTO2.setNombreNivel2(null);
				}

				if (datOtrosCostosNivel4Tmp.getNivel4() != null) {
					datOtrosCostosNivel4DTO2.setNivel4Id_Nivel4(datOtrosCostosNivel4Tmp.getNivel4());
				} else {
					datOtrosCostosNivel4DTO2.setNivel4Id_Nivel4(null);
				}

				if (datOtrosCostosNivel4Tmp.getNivel4() != null) {
					datOtrosCostosNivel4DTO2.setNombreNivel4(datOtrosCostosNivel4Tmp.getNivel4().getNombre());
				} else {
					datOtrosCostosNivel4DTO2.setNombreNivel4(null);
				}

				datOtrosCostosNivel4DTO2.setAreaNivel4(datOtrosCostosNivel4Tmp.getAreaNivel4());

				datOtrosCostosNivel4DTO.add(datOtrosCostosNivel4DTO2);
			}

			return datOtrosCostosNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	
	
}
