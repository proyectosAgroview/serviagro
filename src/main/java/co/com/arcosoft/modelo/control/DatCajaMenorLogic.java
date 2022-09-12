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

import co.com.arcosoft.dataaccess.dao.IDatCajaMenorDAO;
import co.com.arcosoft.dataaccess.dao.IDatCajaMenorDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatCajaMenor;
import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.DatCajaMenorDTO;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatCajaMenorLogic")
public class DatCajaMenorLogic implements IDatCajaMenorLogic {
	private static final Logger log = LoggerFactory.getLogger(DatCajaMenorLogic.class);

	/**
	 * DAO injected by Spring that manages DatCajaMenor entities
	 *
	 */
	@Autowired
	private IDatCajaMenorDAO datCajaMenorDAO;

	/**
	 * DAO injected by Spring that manages DatCajaMenorDet entities
	 *
	 */
	@Autowired
	private IDatCajaMenorDetDAO datCajaMenorDetDAO;
    @Autowired
    ICentCostLogic logicCentCost1;
 
	/**
	 * Logic injected by Spring that manages CajaMenor entities
	 *
	 */
	@Autowired
	ICajaMenorLogic logicCajaMenor1;
    @Autowired
    IEquipoLogic logicImplemento;
	@Transactional(readOnly = true)
	public List<DatCajaMenor> getDatCajaMenor() throws Exception {
		log.debug("finding all DatCajaMenor instances");

		List<DatCajaMenor> list = new ArrayList<DatCajaMenor>();

		try {
			list = datCajaMenorDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatCajaMenor failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatCajaMenor");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception {
		log.debug("saving DatCajaMenor instance");

		try {
			if (entity.getCajaMenor() == null) {
				throw new ZMessManager().new ForeignException("cajaMenor");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if (entity.getCajaMenor().getCajaMenorId() == null) {
				throw new ZMessManager().new EmptyFieldException("cajaMenorId_CajaMenor");
			}

			datCajaMenorDAO.save(entity);

			if (dataCajaMenor != null) {

				for (DatCajaMenorDetDTO valorDto : dataCajaMenor) {

					if (valorDto.getDatCajaMenordetId() == null) {

						DatCajaMenorDet valor = new DatCajaMenorDet();

						valor.setValor(valorDto.getValor());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setDatCajaMenor(entity);
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							}
						valor.setNumFactura(valorDto.getNumFactura());
						datCajaMenorDetDAO.save(valor);
					}

				}
			}
			log.debug("save DatCajaMenor successful");
		} catch (Exception e) {
			log.error("save DatCajaMenor failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatCajaMenor(DatCajaMenor entity) throws Exception {
		log.debug("deleting DatCajaMenor instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatCajaMenor");
		}

		if (entity.getDatCajaMenorId() == null) {
			throw new ZMessManager().new EmptyFieldException("datCajaMenorId");
		}

		List<DatCajaMenorDet> datCajaMenorDets = null;

		try {
			datCajaMenorDets = datCajaMenorDetDAO.findByProperty("datCajaMenor.datCajaMenorId",
					entity.getDatCajaMenorId());

			if (Utilities.validationsList(datCajaMenorDets) == true) {
				throw new ZMessManager().new DeletingException("datCajaMenorDets");
			}

			datCajaMenorDAO.delete(entity);

			log.debug("delete DatCajaMenor successful");
		} catch (Exception e) {
			log.error("delete DatCajaMenor failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception {
		log.debug("updating DatCajaMenor instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatCajaMenor");
			}

			if (entity.getCajaMenor() == null) {
				throw new ZMessManager().new ForeignException("cajaMenor");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if (entity.getCajaMenor().getCajaMenorId() == null) {
				throw new ZMessManager().new EmptyFieldException("cajaMenorId_CajaMenor");
			}

			datCajaMenorDAO.update(entity);
			if (dataCajaMenor != null) {

				for (DatCajaMenorDetDTO valorDto : dataCajaMenor) {

					if (valorDto.getDatCajaMenordetId() == null) { // crear el
																	// valor
																	// nuevo

						DatCajaMenorDet valor = new DatCajaMenorDet();
						valor.setValor(valorDto.getValor());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setDatCajaMenor(entity);
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						datCajaMenorDetDAO.save(valor);

					} else {
						DatCajaMenorDet valor = datCajaMenorDetDAO.findById(valorDto.getDatCajaMenordetId());
						valor.setValor(valorDto.getValor());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setDatCajaMenor(entity);
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							}
						valor.setNumFactura(valorDto.getNumFactura());
						datCajaMenorDetDAO.update(valor);
					}

				}
			}
			log.debug("update DatCajaMenor successful");
		} catch (Exception e) {
			log.error("update DatCajaMenor failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatCajaMenorDTO> getDataDatCajaMenor() throws Exception {
		try {
			List<DatCajaMenor> datCajaMenor = datCajaMenorDAO.findAll();

			List<DatCajaMenorDTO> datCajaMenorDTO = new ArrayList<DatCajaMenorDTO>();

			for (DatCajaMenor datCajaMenorTmp : datCajaMenor) {
				DatCajaMenorDTO datCajaMenorDTO2 = new DatCajaMenorDTO();

				datCajaMenorDTO2.setDatCajaMenorId(datCajaMenorTmp.getDatCajaMenorId());
				datCajaMenorDTO2
						.setCompania((datCajaMenorTmp.getCompania() != null) ? datCajaMenorTmp.getCompania() : null);
				datCajaMenorDTO2.setConsecutivo(
						(datCajaMenorTmp.getConsecutivo() != null) ? datCajaMenorTmp.getConsecutivo() : null);
				datCajaMenorDTO2.setEstado((datCajaMenorTmp.getEstado() != null) ? datCajaMenorTmp.getEstado() : null);
				datCajaMenorDTO2.setFechaAnulacion(datCajaMenorTmp.getFechaAnulacion());
				datCajaMenorDTO2.setFechaCreacion(datCajaMenorTmp.getFechaCreacion());
				datCajaMenorDTO2.setFechaModificacion(datCajaMenorTmp.getFechaModificacion());
				datCajaMenorDTO2.setFechaRegistro(datCajaMenorTmp.getFechaRegistro());
				datCajaMenorDTO2.setObservacion(
						(datCajaMenorTmp.getObservacion() != null) ? datCajaMenorTmp.getObservacion() : null);
				datCajaMenorDTO2.setObservacionAnularReg(
						(datCajaMenorTmp.getObservacionAnularReg() != null) ? datCajaMenorTmp.getObservacionAnularReg()
								: null);
				datCajaMenorDTO2.setUsuarioDigitacion(
						(datCajaMenorTmp.getUsuarioDigitacion() != null) ? datCajaMenorTmp.getUsuarioDigitacion()
								: null);
				datCajaMenorDTO2.setCajaMenorId_CajaMenor((datCajaMenorTmp.getCajaMenor().getCajaMenorId() != null)
						? datCajaMenorTmp.getCajaMenor().getCajaMenorId()
						: null);

				if (datCajaMenorTmp.getCajaMenor() != null) {
					datCajaMenorDTO2.setNombreCajaMenor(datCajaMenorTmp.getCajaMenor().getNombre());
				} else {
					datCajaMenorDTO2.setNombreCajaMenor(null);
				}
				datCajaMenorDTO2.setCentCostId((datCajaMenorTmp.getCentCostId() != null)
						? datCajaMenorTmp.getCentCostId()
						: null);

				datCajaMenorDTO.add(datCajaMenorDTO2);
			}

			return datCajaMenorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatCajaMenor getDatCajaMenor(Long datCajaMenorId) throws Exception {
		log.debug("getting DatCajaMenor instance");

		DatCajaMenor entity = null;

		try {
			entity = datCajaMenorDAO.findById(datCajaMenorId);
		} catch (Exception e) {
			log.error("get DatCajaMenor failed", e);
			throw new ZMessManager().new FindingException("DatCajaMenor");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatCajaMenor> findPageDatCajaMenor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatCajaMenor> entity = null;

		try {
			entity = datCajaMenorDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatCajaMenor Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatCajaMenor() throws Exception {
		Long entity = null;

		try {
			entity = datCajaMenorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatCajaMenor Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles                 este arreglo debera tener:
	 *
	 *                                 [0] = String variable = (String) varibles[i];
	 *                                 representa como se llama la variable en el
	 *                                 pojo
	 *
	 *                                 [1] = Boolean booVariable = (Boolean)
	 *                                 varibles[i + 1]; representa si el valor
	 *                                 necesita o no ''(comillas simples)usado para
	 *                                 campos de tipo string
	 *
	 *                                 [2] = Object value = varibles[i + 2];
	 *                                 representa el valor que se va a buscar en la
	 *                                 BD
	 *
	 *                                 [3] = String comparator = (String) varibles[i
	 *                                 + 3]; representa que tipo de busqueda voy a
	 *                                 hacer.., ejemplo: where nombre=william o
	 *                                 where nombre<>william, en este campo iria el
	 *                                 tipo de comparador que quiero si es = o <>
	 *
	 *                                 Se itera de 4 en 4..., entonces 4 registros
	 *                                 del arreglo representan 1 busqueda en un
	 *                                 campo, si se ponen mas pues el continuara
	 *                                 buscando en lo que se le ingresen en los
	 *                                 otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                                 la diferencia son estas dos posiciones
	 *
	 *                                 [0] = String variable = (String) varibles[j];
	 *                                 la variable ne la BD que va a ser buscada en
	 *                                 un rango
	 *
	 *                                 [1] = Object value = varibles[j + 1]; valor 1
	 *                                 para buscar en un rango
	 *
	 *                                 [2] = Object value2 = varibles[j + 2]; valor
	 *                                 2 para buscar en un rango ejempolo: a > 1 and
	 *                                 a < 5 --> 1 seria value y 5 seria value2
	 *
	 *                                 [3] = String comparator1 = (String)
	 *                                 varibles[j + 3]; comparador 1 ejemplo: a
	 *                                 comparator1 1 and a < 5
	 *
	 *                                 [4] = String comparator2 = (String)
	 *                                 varibles[j + 4]; comparador 2 ejemplo: a
	 *                                 comparador1>1 and a comparador2<5 (el
	 *                                 original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en este caso solo para mysql) [0] = String
	 *                                 variable = (String) varibles[k]; el nombre de
	 *                                 la variable que hace referencia a una fecha
	 *
	 *                                 [1] = Object object1 = varibles[k + 2]; fecha
	 *                                 1 a comparar(deben ser dates)
	 *
	 *                                 [2] = Object object2 = varibles[k + 3]; fecha
	 *                                 2 a comparar(deben ser dates)
	 *
	 *                                 esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<DatCajaMenor> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatCajaMenor> list = new ArrayList<DatCajaMenor>();
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
			list = datCajaMenorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
