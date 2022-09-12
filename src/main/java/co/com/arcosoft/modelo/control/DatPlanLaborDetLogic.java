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

import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatPlanLaborDetLogic")
public class DatPlanLaborDetLogic implements IDatPlanLaborDetLogic {
	private static final Logger log = LoggerFactory.getLogger(DatPlanLaborDetLogic.class);

	/**
	 * DAO injected by Spring that manages DatPlanLaborDet entities
	 *
	 */
	@Autowired
	private IDatPlanLaborDetDAO datPlanLaborDetDAO;

	/**
	 * Logic injected by Spring that manages DatPlanLabor entities
	 *
	 */
	@Autowired
	IDatPlanLaborLogic logicDatPlanLabor1;

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
	public List<DatPlanLaborDet> getDatPlanLaborDet() throws Exception {
		log.debug("finding all DatPlanLaborDet instances");

		List<DatPlanLaborDet> list = new ArrayList<DatPlanLaborDet>();

		try {
			list = datPlanLaborDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatPlanLaborDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatPlanLaborDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		log.debug("saving DatPlanLaborDet instance");

		try {
			if (entity.getDatPlanLabor() == null) {
				throw new ZMessManager().new ForeignException("datPlanLabor");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getDatPlanLabor().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId_DatPlanLabor");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			datPlanLaborDetDAO.save(entity);

			log.debug("save DatPlanLaborDet successful");
		} catch (Exception e) {
			log.error("save DatPlanLaborDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		log.debug("deleting DatPlanLaborDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatPlanLaborDet");
		}

		if (entity.getPlanLaborDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("planLaborDetId");
		}

		try {
			datPlanLaborDetDAO.delete(entity);

			log.debug("delete DatPlanLaborDet successful");
		} catch (Exception e) {
			log.error("delete DatPlanLaborDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		log.debug("updating DatPlanLaborDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatPlanLaborDet");
			}

			if (entity.getDatPlanLabor() == null) {
				throw new ZMessManager().new ForeignException("datPlanLabor");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getDatPlanLabor().getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId_DatPlanLabor");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			datPlanLaborDetDAO.update(entity);

			log.debug("update DatPlanLaborDet successful");
		} catch (Exception e) {
			log.error("update DatPlanLaborDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDet() throws Exception {
		try {
			List<DatPlanLaborDet> datPlanLaborDet = datPlanLaborDetDAO.findAll();

			List<DatPlanLaborDetDTO> datPlanLaborDetDTO = new ArrayList<DatPlanLaborDetDTO>();

			for (DatPlanLaborDet datPlanLaborDetTmp : datPlanLaborDet) {
				DatPlanLaborDetDTO datPlanLaborDetDTO2 = new DatPlanLaborDetDTO();

				datPlanLaborDetDTO2.setPlanLaborDetId(datPlanLaborDetTmp.getPlanLaborDetId());
				datPlanLaborDetDTO2.setCantidadPlan(
						(datPlanLaborDetTmp.getCantidadPlan() != null) ? datPlanLaborDetTmp.getCantidadPlan() : null);
				datPlanLaborDetDTO2.setEdadPlanificacion((datPlanLaborDetTmp.getEdadPlanificacion() != null)
						? datPlanLaborDetTmp.getEdadPlanificacion() : null);
				datPlanLaborDetDTO2
						.setPlanLaborId_DatPlanLabor((datPlanLaborDetTmp.getDatPlanLabor().getPlanLaborId() != null)
								? datPlanLaborDetTmp.getDatPlanLabor().getPlanLaborId() : null);

				if (datPlanLaborDetTmp.getNivel2() != null) {
					datPlanLaborDetDTO2.setNivel2Id_Nivel2(datPlanLaborDetTmp.getNivel2());
				} else {
					datPlanLaborDetDTO2.setNivel2Id_Nivel2(null);
				}

				if (datPlanLaborDetTmp.getNivel4() != null) {
					datPlanLaborDetDTO2.setNivel4Id_Nivel4(datPlanLaborDetTmp.getNivel4());
				} else {
					datPlanLaborDetDTO2.setNivel4Id_Nivel4(null);
				}

				datPlanLaborDetDTO.add(datPlanLaborDetDTO2);
			}

			return datPlanLaborDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatPlanLaborDet getDatPlanLaborDet(Long planLaborDetId) throws Exception {
		log.debug("getting DatPlanLaborDet instance");

		DatPlanLaborDet entity = null;

		try {
			entity = datPlanLaborDetDAO.findById(planLaborDetId);
		} catch (Exception e) {
			log.error("get DatPlanLaborDet failed", e);
			throw new ZMessManager().new FindingException("DatPlanLaborDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLaborDet> findPageDatPlanLaborDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatPlanLaborDet> entity = null;

		try {
			entity = datPlanLaborDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanLaborDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatPlanLaborDet() throws Exception {
		Long entity = null;

		try {
			entity = datPlanLaborDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanLaborDet Count");
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
	public List<DatPlanLaborDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatPlanLaborDet> list = new ArrayList<DatPlanLaborDet>();
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
			list = datPlanLaborDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDetByPlan(Long planLaborId) throws Exception {
		try {

			List<DatPlanLaborDet> datPlanLaborDet = datPlanLaborDetDAO
					.findByCriteria("datPlanLabor.planLaborId= " + planLaborId);

			List<DatPlanLaborDetDTO> datPlanLaborDetDTO = new ArrayList<DatPlanLaborDetDTO>();

			for (DatPlanLaborDet datPlanLaborDetTmp : datPlanLaborDet) {
				DatPlanLaborDetDTO datPlanLaborDetDTO2 = new DatPlanLaborDetDTO();

				datPlanLaborDetDTO2.setPlanLaborDetId(datPlanLaborDetTmp.getPlanLaborDetId());
				datPlanLaborDetDTO2.setCantidadPlan(
						(datPlanLaborDetTmp.getCantidadPlan() != null) ? datPlanLaborDetTmp.getCantidadPlan() : null);
				datPlanLaborDetDTO2.setEdadPlanificacion((datPlanLaborDetTmp.getEdadPlanificacion() != null)
						? datPlanLaborDetTmp.getEdadPlanificacion() : null);
				datPlanLaborDetDTO2
						.setPlanLaborId_DatPlanLabor((datPlanLaborDetTmp.getDatPlanLabor().getPlanLaborId() != null)
								? datPlanLaborDetTmp.getDatPlanLabor().getPlanLaborId() : null);

				if (datPlanLaborDetTmp.getNivel2() != null) {
					datPlanLaborDetDTO2.setNivel2Id_Nivel2(datPlanLaborDetTmp.getNivel2());
				} else {
					datPlanLaborDetDTO2.setNivel2Id_Nivel2(null);
				}

				if (datPlanLaborDetTmp.getNivel4() != null) {
					datPlanLaborDetDTO2.setNivel4Id_Nivel4(datPlanLaborDetTmp.getNivel4());
				} else {
					datPlanLaborDetDTO2.setNivel4Id_Nivel4(null);
				}

				if (datPlanLaborDetTmp.getNivel2() != null) {
					datPlanLaborDetDTO2.setNivel2Nombre(datPlanLaborDetTmp.getNivel2().getNombre());
				} else {
					datPlanLaborDetDTO2.setNivel2Nombre(null);
				}

				if (datPlanLaborDetTmp.getNivel4() != null) {
					datPlanLaborDetDTO2.setNivel4Nombre(datPlanLaborDetTmp.getNivel4().getNombre());
				} else {
					datPlanLaborDetDTO2.setNivel4Nombre(null);
				}

				datPlanLaborDetDTO.add(datPlanLaborDetDTO2);
			}

			return datPlanLaborDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
