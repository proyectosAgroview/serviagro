
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

import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatNominaTrabajadorDet;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatNominaTrabajadorDetLogic")
public class DatNominaTrabajadorDetLogic implements IDatNominaTrabajadorDetLogic {
	private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorDetLogic.class);

	/**
	 * DAO injected by Spring that manages DatNominaTrabajadorDet entities
	 *
	 */
	@Autowired
	private IDatNominaTrabajadorDetDAO datNominaTrabajadorDetDAO;

	/**
	 * Logic injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	IConceptoNominaLogic logicConceptoNomina1;

	/**
	 * Logic injected by Spring that manages DatNominaTrabajador entities
	 *
	 */
	@Autowired
	IDatNominaTrabajadorLogic logicDatNominaTrabajador2;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador3;

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorDet> getDatNominaTrabajadorDet() throws Exception {
		log.debug("finding all DatNominaTrabajadorDet instances");

		List<DatNominaTrabajadorDet> list = new ArrayList<DatNominaTrabajadorDet>();

		try {
			list = datNominaTrabajadorDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatNominaTrabajadorDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatNominaTrabajadorDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		log.debug("saving DatNominaTrabajadorDet instance");

		try {
			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new ForeignException("conceptoNomina");
			}

			if (entity.getDatNominaTrabajador() == null) {
				throw new ZMessManager().new ForeignException("datNominaTrabajador");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getDatNominaTrabajadorDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorDetId");
			}

			if ((entity.getDatNominaTrabajadorDetId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatNominaTrabajadorDetId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datNominaTrabajadorDetId");
			}

			if ((entity.getValorTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorTotal");
			}

			if (entity.getConceptoNomina().getCeptoNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId_ConceptoNomina");
			}

			if ((entity.getConceptoNomina().getCeptoNominaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getConceptoNomina().getCeptoNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ceptoNominaId_ConceptoNomina");
			}

			if (entity.getDatNominaTrabajador().getDatNominaTrabajadorId() == null) {
				throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorId_DatNominaTrabajador");
			}

			if ((entity.getDatNominaTrabajador().getDatNominaTrabajadorId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatNominaTrabajador().getDatNominaTrabajadorId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datNominaTrabajadorId_DatNominaTrabajador");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			if (getDatNominaTrabajadorDet(entity.getDatNominaTrabajadorDetId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datNominaTrabajadorDetDAO.save(entity);

			log.debug("save DatNominaTrabajadorDet successful");
		} catch (Exception e) {
			log.error("save DatNominaTrabajadorDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		log.debug("deleting DatNominaTrabajadorDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatNominaTrabajadorDet");
		}

		if (entity.getDatNominaTrabajadorDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorDetId");
		}

		try {
			datNominaTrabajadorDetDAO.delete(entity);

			log.debug("delete DatNominaTrabajadorDet successful");
		} catch (Exception e) {
			log.error("delete DatNominaTrabajadorDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		log.debug("updating DatNominaTrabajadorDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatNominaTrabajadorDet");
			}

			if (entity.getConceptoNomina() == null) {
				throw new ZMessManager().new ForeignException("conceptoNomina");
			}

			if (entity.getDatNominaTrabajador() == null) {
				throw new ZMessManager().new ForeignException("datNominaTrabajador");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getDatNominaTrabajadorDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorDetId");
			}

			if ((entity.getDatNominaTrabajadorDetId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatNominaTrabajadorDetId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datNominaTrabajadorDetId");
			}

			if ((entity.getValorTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorTotal");
			}

			if (entity.getConceptoNomina().getCeptoNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("ceptoNominaId_ConceptoNomina");
			}

			if ((entity.getConceptoNomina().getCeptoNominaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getConceptoNomina().getCeptoNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ceptoNominaId_ConceptoNomina");
			}

			if (entity.getDatNominaTrabajador().getDatNominaTrabajadorId() == null) {
				throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorId_DatNominaTrabajador");
			}

			if ((entity.getDatNominaTrabajador().getDatNominaTrabajadorId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatNominaTrabajador().getDatNominaTrabajadorId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datNominaTrabajadorId_DatNominaTrabajador");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			datNominaTrabajadorDetDAO.update(entity);

			log.debug("update DatNominaTrabajadorDet successful");
		} catch (Exception e) {
			log.error("update DatNominaTrabajadorDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDet() throws Exception {
		try {
			List<DatNominaTrabajadorDet> datNominaTrabajadorDet = datNominaTrabajadorDetDAO.findAll();

			List<DatNominaTrabajadorDetDTO> datNominaTrabajadorDetDTO = new ArrayList<DatNominaTrabajadorDetDTO>();

			for (DatNominaTrabajadorDet datNominaTrabajadorDetTmp : datNominaTrabajadorDet) {
				DatNominaTrabajadorDetDTO datNominaTrabajadorDetDTO2 = new DatNominaTrabajadorDetDTO();

				datNominaTrabajadorDetDTO2
						.setDatNominaTrabajadorDetId(datNominaTrabajadorDetTmp.getDatNominaTrabajadorDetId());
				datNominaTrabajadorDetDTO2.setValorTotal((datNominaTrabajadorDetTmp.getValorTotal() != null)
						? datNominaTrabajadorDetTmp.getValorTotal() : null);
				datNominaTrabajadorDetDTO2.setCeptoNominaId_ConceptoNomina(
						(datNominaTrabajadorDetTmp.getConceptoNomina().getCeptoNominaId() != null)
								? datNominaTrabajadorDetTmp.getConceptoNomina() : null);
				datNominaTrabajadorDetDTO2.setDatNominaTrabajadorId_DatNominaTrabajador(
						(datNominaTrabajadorDetTmp.getDatNominaTrabajador().getDatNominaTrabajadorId() != null)
								? datNominaTrabajadorDetTmp.getDatNominaTrabajador().getDatNominaTrabajadorId() : null);

				if (datNominaTrabajadorDetTmp.getTrabajador() != null) {
					datNominaTrabajadorDetDTO2.setTrabId_Trabajador(datNominaTrabajadorDetTmp.getTrabajador());
				} else {
					datNominaTrabajadorDetDTO2.setTrabId_Trabajador(null);
				}

				datNominaTrabajadorDetDTO.add(datNominaTrabajadorDetDTO2);
			}

			return datNominaTrabajadorDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatNominaTrabajadorDet getDatNominaTrabajadorDet(Long datNominaTrabajadorDetId) throws Exception {
		log.debug("getting DatNominaTrabajadorDet instance");

		DatNominaTrabajadorDet entity = null;

		try {
			entity = datNominaTrabajadorDetDAO.findById(datNominaTrabajadorDetId);
		} catch (Exception e) {
			log.error("get DatNominaTrabajadorDet failed", e);
			throw new ZMessManager().new FindingException("DatNominaTrabajadorDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorDet> findPageDatNominaTrabajadorDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatNominaTrabajadorDet> entity = null;

		try {
			entity = datNominaTrabajadorDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatNominaTrabajadorDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatNominaTrabajadorDet() throws Exception {
		Long entity = null;

		try {
			entity = datNominaTrabajadorDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatNominaTrabajadorDet Count");
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
	public List<DatNominaTrabajadorDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatNominaTrabajadorDet> list = new ArrayList<DatNominaTrabajadorDet>();
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
			list = datNominaTrabajadorDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDetByNomina(Long idNomina) throws Exception {
		try {
			List<DatNominaTrabajadorDet> datNominaTrabajadorDet = datNominaTrabajadorDetDAO
					.findByCriteria("datNominaTrabajador.datNominaTrabajadorId= " + idNomina);
			List<DatNominaTrabajadorDetDTO> datNominaTrabajadorDetDTO = new ArrayList<DatNominaTrabajadorDetDTO>();

			for (DatNominaTrabajadorDet datNominaTrabajadorDetTmp : datNominaTrabajadorDet) {
				DatNominaTrabajadorDetDTO datNominaTrabajadorDetDTO2 = new DatNominaTrabajadorDetDTO();

				datNominaTrabajadorDetDTO2
						.setDatNominaTrabajadorDetId(datNominaTrabajadorDetTmp.getDatNominaTrabajadorDetId());
				
				datNominaTrabajadorDetDTO2.setValorTotal((datNominaTrabajadorDetTmp.getValorTotal() != null)
						? datNominaTrabajadorDetTmp.getValorTotal() : 0.0);
				
				datNominaTrabajadorDetDTO2.setValorDeduccion((datNominaTrabajadorDetTmp.getValorDeduccion() != null)
						? datNominaTrabajadorDetTmp.getValorDeduccion() : 0.0);
				
				datNominaTrabajadorDetDTO2.setTipoMovimiento((datNominaTrabajadorDetTmp.getTipoMovimiento() != null)
						? datNominaTrabajadorDetTmp.getTipoMovimiento() : null);
				
				datNominaTrabajadorDetDTO2.setDatNominaTrabajadorId_DatNominaTrabajador(
						(datNominaTrabajadorDetTmp.getDatNominaTrabajador().getDatNominaTrabajadorId() != null)
								? datNominaTrabajadorDetTmp.getDatNominaTrabajador().getDatNominaTrabajadorId() : null);
				
				if (datNominaTrabajadorDetTmp.getConceptoNomina() != null) {
					datNominaTrabajadorDetDTO2.setCeptoNominaId_ConceptoNomina(datNominaTrabajadorDetTmp.getConceptoNomina());
				} else {
					datNominaTrabajadorDetDTO2.setCeptoNominaId_ConceptoNomina(null);
				}

				if (datNominaTrabajadorDetTmp.getConceptoNomina() != null) {
					datNominaTrabajadorDetDTO2.setNombreConceptoNomina(datNominaTrabajadorDetTmp.getConceptoNomina().getNombre());
				} else {
					datNominaTrabajadorDetDTO2.setNombreConceptoNomina(null);
				}

				if (datNominaTrabajadorDetTmp.getTrabajador() != null) {
					datNominaTrabajadorDetDTO2.setTrabId_Trabajador(datNominaTrabajadorDetTmp.getTrabajador());
				} else {
					datNominaTrabajadorDetDTO2.setTrabId_Trabajador(null);
				}

				if (datNominaTrabajadorDetTmp.getTrabajador() != null) {
					datNominaTrabajadorDetDTO2.setNombreTrabajador(datNominaTrabajadorDetTmp.getTrabajador().getNombre());
				} else {
					datNominaTrabajadorDetDTO2.setNombreTrabajador(null);
				}
				
				if (datNominaTrabajadorDetTmp.getUdadMedId() != null) {
					datNominaTrabajadorDetDTO2.setNombreUdadMed(datNominaTrabajadorDetTmp.getUdadMedId().getNombre());
				} else {
					datNominaTrabajadorDetDTO2.setNombreUdadMed(null);
				}
				
				if (datNominaTrabajadorDetTmp.getUdadMedId() != null) {
					datNominaTrabajadorDetDTO2 .setUdadMedId(datNominaTrabajadorDetTmp.getUdadMedId());
				} else {
					datNominaTrabajadorDetDTO2.setUdadMedId(null);
				}

				if (datNominaTrabajadorDetTmp.getCantidad() != null) {
					datNominaTrabajadorDetDTO2.setCantidad(datNominaTrabajadorDetTmp.getCantidad());
				} else {
					datNominaTrabajadorDetDTO2.setCantidad(null);
				}
				
				
				datNominaTrabajadorDetDTO.add(datNominaTrabajadorDetDTO2);
			}

			return datNominaTrabajadorDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
