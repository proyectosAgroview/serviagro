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

import co.com.arcosoft.dataaccess.dao.IDatServicioDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServicioDet;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatServicioDetLogic")
public class DatServicioDetLogic implements IDatServicioDetLogic {
	private static final Logger log = LoggerFactory.getLogger(DatServicioDetLogic.class);

	/**
	 * DAO injected by Spring that manages DatServicioDet entities
	 *
	 */
	@Autowired
	private IDatServicioDetDAO datServicioDetDAO;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo1;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr2;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDet> getDatServicioDet() throws Exception {
		log.debug("finding all DatServicioDet instances");

		List<DatServicioDet> list = new ArrayList<DatServicioDet>();

		try {
			list = datServicioDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatServicioDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatServicioDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatServicioDet(DatServicioDet entity) throws Exception {
		log.debug("saving DatServicioDet instance");

		try {

			if ((entity.getCantidadPago() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadPago(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadPago");
			}

			if ((entity.getCantidadProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadProd(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadProd");
			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if ((entity.getTiempoInactivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTiempoInactivo(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tiempoInactivo");
			}

			if ((entity.getTotalHoras() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalHoras(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalHoras");
			}

			if ((entity.getValorUnit() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnit(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnit");
			}

			/*
			 * if (entity.getDatServicioDetId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datServicioDetId"); }
			 * 
			 * if ((entity.getDatServicioDetId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatServicioDetId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datServicioDetId");
			 * }
			 * 
			 * 
			 * if (getDatServicioDet(entity.getDatServicioDetId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 * 
			 */ datServicioDetDAO.save(entity);

			log.debug("save DatServicioDet successful");
		} catch (Exception e) {
			log.error("save DatServicioDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatServicioDet(DatServicioDet entity) throws Exception {
		log.debug("deleting DatServicioDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatServicioDet");
		}

		if (entity.getDatServicioDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("datServicioDetId");
		}

		try {
			datServicioDetDAO.delete(entity);

			log.debug("delete DatServicioDet successful");
		} catch (Exception e) {
			log.error("delete DatServicioDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatServicioDet(DatServicioDet entity) throws Exception {
		log.debug("updating DatServicioDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatServicioDet");
			}

			if ((entity.getCantidadPago() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadPago(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadPago");
			}

			if ((entity.getCantidadProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadProd(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadProd");
			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if (entity.getDatServicioDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("datServicioDetId");
			}

			if ((entity.getDatServicioDetId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatServicioDetId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datServicioDetId");
			}

			if ((entity.getTiempoInactivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTiempoInactivo(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tiempoInactivo");
			}

			if ((entity.getTotalHoras() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalHoras(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalHoras");
			}

			if ((entity.getValorUnit() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnit(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnit");
			}

			datServicioDetDAO.update(entity);

			log.debug("update DatServicioDet successful");
		} catch (Exception e) {
			log.error("update DatServicioDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDetDTO> getDataDatServicioDet() throws Exception {
		try {
			List<DatServicioDet> datServicioDet = datServicioDetDAO.findAll();

			List<DatServicioDetDTO> datServicioDetDTO = new ArrayList<DatServicioDetDTO>();

			for (DatServicioDet datServicioDetTmp : datServicioDet) {
				DatServicioDetDTO datServicioDetDTO2 = new DatServicioDetDTO();

				datServicioDetDTO2.setDatServicioDetId(datServicioDetTmp.getDatServicioDetId());
				datServicioDetDTO2.setCantidadPago(
						(datServicioDetTmp.getCantidadPago() != null) ? datServicioDetTmp.getCantidadPago() : null);
				datServicioDetDTO2.setCantidadProd(
						(datServicioDetTmp.getCantidadProd() != null) ? datServicioDetTmp.getCantidadProd() : null);
				datServicioDetDTO2.setCostoTotal(
						(datServicioDetTmp.getCostoTotal() != null) ? datServicioDetTmp.getCostoTotal() : null);
				datServicioDetDTO2.setDatServicioId((datServicioDetTmp.getDatServicioId() != null)
						? datServicioDetTmp.getDatServicioId().getDatServicioId() : null);
				datServicioDetDTO2.setHoraFinal(datServicioDetTmp.getHoraFinal());
				datServicioDetDTO2.setHoraInicial(datServicioDetTmp.getHoraInicial());
				datServicioDetDTO2.setTiempoInactivo(
						(datServicioDetTmp.getTiempoInactivo() != null) ? datServicioDetTmp.getTiempoInactivo() : null);
				datServicioDetDTO2.setTotalHoras(
						(datServicioDetTmp.getTotalHoras() != null) ? datServicioDetTmp.getTotalHoras() : null);
				datServicioDetDTO2.setValorUnit(
						(datServicioDetTmp.getValorUnit() != null) ? datServicioDetTmp.getValorUnit() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setEquipoId_Equipo(datServicioDetTmp.getEquipo());
				} else {
					datServicioDetDTO2.setEquipoId_Equipo(null);
				}

				datServicioDetDTO2.setPersEmprId_PersEmpr(
						(datServicioDetTmp.getPersEmpr() != null) ? datServicioDetTmp.getPersEmpr() : null);

				datServicioDetDTO2.setUdadMedPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setCodigoEquipo(datServicioDetTmp.getEquipo().getCodigo());
				} else {
					datServicioDetDTO2.setCodigoEquipo(null);
				}

				datServicioDetDTO2.setCodigoUmPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago().getCodigo() : null);

				datServicioDetDTO.add(datServicioDetDTO2);

			}

			return datServicioDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatServicioDet getDatServicioDet(Long datServicioDetId) throws Exception {
		log.debug("getting DatServicioDet instance");

		DatServicioDet entity = null;

		try {
			entity = datServicioDetDAO.findById(datServicioDetId);
		} catch (Exception e) {
			log.error("get DatServicioDet failed", e);
			throw new ZMessManager().new FindingException("DatServicioDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDet> findPageDatServicioDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatServicioDet> entity = null;

		try {
			entity = datServicioDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServicioDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatServicioDet() throws Exception {
		Long entity = null;

		try {
			entity = datServicioDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServicioDet Count");
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
	public List<DatServicioDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatServicioDet> list = new ArrayList<DatServicioDet>();
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
			list = datServicioDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDetDTO> getDataDatServicioDetByServicio(Long datServicioId) throws Exception {
		try {
			List<DatServicioDet> datServicioDet = datServicioDetDAO
					.findByCriteria("datServicioId.datServicioId= " + datServicioId);

			List<DatServicioDetDTO> datServicioDetDTO = new ArrayList<DatServicioDetDTO>();

			for (DatServicioDet datServicioDetTmp : datServicioDet) {
				DatServicioDetDTO datServicioDetDTO2 = new DatServicioDetDTO();

				datServicioDetDTO2.setDatServicioDetId(datServicioDetTmp.getDatServicioDetId());
				datServicioDetDTO2.setCantidadPago(
						(datServicioDetTmp.getCantidadPago() != null) ? datServicioDetTmp.getCantidadPago() : null);
				datServicioDetDTO2.setCantidadProd(
						(datServicioDetTmp.getCantidadProd() != null) ? datServicioDetTmp.getCantidadProd() : null);
				datServicioDetDTO2.setCostoTotal(
						(datServicioDetTmp.getCostoTotal() != null) ? datServicioDetTmp.getCostoTotal() : null);
				datServicioDetDTO2.setDatServicioId((datServicioDetTmp.getDatServicioId() != null)
						? datServicioDetTmp.getDatServicioId().getDatServicioId() : null);
				datServicioDetDTO2.setHoraFinal(datServicioDetTmp.getHoraFinal());
				datServicioDetDTO2.setHoraInicial(datServicioDetTmp.getHoraInicial());
				datServicioDetDTO2.setTiempoInactivo(
						(datServicioDetTmp.getTiempoInactivo() != null) ? datServicioDetTmp.getTiempoInactivo() : null);
				datServicioDetDTO2.setTotalHoras(
						(datServicioDetTmp.getTotalHoras() != null) ? datServicioDetTmp.getTotalHoras() : null);
				datServicioDetDTO2.setValorUnit(
						(datServicioDetTmp.getValorUnit() != null) ? datServicioDetTmp.getValorUnit() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setEquipoId_Equipo(datServicioDetTmp.getEquipo());
				} else {
					datServicioDetDTO2.setEquipoId_Equipo(null);
				}

				datServicioDetDTO2.setPersEmprId_PersEmpr(
						(datServicioDetTmp.getPersEmpr() != null) ? datServicioDetTmp.getPersEmpr() : null);

				datServicioDetDTO2.setUdadMedPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setCodigoEquipo(datServicioDetTmp.getEquipo().getCodigo());
				} else {
					datServicioDetDTO2.setCodigoEquipo(null);
				}

				if (datServicioDetTmp.getHorometroInicial() != null) {

					datServicioDetDTO2.setHorometroInicial(datServicioDetTmp.getHorometroInicial());
				} else {
					datServicioDetDTO2.setHorometroInicial(null);
				}

				if (datServicioDetTmp.getHorometroFinal() != null) {

					datServicioDetDTO2.setHorometroFinal(datServicioDetTmp.getHorometroFinal());
				} else {
					datServicioDetDTO2.setHorometroFinal(null);
				}

				datServicioDetDTO2.setCodigoUmPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago().getCodigo() : null);


				if (datServicioDetTmp.getNivel2Id() != null) {
					datServicioDetDTO2.setNivel2Id(datServicioDetTmp.getNivel2Id());
				} else {
					datServicioDetDTO2.setNivel2Id(null);
				}

				if (datServicioDetTmp.getNivel4() != null) {
					datServicioDetDTO2.setNivel4(datServicioDetTmp.getNivel4());
				} else {
					datServicioDetDTO2.setNivel4(null);
				}

				if (datServicioDetTmp.getNivel2Id() != null) {
					datServicioDetDTO2.setNombreNivel2(datServicioDetTmp.getNivel2Id().getNombre());
				} else {
					datServicioDetDTO2.setNombreNivel2(null);
				}

				if (datServicioDetTmp.getNivel4() != null) {
					datServicioDetDTO2.setNombreNivel4(datServicioDetTmp.getNivel4().getNombre());
				} else {
					datServicioDetDTO2.setNombreNivel4(null);
				}

				
				if (datServicioDetTmp.getLaborId() != null) {
					datServicioDetDTO2.setLaborId(datServicioDetTmp.getLaborId());
				} else {
					datServicioDetDTO2.setLaborId(null);
				}
				
				if (datServicioDetTmp.getOrdenTrabajo() != null) {
					datServicioDetDTO2.setOrdenTrabajo(datServicioDetTmp.getOrdenTrabajo());
				} else {
					datServicioDetDTO2.setOrdenTrabajo(null);
				}
				
				if (datServicioDetTmp.getLaborId() != null) {
					datServicioDetDTO2.setNombreLabor(datServicioDetTmp.getLaborId().getNombre());
				} else {
					datServicioDetDTO2.setNombreLabor(null);
				}
				
				
				datServicioDetDTO.add(datServicioDetDTO2);

			}

			return datServicioDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDetDTO> getDataDatServicioDetByPlanillaNomina(Long planillaNominaId) throws Exception {
		try {
			List<DatServicioDet> datServicioDet = datServicioDetDAO
					.findByCriteria("datPlanillaNominaId.planillaNominaId= " + planillaNominaId);
									
			List<DatServicioDetDTO> datServicioDetDTO = new ArrayList<DatServicioDetDTO>();

			for (DatServicioDet datServicioDetTmp : datServicioDet) {
				DatServicioDetDTO datServicioDetDTO2 = new DatServicioDetDTO();

				datServicioDetDTO2.setDatServicioDetId(datServicioDetTmp.getDatServicioDetId());
				datServicioDetDTO2.setCantidadPago(
						(datServicioDetTmp.getCantidadPago() != null) ? datServicioDetTmp.getCantidadPago() : null);
				datServicioDetDTO2.setCantidadProd(
						(datServicioDetTmp.getCantidadProd() != null) ? datServicioDetTmp.getCantidadProd() : null);
				datServicioDetDTO2.setCostoTotal(
						(datServicioDetTmp.getCostoTotal() != null) ? datServicioDetTmp.getCostoTotal() : null);
				datServicioDetDTO2.setDatServicioId((datServicioDetTmp.getDatServicioId() != null)
						? datServicioDetTmp.getDatServicioId().getDatServicioId() : null);
				datServicioDetDTO2.setHoraFinal(datServicioDetTmp.getHoraFinal());
				datServicioDetDTO2.setHoraInicial(datServicioDetTmp.getHoraInicial());
				datServicioDetDTO2.setTiempoInactivo(
						(datServicioDetTmp.getTiempoInactivo() != null) ? datServicioDetTmp.getTiempoInactivo() : null);
				datServicioDetDTO2.setTotalHoras(
						(datServicioDetTmp.getTotalHoras() != null) ? datServicioDetTmp.getTotalHoras() : null);
				datServicioDetDTO2.setValorUnit(
						(datServicioDetTmp.getValorUnit() != null) ? datServicioDetTmp.getValorUnit() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setEquipoId_Equipo(datServicioDetTmp.getEquipo());
				} else {
					datServicioDetDTO2.setEquipoId_Equipo(null);
				}

				datServicioDetDTO2.setPersEmprId_PersEmpr(
						(datServicioDetTmp.getPersEmpr() != null) ? datServicioDetTmp.getPersEmpr() : null);

				datServicioDetDTO2.setUdadMedPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago() : null);

				if (datServicioDetTmp.getEquipo() != null) {
					datServicioDetDTO2.setCodigoEquipo(datServicioDetTmp.getEquipo().getCodigo());
				} else {
					datServicioDetDTO2.setCodigoEquipo(null);
				}

				if (datServicioDetTmp.getHorometroInicial() != null) {

					datServicioDetDTO2.setHorometroInicial(datServicioDetTmp.getHorometroInicial());
				} else {
					datServicioDetDTO2.setHorometroInicial(null);
				}

				if (datServicioDetTmp.getHorometroFinal() != null) {

					datServicioDetDTO2.setHorometroFinal(datServicioDetTmp.getHorometroFinal());
				} else {
					datServicioDetDTO2.setHorometroFinal(null);
				}

				datServicioDetDTO2.setCodigoUmPago((datServicioDetTmp.getUdadMedByUdadMedPago() != null)
						? datServicioDetTmp.getUdadMedByUdadMedPago().getCodigo() : null);


				if (datServicioDetTmp.getNivel2Id() != null) {
					datServicioDetDTO2.setNivel2Id(datServicioDetTmp.getNivel2Id());
				} else {
					datServicioDetDTO2.setNivel2Id(null);
				}

				if (datServicioDetTmp.getNivel4() != null) {
					datServicioDetDTO2.setNivel4(datServicioDetTmp.getNivel4());
				} else {
					datServicioDetDTO2.setNivel4(null);
				}

				if (datServicioDetTmp.getNivel2Id() != null) {
					datServicioDetDTO2.setNombreNivel2(datServicioDetTmp.getNivel2Id().getNombre());
				} else {
					datServicioDetDTO2.setNombreNivel2(null);
				}

				if (datServicioDetTmp.getNivel4() != null) {
					datServicioDetDTO2.setNombreNivel4(datServicioDetTmp.getNivel4().getNombre());
				} else {
					datServicioDetDTO2.setNombreNivel4(null);
				}

				
				if (datServicioDetTmp.getLaborId() != null) {
					datServicioDetDTO2.setLaborId(datServicioDetTmp.getLaborId());
				} else {
					datServicioDetDTO2.setLaborId(null);
				}
				
				if (datServicioDetTmp.getOrdenTrabajo() != null) {
					datServicioDetDTO2.setOrdenTrabajo(datServicioDetTmp.getOrdenTrabajo());
				} else {
					datServicioDetDTO2.setOrdenTrabajo(null);
				}
				
				if (datServicioDetTmp.getLaborId() != null) {
					datServicioDetDTO2.setNombreLabor(datServicioDetTmp.getLaborId().getNombre());
				} else {
					datServicioDetDTO2.setNombreLabor(null);
				}
				
				
				datServicioDetDTO.add(datServicioDetDTO2);

			}

			return datServicioDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
