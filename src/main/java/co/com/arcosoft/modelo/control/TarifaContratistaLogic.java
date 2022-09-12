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

import co.com.arcosoft.dataaccess.dao.ITarifaContratistaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaContratista;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TarifaContratistaLogic")
public class TarifaContratistaLogic implements ITarifaContratistaLogic {
	private static final Logger log = LoggerFactory.getLogger(TarifaContratistaLogic.class);

	/**
	 * DAO injected by Spring that manages TarifaContratista entities
	 *
	 */
	@Autowired
	private ITarifaContratistaDAO tarifaContratistaDAO;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor1;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr2;

	/**
	 * Logic injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	IServicioLogic logicServicio3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<TarifaContratista> getTarifaContratista() throws Exception {
		log.debug("finding all TarifaContratista instances");

		List<TarifaContratista> list = new ArrayList<TarifaContratista>();

		try {
			list = tarifaContratistaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TarifaContratista failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TarifaContratista");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTarifaContratista(TarifaContratista entity) throws Exception {
		log.debug("saving TarifaContratista instance");

		try {

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaCtrId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaCtrId");
			}

			if ((entity.getTarifaCtrId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaCtrId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaCtrId");
			}

			if ((entity.getLabor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
			}

			if ((entity.getPersEmpr() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPersEmpr(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("persEmprId_PersEmpr");
			}

			if ((entity.getServicio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getServicio(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("servicioId_Servicio");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (getTarifaContratista(entity.getTarifaCtrId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			tarifaContratistaDAO.save(entity);

			log.debug("save TarifaContratista successful");
		} catch (Exception e) {
			log.error("save TarifaContratista failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTarifaContratista(TarifaContratista entity) throws Exception {
		log.debug("deleting TarifaContratista instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TarifaContratista");
		}

		if (entity.getTarifaCtrId() == null) {
			throw new ZMessManager().new EmptyFieldException("tarifaCtrId");
		}

		try {
			tarifaContratistaDAO.delete(entity);

			log.debug("delete TarifaContratista successful");
		} catch (Exception e) {
			log.error("delete TarifaContratista failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTarifaContratista(TarifaContratista entity) throws Exception {
		log.debug("updating TarifaContratista instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TarifaContratista");
			}
			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getTarifa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifa(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifa");
			}

			if (entity.getTarifaCtrId() == null) {
				throw new ZMessManager().new EmptyFieldException("tarifaCtrId");
			}

			if ((entity.getTarifaCtrId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTarifaCtrId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tarifaCtrId");
			}

			tarifaContratistaDAO.update(entity);

			log.debug("update TarifaContratista successful");
		} catch (Exception e) {
			log.error("update TarifaContratista failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaContratistaDTO> getDataTarifaContratista() throws Exception {
		try {
			List<TarifaContratista> tarifaContratista = tarifaContratistaDAO.findAll();

			List<TarifaContratistaDTO> tarifaContratistaDTO = new ArrayList<TarifaContratistaDTO>();

			for (TarifaContratista tarifaContratistaTmp : tarifaContratista) {
				TarifaContratistaDTO tarifaContratistaDTO2 = new TarifaContratistaDTO();

				tarifaContratistaDTO2.setTarifaCtrId(tarifaContratistaTmp.getTarifaCtrId());
				tarifaContratistaDTO2.setCompania(
						(tarifaContratistaTmp.getCompania() != null) ? tarifaContratistaTmp.getCompania() : null);
				tarifaContratistaDTO2.setFechaCreacion(tarifaContratistaTmp.getFechaCreacion());
				tarifaContratistaDTO2.setFechaFinal(tarifaContratistaTmp.getFechaFinal());
				tarifaContratistaDTO2.setFechaInicial(tarifaContratistaTmp.getFechaInicial());
				tarifaContratistaDTO2.setFechaModificacion(tarifaContratistaTmp.getFechaModificacion());
				tarifaContratistaDTO2.setTarifa(
						(tarifaContratistaTmp.getTarifa() != null) ? tarifaContratistaTmp.getTarifa() : null);

				if (tarifaContratistaTmp.getLabor() != null) {
					tarifaContratistaDTO2.setLaborId_Labor(tarifaContratistaTmp.getLabor());
				} else {
					tarifaContratistaDTO2.setLaborId_Labor(null);
				}

				if (tarifaContratistaTmp.getServicio() != null) {
					tarifaContratistaDTO2.setServicioId_Servicio(tarifaContratistaTmp.getServicio());
				} else {
					tarifaContratistaDTO2.setServicioId_Servicio(null);
				}

				tarifaContratistaDTO2.setUdadMedId_UdadMed(
						(tarifaContratistaTmp.getUdadMed() != null) ? tarifaContratistaTmp.getUdadMed() : null);

				if (tarifaContratistaTmp.getPersEmpr() != null) {
					tarifaContratistaDTO2.setPersEmprId_PersEmpr(tarifaContratistaTmp.getPersEmpr());
				} else {
					tarifaContratistaDTO2.setPersEmprId_PersEmpr(null);
				}

				if (tarifaContratistaTmp.getServicio() != null) {
					tarifaContratistaDTO2.setCodServicio(tarifaContratistaTmp.getServicio().getCodigo());
				} else {
					tarifaContratistaDTO2.setCodServicio(null);
				}

				if (tarifaContratistaTmp.getUdadMed() != null) {
					tarifaContratistaDTO2.setCodUdadMed(tarifaContratistaTmp.getUdadMed().getCodigo());
				} else {
					tarifaContratistaDTO2.setCodUdadMed(null);
				}

				if (tarifaContratistaTmp.getLabor() != null) {
					tarifaContratistaDTO2.setCodLabor(tarifaContratistaTmp.getLabor().getCodigo());
				} else {
					tarifaContratistaDTO2.setCodLabor(null);
				}

				tarifaContratistaDTO.add(tarifaContratistaDTO2);
			}

			return tarifaContratistaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TarifaContratista getTarifaContratista(Long tarifaCtrId) throws Exception {
		log.debug("getting TarifaContratista instance");

		TarifaContratista entity = null;

		try {
			entity = tarifaContratistaDAO.findById(tarifaCtrId);
		} catch (Exception e) {
			log.error("get TarifaContratista failed", e);
			throw new ZMessManager().new FindingException("TarifaContratista");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaContratista> findPageTarifaContratista(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TarifaContratista> entity = null;

		try {
			entity = tarifaContratistaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaContratista Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTarifaContratista() throws Exception {
		Long entity = null;

		try {
			entity = tarifaContratistaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TarifaContratista Count");
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
	public List<TarifaContratista> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TarifaContratista> list = new ArrayList<TarifaContratista>();
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
			list = tarifaContratistaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarifaContratistaDTO> getDataContratistaByTarifaContratistaId(Long persEmprId) throws Exception {
		try {
			List<TarifaContratista> tarifaContratista = tarifaContratistaDAO
					.findByCriteria("persEmpr.persEmprId= " + persEmprId);

			List<TarifaContratistaDTO> TarifaContratistaDTO = new ArrayList<TarifaContratistaDTO>();

			for (TarifaContratista tarifaContratistaTmp : tarifaContratista) {
				TarifaContratistaDTO TarifaContratistaDTO2 = new TarifaContratistaDTO();

				TarifaContratistaDTO2.setTarifaCtrId(tarifaContratistaTmp.getTarifaCtrId());
				TarifaContratistaDTO2.setCompania(tarifaContratistaTmp.getCompania());
				TarifaContratistaDTO2.setFechaCreacion(tarifaContratistaTmp.getFechaCreacion());
				TarifaContratistaDTO2.setFechaModificacion(tarifaContratistaTmp.getFechaModificacion());
				TarifaContratistaDTO2.setFechaInicial(tarifaContratistaTmp.getFechaInicial());
				TarifaContratistaDTO2.setFechaFinal(tarifaContratistaTmp.getFechaFinal());
				TarifaContratistaDTO2.setLaborId_Labor((tarifaContratistaTmp.getLabor()));
				TarifaContratistaDTO2.setServicioId_Servicio((tarifaContratistaTmp.getServicio()));
				TarifaContratistaDTO2.setUdadMedId_UdadMed((tarifaContratistaTmp.getUdadMed()));
				TarifaContratistaDTO2.setTarifa(((tarifaContratistaTmp.getTarifa())));

				if (tarifaContratistaTmp.getPersEmpr() != null) {
					TarifaContratistaDTO2.setPersEmprId_PersEmpr(tarifaContratistaTmp.getPersEmpr());
				} else {
					TarifaContratistaDTO2.setPersEmprId_PersEmpr(null);
				}

				if (tarifaContratistaTmp.getServicio() != null) {
					TarifaContratistaDTO2.setCodServicio(tarifaContratistaTmp.getServicio().getCodigo());
				} else {
					TarifaContratistaDTO2.setCodServicio(null);
				}

				if (tarifaContratistaTmp.getUdadMed() != null) {
					TarifaContratistaDTO2.setCodUdadMed(tarifaContratistaTmp.getUdadMed().getCodigo());
				} else {
					TarifaContratistaDTO2.setCodUdadMed(null);
				}

				if (tarifaContratistaTmp.getLabor() != null) {
					TarifaContratistaDTO2.setCodLabor(tarifaContratistaTmp.getLabor().getCodigo());
				} else {
					TarifaContratistaDTO2.setCodLabor(null);
				}

				if (tarifaContratistaTmp.getProfesion() != null) {
					TarifaContratistaDTO2.setProfesion(tarifaContratistaTmp.getProfesion());
				} else {
					TarifaContratistaDTO2.setProfesion(null);
				}

				if (tarifaContratistaTmp.getProfesion() != null) {
					TarifaContratistaDTO2.setCodProfesion(tarifaContratistaTmp.getProfesion().getCodigo());
				} else {
					TarifaContratistaDTO2.setCodProfesion(null);
				}

				if (tarifaContratistaTmp.getLabor() != null) {
					TarifaContratistaDTO2.setCodLabor(tarifaContratistaTmp.getLabor().getCodigo());
				} else {
					TarifaContratistaDTO2.setCodLabor(null);
				}

				if (tarifaContratistaTmp.getEdadInicial() != null) {
					TarifaContratistaDTO2.setEdadInicial(tarifaContratistaTmp.getEdadInicial());
				} else {
					TarifaContratistaDTO2.setEdadInicial(null);
				}
				if (tarifaContratistaTmp.getEdadFinal() != null) {
					TarifaContratistaDTO2.setEdadFinal(tarifaContratistaTmp.getEdadFinal());
				} else {
					TarifaContratistaDTO2.setEdadFinal(null);
				}

				if (tarifaContratistaTmp.getPesoPromedio() != null) {
					TarifaContratistaDTO2.setPesoPromedio(tarifaContratistaTmp.getPesoPromedio());
				} else {
					TarifaContratistaDTO2.setPesoPromedio(null);
				}

				if (tarifaContratistaTmp.getEstadoIncidencia() != null) {
					TarifaContratistaDTO2.setEstadoIncidencia(tarifaContratistaTmp.getEstadoIncidencia());
				} else {
					TarifaContratistaDTO2.setEstadoIncidencia(null);
				}				


				if (tarifaContratistaTmp.getAlturaPlanta() != null) {
					TarifaContratistaDTO2.setAlturaPlanta(tarifaContratistaTmp.getAlturaPlanta());
				} else {
					TarifaContratistaDTO2.setAlturaPlanta(null);
				}				

				if (tarifaContratistaTmp.getNivel2() != null) {
					TarifaContratistaDTO2.setNivel2Id_Nivel2(tarifaContratistaTmp.getNivel2());
				} else {
					TarifaContratistaDTO2.setNivel2Id_Nivel2(null);
				}

				if (tarifaContratistaTmp.getNivel2() != null) {
					TarifaContratistaDTO2.setNombreNivel2(tarifaContratistaTmp.getNivel2().getNombre());
				} else {
					TarifaContratistaDTO2.setNombreNivel2(null);
				}

				if (tarifaContratistaTmp.getNivel4() != null) {
					TarifaContratistaDTO2.setNivel4Id_Nivel4(tarifaContratistaTmp.getNivel4());
				} else {
					TarifaContratistaDTO2.setNivel4Id_Nivel4(null);
				}

				if (tarifaContratistaTmp.getNivel4() != null) {
					TarifaContratistaDTO2.setNombreNivel4(tarifaContratistaTmp.getNivel4().getNombre());
				} else {
					TarifaContratistaDTO2.setNombreNivel4(null);
				}

				

				TarifaContratistaDTO.add(TarifaContratistaDTO2);
			}

			return TarifaContratistaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
