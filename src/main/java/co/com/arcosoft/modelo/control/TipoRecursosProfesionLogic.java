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

import co.com.arcosoft.dataaccess.dao.ITipoRecursosProfesionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.dto.TipoRecursosProfesionDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoRecursosProfesionLogic")
public class TipoRecursosProfesionLogic implements ITipoRecursosProfesionLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoRecursosProfesionLogic.class);

	/**
	 * DAO injected by Spring that manages TipoRecursosProfesion entities
	 *
	 */
	@Autowired
	private ITipoRecursosProfesionDAO tipoRecursosProfesionDAO;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto1;

	/**
	 * Logic injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	IProfesionLogic logicProfesion2;

	/**
	 * Logic injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	ITipoRecursoLogic logicTipoRecurso3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosProfesion> getTipoRecursosProfesion() throws Exception {
		log.debug("finding all TipoRecursosProfesion instances");

		List<TipoRecursosProfesion> list = new ArrayList<TipoRecursosProfesion>();

		try {
			list = tipoRecursosProfesionDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoRecursosProfesion failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoRecursosProfesion");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		log.debug("saving TipoRecursosProfesion instance");

		try {
			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getDisponibilidadDia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDisponibilidadDia(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("disponibilidadDia");
			}

			if ((entity.getDisponibilidadTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDisponibilidadTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("disponibilidadTotal");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if (getTipoRecursosProfesion(entity.getTipoRecursosProfesionId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tipoRecursosProfesionDAO.save(entity);

			log.debug("save TipoRecursosProfesion successful");
		} catch (Exception e) {
			log.error("save TipoRecursosProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		log.debug("deleting TipoRecursosProfesion instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoRecursosProfesion");
		}

		if (entity.getTipoRecursosProfesionId() == null) {
			throw new ZMessManager().new EmptyFieldException("tipoRecursosProfesionId");
		}

		try {
			tipoRecursosProfesionDAO.delete(entity);

			log.debug("delete TipoRecursosProfesion successful");
		} catch (Exception e) {
			log.error("delete TipoRecursosProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		log.debug("updating TipoRecursosProfesion instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoRecursosProfesion");
			}

			if (entity.getElementoCosto() == null) {
				throw new ZMessManager().new ForeignException("elementoCosto");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if (entity.getTipoRecurso() == null) {
				throw new ZMessManager().new ForeignException("tipoRecurso");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getDisponibilidadDia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDisponibilidadDia(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("disponibilidadDia");
			}

			if ((entity.getDisponibilidadTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDisponibilidadTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("disponibilidadTotal");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getElementoCosto().getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId_ElementoCosto");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if (entity.getTipoRecurso().getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId_TipoRecurso");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			tipoRecursosProfesionDAO.update(entity);

			log.debug("update TipoRecursosProfesion successful");
		} catch (Exception e) {
			log.error("update TipoRecursosProfesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesion() throws Exception {
		try {
			List<TipoRecursosProfesion> tipoRecursosProfesion = tipoRecursosProfesionDAO.findAll();

			List<TipoRecursosProfesionDTO> tipoRecursosProfesionDTO = new ArrayList<TipoRecursosProfesionDTO>();

			for (TipoRecursosProfesion tipoRecursosProfesionTmp : tipoRecursosProfesion) {
				TipoRecursosProfesionDTO tipoRecursosProfesionDTO2 = new TipoRecursosProfesionDTO();

				tipoRecursosProfesionDTO2
						.setTipoRecursosProfesionId(tipoRecursosProfesionTmp.getTipoRecursosProfesionId());
				tipoRecursosProfesionDTO2.setDisponibilidadDia((tipoRecursosProfesionTmp.getDisponibilidadDia() != null)
						? tipoRecursosProfesionTmp.getDisponibilidadDia() : null);
				tipoRecursosProfesionDTO2
						.setDisponibilidadTotal((tipoRecursosProfesionTmp.getDisponibilidadTotal() != null)
								? tipoRecursosProfesionTmp.getDisponibilidadTotal() : null);
				tipoRecursosProfesionDTO2.setFechaCreacion(tipoRecursosProfesionTmp.getFechaCreacion());
				tipoRecursosProfesionDTO2.setFechaFinal(tipoRecursosProfesionTmp.getFechaFinal());
				tipoRecursosProfesionDTO2.setFechaInicial(tipoRecursosProfesionTmp.getFechaInicial());
				tipoRecursosProfesionDTO2.setFechaModificacion(tipoRecursosProfesionTmp.getFechaModificacion());
				tipoRecursosProfesionDTO2.setValor(
						(tipoRecursosProfesionTmp.getValor() != null) ? tipoRecursosProfesionTmp.getValor() : null);
				tipoRecursosProfesionDTO2
						.setElemCostoId_ElementoCosto((tipoRecursosProfesionTmp.getElementoCosto() != null)
								? tipoRecursosProfesionTmp.getElementoCosto() : null);

				if (tipoRecursosProfesionTmp.getProfesion() != null) {
					tipoRecursosProfesionDTO2.setProfId_Profesion(tipoRecursosProfesionTmp.getProfesion());
				} else {
					tipoRecursosProfesionDTO2.setProfId_Profesion(null);
				}

				tipoRecursosProfesionDTO2
						.setTpRecursoId_TipoRecurso((tipoRecursosProfesionTmp.getTipoRecurso().getTpRecursoId() != null)
								? tipoRecursosProfesionTmp.getTipoRecurso().getTpRecursoId() : null);
				tipoRecursosProfesionDTO2.setUdadMedId_UdadMed(
						(tipoRecursosProfesionTmp.getUdadMed() != null) ? tipoRecursosProfesionTmp.getUdadMed() : null);

				if (tipoRecursosProfesionTmp.getUdadMed() != null) {
					tipoRecursosProfesionDTO2.setNombreUm(tipoRecursosProfesionTmp.getUdadMed().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreUm(null);
				}

				if (tipoRecursosProfesionTmp.getProfesion() != null) {
					tipoRecursosProfesionDTO2.setNombreProfesion(tipoRecursosProfesionTmp.getProfesion().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreProfesion(null);
				}

				if (tipoRecursosProfesionTmp.getElementoCosto() != null) {
					tipoRecursosProfesionDTO2
							.setNombreElemCosto(tipoRecursosProfesionTmp.getElementoCosto().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreElemCosto(null);
				}

				tipoRecursosProfesionDTO.add(tipoRecursosProfesionDTO2);
			}

			return tipoRecursosProfesionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoRecursosProfesion getTipoRecursosProfesion(Long tipoRecursosProfesionId) throws Exception {
		log.debug("getting TipoRecursosProfesion instance");

		TipoRecursosProfesion entity = null;

		try {
			entity = tipoRecursosProfesionDAO.findById(tipoRecursosProfesionId);
		} catch (Exception e) {
			log.error("get TipoRecursosProfesion failed", e);
			throw new ZMessManager().new FindingException("TipoRecursosProfesion");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosProfesion> findPageTipoRecursosProfesion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<TipoRecursosProfesion> entity = null;

		try {
			entity = tipoRecursosProfesionDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecursosProfesion Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoRecursosProfesion() throws Exception {
		Long entity = null;

		try {
			entity = tipoRecursosProfesionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecursosProfesion Count");
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
	public List<TipoRecursosProfesion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoRecursosProfesion> list = new ArrayList<TipoRecursosProfesion>();
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
			list = tipoRecursosProfesionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesionByProfesion(Long tipoRecursosProfesionId)
			throws Exception {
		try {
			List<TipoRecursosProfesion> tipoRecursosProfesion = tipoRecursosProfesionDAO
					.findByCriteria("tipoRecurso.tpRecursoId= " + tipoRecursosProfesionId);

			List<TipoRecursosProfesionDTO> tipoRecursosProfesionDTO = new ArrayList<TipoRecursosProfesionDTO>();

			for (TipoRecursosProfesion tipoRecursosProfesionTmp : tipoRecursosProfesion) {
				TipoRecursosProfesionDTO tipoRecursosProfesionDTO2 = new TipoRecursosProfesionDTO();

				tipoRecursosProfesionDTO2
						.setTipoRecursosProfesionId(tipoRecursosProfesionTmp.getTipoRecursosProfesionId());
				tipoRecursosProfesionDTO2.setDisponibilidadDia((tipoRecursosProfesionTmp.getDisponibilidadDia() != null)
						? tipoRecursosProfesionTmp.getDisponibilidadDia() : null);
				tipoRecursosProfesionDTO2
						.setDisponibilidadTotal((tipoRecursosProfesionTmp.getDisponibilidadTotal() != null)
								? tipoRecursosProfesionTmp.getDisponibilidadTotal() : null);
				tipoRecursosProfesionDTO2.setFechaCreacion(tipoRecursosProfesionTmp.getFechaCreacion());
				tipoRecursosProfesionDTO2.setFechaFinal(tipoRecursosProfesionTmp.getFechaFinal());
				tipoRecursosProfesionDTO2.setFechaInicial(tipoRecursosProfesionTmp.getFechaInicial());
				tipoRecursosProfesionDTO2.setFechaModificacion(tipoRecursosProfesionTmp.getFechaModificacion());
				tipoRecursosProfesionDTO2.setValor(
						(tipoRecursosProfesionTmp.getValor() != null) ? tipoRecursosProfesionTmp.getValor() : null);
				tipoRecursosProfesionDTO2
						.setElemCostoId_ElementoCosto((tipoRecursosProfesionTmp.getElementoCosto() != null)
								? tipoRecursosProfesionTmp.getElementoCosto() : null);

				if (tipoRecursosProfesionTmp.getProfesion() != null) {
					tipoRecursosProfesionDTO2.setProfId_Profesion(tipoRecursosProfesionTmp.getProfesion());
				} else {
					tipoRecursosProfesionDTO2.setProfId_Profesion(null);
				}

				tipoRecursosProfesionDTO2
						.setTpRecursoId_TipoRecurso((tipoRecursosProfesionTmp.getTipoRecurso().getTpRecursoId() != null)
								? tipoRecursosProfesionTmp.getTipoRecurso().getTpRecursoId() : null);
				tipoRecursosProfesionDTO2.setUdadMedId_UdadMed(
						(tipoRecursosProfesionTmp.getUdadMed() != null) ? tipoRecursosProfesionTmp.getUdadMed() : null);

				if (tipoRecursosProfesionTmp.getUdadMed() != null) {
					tipoRecursosProfesionDTO2.setNombreUm(tipoRecursosProfesionTmp.getUdadMed().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreUm(null);
				}

				if (tipoRecursosProfesionTmp.getProfesion() != null) {
					tipoRecursosProfesionDTO2.setNombreProfesion(tipoRecursosProfesionTmp.getProfesion().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreProfesion(null);
				}

				if (tipoRecursosProfesionTmp.getElementoCosto() != null) {
					tipoRecursosProfesionDTO2
							.setNombreElemCosto(tipoRecursosProfesionTmp.getElementoCosto().getNombre());
				} else {
					tipoRecursosProfesionDTO2.setNombreElemCosto(null);
				}

				tipoRecursosProfesionDTO.add(tipoRecursosProfesionDTO2);
			}

			return tipoRecursosProfesionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
