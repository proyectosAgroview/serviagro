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

import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatPlanillaNominaDetLogic")
public class DatPlanillaNominaDetLogic implements IDatPlanillaNominaDetLogic {
	private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaDetLogic.class);

	/**
	 * DAO injected by Spring that manages DatPlanillaNominaDet entities
	 *
	 */
	@Autowired
	private IDatPlanillaNominaDetDAO datPlanillaNominaDetDAO;

	/**
	 * Logic injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	IConceptoNominaLogic logicConceptoNomina1;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr2;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed5;

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDet> getDatPlanillaNominaDet() throws Exception {
		log.debug("finding all DatPlanillaNominaDet instances");

		List<DatPlanillaNominaDet> list = new ArrayList<DatPlanillaNominaDet>();

		try {
			list = datPlanillaNominaDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatPlanillaNominaDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatPlanillaNominaDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		log.debug("saving DatPlanillaNominaDet instance");

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
			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

			if (entity.getConceptoNomina().getCeptoNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId_ConceptoNomina");
			}

			/*
			 * if (entity.getDetPlanillaNominaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "detPlanillaNominaId"); }
			 * 
			 * if ((entity.getDetPlanillaNominaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDetPlanillaNominaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "detPlanillaNominaId"); }
			 * 
			 * 
			 * if (getDatPlanillaNominaDet(entity.getDetPlanillaNominaId()) !=
			 * null) { throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			 * }
			 */
			datPlanillaNominaDetDAO.save(entity);

			log.debug("save DatPlanillaNominaDet successful");
		} catch (Exception e) {
			log.error("save DatPlanillaNominaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		log.debug("deleting DatPlanillaNominaDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatPlanillaNominaDet");
		}

		if (entity.getDetPlanillaNominaId() == null) {
			throw new ZMessManager().new EmptyFieldException("detPlanillaNominaId");
		}

		try {
			datPlanillaNominaDetDAO.delete(entity);

			log.debug("delete DatPlanillaNominaDet successful");
		} catch (Exception e) {
			log.error("delete DatPlanillaNominaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		log.debug("updating DatPlanillaNominaDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatPlanillaNominaDet");
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

			if (entity.getDetPlanillaNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("detPlanillaNominaId");
			}

			if ((entity.getDetPlanillaNominaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDetPlanillaNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("detPlanillaNominaId");
			}

			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

			datPlanillaNominaDetDAO.update(entity);

			log.debug("update DatPlanillaNominaDet successful");
		} catch (Exception e) {
			log.error("update DatPlanillaNominaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDet() throws Exception {
		try {
			List<DatPlanillaNominaDet> datPlanillaNominaDet = datPlanillaNominaDetDAO.findAll();

			List<DatPlanillaNominaDetDTO> datPlanillaNominaDetDTO = new ArrayList<DatPlanillaNominaDetDTO>();

			for (DatPlanillaNominaDet datPlanillaNominaDetTmp : datPlanillaNominaDet) {
				DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();

				datPlanillaNominaDetDTO2.setDetPlanillaNominaId(datPlanillaNominaDetTmp.getDetPlanillaNominaId());
				datPlanillaNominaDetDTO2.setCantidadPago((datPlanillaNominaDetTmp.getCantidadPago() != null)
						? datPlanillaNominaDetTmp.getCantidadPago() : null);
				datPlanillaNominaDetDTO2.setCantidadProd((datPlanillaNominaDetTmp.getCantidadProd() != null)
						? datPlanillaNominaDetTmp.getCantidadProd() : null);
				datPlanillaNominaDetDTO2.setCostoTotal((datPlanillaNominaDetTmp.getCostoTotal() != null)
						? datPlanillaNominaDetTmp.getCostoTotal() : null);
				datPlanillaNominaDetDTO2.setEqpTrabId((datPlanillaNominaDetTmp.getEqpTrabId() != null)
						? datPlanillaNominaDetTmp.getEqpTrabId() : null);
				datPlanillaNominaDetDTO2.setValorUnitario((datPlanillaNominaDetTmp.getValorUnitario() != null)
						? datPlanillaNominaDetTmp.getValorUnitario() : null);
				
				datPlanillaNominaDetDTO2.setTipoPersona((datPlanillaNominaDetTmp.getTipoPersona() != null)
						? datPlanillaNominaDetTmp.getTipoPersona() : null);
				
				datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(
						(datPlanillaNominaDetTmp.getConceptoNomina().getCeptoNominaId() != null)
								? datPlanillaNominaDetTmp.getConceptoNomina() : null);
			

				if (datPlanillaNominaDetTmp.getTrabajador() != null) {
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(datPlanillaNominaDetTmp.getTrabajador());
				} else {
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(null);
				}
				
				if (datPlanillaNominaDetTmp.getPersEmpr()!= null) {
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(datPlanillaNominaDetTmp.getPersEmpr());
				} else {
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(null);
				}
				
				if (datPlanillaNominaDetTmp.getPersEmpr()!= null) {
					datPlanillaNominaDetDTO2.setNombrePersEmpr(datPlanillaNominaDetTmp.getPersEmpr().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setNombrePersEmpr(null);
				}
				

				datPlanillaNominaDetDTO2
						.setUdadMedIdPago((datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getUdadMedId() != null)
								? datPlanillaNominaDetTmp.getUdadMedByUdadMedPago() : null);
				datPlanillaNominaDetDTO.add(datPlanillaNominaDetDTO2);

				datPlanillaNominaDetDTO2
						.setCodConceptoNomina((datPlanillaNominaDetTmp.getConceptoNomina().getCeptoNominaId() != null)
								? datPlanillaNominaDetTmp.getConceptoNomina().getCodigo() : null);

				if (datPlanillaNominaDetTmp.getTrabajador() != null) {
					datPlanillaNominaDetDTO2.setCodTrabajador(datPlanillaNominaDetTmp.getTrabajador().getCodigo());
				} else {
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(null);
				}

				datPlanillaNominaDetDTO2
						.setCodUmPago((datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getUdadMedId() != null)
								? datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getCodigo() : null);

				datPlanillaNominaDetDTO.add(datPlanillaNominaDetDTO2);

			}

			return datPlanillaNominaDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatPlanillaNominaDet getDatPlanillaNominaDet(Long detPlanillaNominaId) throws Exception {
		log.debug("getting DatPlanillaNominaDet instance");

		DatPlanillaNominaDet entity = null;

		try {
			entity = datPlanillaNominaDetDAO.findById(detPlanillaNominaId);
		} catch (Exception e) {
			log.error("get DatPlanillaNominaDet failed", e);
			throw new ZMessManager().new FindingException("DatPlanillaNominaDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDet> findPageDatPlanillaNominaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatPlanillaNominaDet> entity = null;

		try {
			entity = datPlanillaNominaDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanillaNominaDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatPlanillaNominaDet() throws Exception {
		Long entity = null;

		try {
			entity = datPlanillaNominaDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanillaNominaDet Count");
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
	public List<DatPlanillaNominaDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatPlanillaNominaDet> list = new ArrayList<DatPlanillaNominaDet>();
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
			list = datPlanillaNominaDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDetByNomina(Long planillaNominaId) throws Exception {
		try {
			List<DatPlanillaNominaDet> datPlanillaNominaDet = datPlanillaNominaDetDAO
					.findByCriteria("planillaNominaId.planillaNominaId= " + planillaNominaId);

			List<DatPlanillaNominaDetDTO> datPlanillaNominaDetDTO = new ArrayList<DatPlanillaNominaDetDTO>();

			for (DatPlanillaNominaDet datPlanillaNominaDetTmp : datPlanillaNominaDet) {
				DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();

				datPlanillaNominaDetDTO2.setDetPlanillaNominaId(datPlanillaNominaDetTmp.getDetPlanillaNominaId());
				datPlanillaNominaDetDTO2.setCantidadPago((datPlanillaNominaDetTmp.getCantidadPago() != null)
						? datPlanillaNominaDetTmp.getCantidadPago() : null);
				datPlanillaNominaDetDTO2.setCantidadProd((datPlanillaNominaDetTmp.getCantidadProd() != null)
						? datPlanillaNominaDetTmp.getCantidadProd() : null);
				datPlanillaNominaDetDTO2.setCostoTotal((datPlanillaNominaDetTmp.getCostoTotal() != null)
						? datPlanillaNominaDetTmp.getCostoTotal() : null);
				datPlanillaNominaDetDTO2.setEqpTrabId((datPlanillaNominaDetTmp.getEqpTrabId() != null)
						? datPlanillaNominaDetTmp.getEqpTrabId() : null);
				datPlanillaNominaDetDTO2.setValorUnitario((datPlanillaNominaDetTmp.getValorUnitario() != null)
						? datPlanillaNominaDetTmp.getValorUnitario() : null);
				
				datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(
						(datPlanillaNominaDetTmp.getPersEmpr() != null) ? datPlanillaNominaDetTmp.getPersEmpr() : null);

				if (datPlanillaNominaDetTmp.getTrabajador() != null) {
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(datPlanillaNominaDetTmp.getTrabajador());
				} else {
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(null);
				}
				
				if (datPlanillaNominaDetTmp.getConceptoNomina() != null) {
					datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(datPlanillaNominaDetTmp.getConceptoNomina());
				} else {
					datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(null);
				}

				datPlanillaNominaDetDTO2
						.setUdadMedIdPago((datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getUdadMedId() != null)
								? datPlanillaNominaDetTmp.getUdadMedByUdadMedPago() : null);
				
				datPlanillaNominaDetDTO2.setTipoPersona((datPlanillaNominaDetTmp.getTipoPersona() != null)
						? datPlanillaNominaDetTmp.getTipoPersona() : null);

				if (datPlanillaNominaDetTmp.getConceptoNomina() != null) {
					datPlanillaNominaDetDTO2.setCodConceptoNomina(datPlanillaNominaDetTmp.getConceptoNomina().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setCodConceptoNomina(null);
				}
				
				if (datPlanillaNominaDetTmp.getTrabajador() != null) {
					datPlanillaNominaDetDTO2.setCodTrabajador(datPlanillaNominaDetTmp.getTrabajador().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setCodTrabajador(null);
				}

				datPlanillaNominaDetDTO2
						.setCodUmPago((datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getUdadMedId() != null)
								? datPlanillaNominaDetTmp.getUdadMedByUdadMedPago().getCodigo() : null);

				datPlanillaNominaDetDTO2.setCantidadDescontar((datPlanillaNominaDetTmp.getCantidadDescontar() != null)
						? datPlanillaNominaDetTmp.getCantidadDescontar() : null);
				datPlanillaNominaDetDTO2.setEstadoIncidencia((datPlanillaNominaDetTmp.getEstadoIncidencia() != null)
						? datPlanillaNominaDetTmp.getEstadoIncidencia() : null);
				
				datPlanillaNominaDetDTO2.setAlturaPlanta((datPlanillaNominaDetTmp.getAlturaPlanta() != null)
						? datPlanillaNominaDetTmp.getAlturaPlanta() : null);
				
				
				datPlanillaNominaDetDTO2.setPesoPromedio((datPlanillaNominaDetTmp.getPesoPromedio() != null)
						? datPlanillaNominaDetTmp.getPesoPromedio() : null);
				
				datPlanillaNominaDetDTO2.setNumeroTiquete((datPlanillaNominaDetTmp.getNumeroTiquete() != null)
						? datPlanillaNominaDetTmp.getNumeroTiquete() : null);
				
				
				
				
				if (datPlanillaNominaDetTmp.getNivel2Id() != null) {
					datPlanillaNominaDetDTO2.setNivel2Id(datPlanillaNominaDetTmp.getNivel2Id());
				} else {
					datPlanillaNominaDetDTO2.setNivel2Id(null);
				}

				if (datPlanillaNominaDetTmp.getNivel4() != null) {
					datPlanillaNominaDetDTO2.setNivel4(datPlanillaNominaDetTmp.getNivel4());
				} else {
					datPlanillaNominaDetDTO2.setNivel4(null);
				}

				if (datPlanillaNominaDetTmp.getNivel2Id() != null) {
					datPlanillaNominaDetDTO2.setNombreNivel2(datPlanillaNominaDetTmp.getNivel2Id().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setNombreNivel2(null);
				}

				if (datPlanillaNominaDetTmp.getNivel4() != null) {
					datPlanillaNominaDetDTO2.setNombreNivel4(datPlanillaNominaDetTmp.getNivel4().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setNombreNivel4(null);
				}

				
				if (datPlanillaNominaDetTmp.getLaborId() != null) {
					datPlanillaNominaDetDTO2.setLaborId(datPlanillaNominaDetTmp.getLaborId());
				} else {
					datPlanillaNominaDetDTO2.setLaborId(null);
				}
				
				if (datPlanillaNominaDetTmp.getOrdenTrabajo() != null) {
					datPlanillaNominaDetDTO2.setOrdenTrabajo(datPlanillaNominaDetTmp.getOrdenTrabajo());
				} else {
					datPlanillaNominaDetDTO2.setOrdenTrabajo(null);
				}
				
				if (datPlanillaNominaDetTmp.getLaborId() != null) {
					datPlanillaNominaDetDTO2.setNombreLabor(datPlanillaNominaDetTmp.getLaborId().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setNombreLabor(null);
				}
				
				 datPlanillaNominaDetDTO2.setTipoServicio((datPlanillaNominaDetTmp.getTipoServicio() != null)
	                        ? datPlanillaNominaDetTmp.getTipoServicio() : null);
			    datPlanillaNominaDetDTO2.setCantidadMaq((datPlanillaNominaDetTmp.getCantidadMaq() != null)
                        ? datPlanillaNominaDetTmp.getCantidadMaq() : null);
                datPlanillaNominaDetDTO2.setHorometroFinal((datPlanillaNominaDetTmp.getHorometroFinal() != null)
                    ? datPlanillaNominaDetTmp.getHorometroFinal() : null);
                datPlanillaNominaDetDTO2.setHorometroInicial((datPlanillaNominaDetTmp.getHorometroInicial() != null)
                    ? datPlanillaNominaDetTmp.getHorometroInicial() : null);
                datPlanillaNominaDetDTO2.setHorometroTotal((datPlanillaNominaDetTmp.getHorometroTotal() != null)
                    ? datPlanillaNominaDetTmp.getHorometroTotal() : null);
                datPlanillaNominaDetDTO2.setValorTotalMaq((datPlanillaNominaDetTmp.getValorTotalMaq() != null)
                    ? datPlanillaNominaDetTmp.getValorTotalMaq() : null);
                datPlanillaNominaDetDTO2.setValorUnitario((datPlanillaNominaDetTmp.getValorUnitario() != null)
                    ? datPlanillaNominaDetTmp.getValorUnitario() : null);

                
                if (datPlanillaNominaDetTmp.getUdadMedMaq() != null) {
                    datPlanillaNominaDetDTO2.setUdadMedMaq(datPlanillaNominaDetTmp.getUdadMedMaq());
                } else {
                    datPlanillaNominaDetDTO2.setUdadMedMaq(null);
                }
                
                if (datPlanillaNominaDetTmp.getUdadMedMaq() != null) {
                    datPlanillaNominaDetDTO2.setNomUdadMedMaq(datPlanillaNominaDetTmp.getUdadMedMaq()
                                                                                                 .getNombre());
                } else {
                    datPlanillaNominaDetDTO2.setNomUdadMedMaq(null);
                }
				
                
                if (datPlanillaNominaDetTmp.getEquipoId() != null) {
                    datPlanillaNominaDetDTO2.setEquipoId(datPlanillaNominaDetTmp.getEquipoId());
                } else {
                    datPlanillaNominaDetDTO2.setEquipoId(null);
                }
                
                if (datPlanillaNominaDetTmp.getEquipoId() != null) {
                    datPlanillaNominaDetDTO2.setNombreEquipo(datPlanillaNominaDetTmp.getEquipoId()
                                                                                                 .getCodigo());
                } else {
                    datPlanillaNominaDetDTO2.setNombreEquipo(null);
                }
                

                if (datPlanillaNominaDetTmp.getImplementoId() != null) {
                    datPlanillaNominaDetDTO2.setImplementoId(datPlanillaNominaDetTmp.getImplementoId());
                } else {
                    datPlanillaNominaDetDTO2.setImplementoId(null);
                }
                
                if (datPlanillaNominaDetTmp.getImplementoId() != null) {
                    datPlanillaNominaDetDTO2.setNombreImplemento(datPlanillaNominaDetTmp.getImplementoId()
                                                                                                 .getCodigo());
                } else {
                    datPlanillaNominaDetDTO2.setNombreImplemento(null);
                }
                
            	if (datPlanillaNominaDetTmp.getPersEmpr()!= null) {
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(datPlanillaNominaDetTmp.getPersEmpr());
				} else {
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(null);
				}
				
				if (datPlanillaNominaDetTmp.getPersEmpr()!= null) {
					datPlanillaNominaDetDTO2.setNombrePersEmpr(datPlanillaNominaDetTmp.getPersEmpr().getNombre());
				} else {
					datPlanillaNominaDetDTO2.setNombrePersEmpr(null);
				}
				
				
				datPlanillaNominaDetDTO.add(datPlanillaNominaDetDTO2);

			}

			return datPlanillaNominaDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
