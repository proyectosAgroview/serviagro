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

import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorMqDAO;
import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorMqdetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatNominaTrabajadorMq;
import co.com.arcosoft.modelo.DatNominaTrabajadorMqdet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatNominaTrabajadorMqLogic")
public class DatNominaTrabajadorMqLogic implements IDatNominaTrabajadorMqLogic {
    private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorMqLogic.class);

    /**
     * DAO injected by Spring that manages DatNominaTrabajadorMq entities
     *
     */
    @Autowired
    private IDatNominaTrabajadorMqDAO datNominaTrabajadorMqDAO;

    /**
    * DAO injected by Spring that manages DatNominaTrabajadorMqdet entities
    *
    */
    @Autowired
    private IDatNominaTrabajadorMqdetDAO datNominaTrabajadorMqdetDAO;

    @Autowired
    ICentCostLogic logicCentCost1;
 
    @Autowired
    IEquipoLogic logicEquipo;

    
    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMq> getDatNominaTrabajadorMq()
        throws Exception {
        log.debug("finding all DatNominaTrabajadorMq instances");

        List<DatNominaTrabajadorMq> list = new ArrayList<DatNominaTrabajadorMq>();

        try {
            list = datNominaTrabajadorMqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatNominaTrabajadorMq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatNominaTrabajadorMq");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador)
        throws Exception {
        log.debug("saving DatNominaTrabajadorMq instance");

        try {
            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }


            datNominaTrabajadorMqDAO.save(entity);

			if (dataNominaTrabajador != null) {

				for (DatNominaTrabajadorMqdetDTO valorDto : dataNominaTrabajador) {

					if (valorDto.getDatNominaTrabajadorMqdetId() == null) {

						DatNominaTrabajadorMqdet valor = new DatNominaTrabajadorMqdet();

						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setFechaInicialVac(valorDto.getFechaInicialVac());

						valor.setFechaFinalVac(valorDto.getFechaFinalVac());
						valor.setDatNominaTrabajadorMq(entity);
						
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}

						if( valorDto.getEquipoId()!=null) {
							Long equipoId = valorDto.getEquipoId();
							Equipo equipo =   logicEquipo.getEquipo(equipoId);
							valor.setEquipoId(equipo);	
						}


						
						datNominaTrabajadorMqdetDAO.save(valor);
					}

				}
			}

            log.debug("save DatNominaTrabajadorMq successful");
        } catch (Exception e) {
            log.error("save DatNominaTrabajadorMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatNominaTrabajadorMq(DatNominaTrabajadorMq entity)
        throws Exception {
        log.debug("deleting DatNominaTrabajadorMq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatNominaTrabajadorMq");
        }

        if (entity.getDatNominaTrabajadorMqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datNominaTrabajadorMqId");
        }

        List<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdets = null;

        try {
            datNominaTrabajadorMqdets = datNominaTrabajadorMqdetDAO.findByProperty("datNominaTrabajadorMq.datNominaTrabajadorMqId",
                    entity.getDatNominaTrabajadorMqId());

            if (Utilities.validationsList(datNominaTrabajadorMqdets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datNominaTrabajadorMqdets");
            }

            datNominaTrabajadorMqDAO.delete(entity);

            log.debug("delete DatNominaTrabajadorMq successful");
        } catch (Exception e) {
            log.error("delete DatNominaTrabajadorMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador)
        throws Exception {
        log.debug("updating DatNominaTrabajadorMq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatNominaTrabajadorMq");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            datNominaTrabajadorMqDAO.update(entity);
			if (dataNominaTrabajador != null) {
				for (DatNominaTrabajadorMqdetDTO valorDto : dataNominaTrabajador) {

					if (valorDto.getDatNominaTrabajadorMqdetId() == null) { // crear
																			// el
																			// valor
						// nuevo

						DatNominaTrabajadorMqdet valor = new DatNominaTrabajadorMqdet();

						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setFechaInicialVac(valorDto.getFechaInicialVac());

						valor.setFechaFinalVac(valorDto.getFechaFinalVac());
						valor.setDatNominaTrabajadorMq(entity);
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if( valorDto.getEquipoId()!=null) {
							Long equipoId = valorDto.getEquipoId();
							Equipo equipo =   logicEquipo.getEquipo(equipoId);
							valor.setEquipoId(equipo);	
						}

						datNominaTrabajadorMqdetDAO.save(valor);

					} else {
						DatNominaTrabajadorMqdet valor = datNominaTrabajadorMqdetDAO
								.findById(valorDto.getDatNominaTrabajadorMqdetId());

						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setFechaInicialVac(valorDto.getFechaInicialVac());

						valor.setFechaFinalVac(valorDto.getFechaFinalVac());
						valor.setDatNominaTrabajadorMq(entity);

						if( valorDto.getEquipoId()!=null) {
							Long equipoId = valorDto.getEquipoId();
							Equipo equipo =   logicEquipo.getEquipo(equipoId);
							valor.setEquipoId(equipo);	
						}

						datNominaTrabajadorMqdetDAO.update(valor);
					}

				}
			}

            log.debug("update DatNominaTrabajadorMq successful");
        } catch (Exception e) {
            log.error("update DatNominaTrabajadorMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMqDTO> getDataDatNominaTrabajadorMq()
        throws Exception {
        try {
            List<DatNominaTrabajadorMq> datNominaTrabajadorMq = datNominaTrabajadorMqDAO.findAll();

            List<DatNominaTrabajadorMqDTO> datNominaTrabajadorMqDTO = new ArrayList<DatNominaTrabajadorMqDTO>();

            for (DatNominaTrabajadorMq datNominaTrabajadorMqTmp : datNominaTrabajadorMq) {
                DatNominaTrabajadorMqDTO datNominaTrabajadorMqDTO2 = new DatNominaTrabajadorMqDTO();

                datNominaTrabajadorMqDTO2.setDatNominaTrabajadorMqId(datNominaTrabajadorMqTmp.getDatNominaTrabajadorMqId());
                datNominaTrabajadorMqDTO2.setCompania((datNominaTrabajadorMqTmp.getCompania() != null)
                    ? datNominaTrabajadorMqTmp.getCompania() : null);
                datNominaTrabajadorMqDTO2.setConsecutivo((datNominaTrabajadorMqTmp.getConsecutivo() != null)
                    ? datNominaTrabajadorMqTmp.getConsecutivo() : null);
                datNominaTrabajadorMqDTO2.setEstado((datNominaTrabajadorMqTmp.getEstado() != null)
                    ? datNominaTrabajadorMqTmp.getEstado() : null);
                datNominaTrabajadorMqDTO2.setFechaAnulacion(datNominaTrabajadorMqTmp.getFechaAnulacion());
                datNominaTrabajadorMqDTO2.setFechaCreacion(datNominaTrabajadorMqTmp.getFechaCreacion());
                datNominaTrabajadorMqDTO2.setFechaFinal(datNominaTrabajadorMqTmp.getFechaFinal());
                datNominaTrabajadorMqDTO2.setFechaInicial(datNominaTrabajadorMqTmp.getFechaInicial());
                datNominaTrabajadorMqDTO2.setFechaModificacion(datNominaTrabajadorMqTmp.getFechaModificacion());
                datNominaTrabajadorMqDTO2.setInfoAdicional((datNominaTrabajadorMqTmp.getInfoAdicional() != null)
                    ? datNominaTrabajadorMqTmp.getInfoAdicional() : null);
                datNominaTrabajadorMqDTO2.setInfoAdicional2((datNominaTrabajadorMqTmp.getInfoAdicional2() != null)
                    ? datNominaTrabajadorMqTmp.getInfoAdicional2() : null);
                datNominaTrabajadorMqDTO2.setObservacion((datNominaTrabajadorMqTmp.getObservacion() != null)
                    ? datNominaTrabajadorMqTmp.getObservacion() : null);
                datNominaTrabajadorMqDTO2.setObservacionAnularReg((datNominaTrabajadorMqTmp.getObservacionAnularReg() != null)
                    ? datNominaTrabajadorMqTmp.getObservacionAnularReg() : null);
                datNominaTrabajadorMqDTO2.setUsuarioDigitacion((datNominaTrabajadorMqTmp.getUsuarioDigitacion() != null)
                    ? datNominaTrabajadorMqTmp.getUsuarioDigitacion() : null);
                
                datNominaTrabajadorMqDTO2.setEstadoNomina((datNominaTrabajadorMqTmp.getEstadoNomina() != null)
                        ? datNominaTrabajadorMqTmp.getEstadoNomina() : null);
                
                datNominaTrabajadorMqDTO2.setTipoNomina((datNominaTrabajadorMqTmp.getTipoNomina() != null)
                        ? datNominaTrabajadorMqTmp.getTipoNomina() : null);
                 
                
                String estadoTrue="false";
                if(datNominaTrabajadorMqTmp.getEstadoNomina().equals("CERRADA")) {
                	estadoTrue="true";
                }
                datNominaTrabajadorMqDTO2.setEstadoTrue(estadoTrue);
                
                datNominaTrabajadorMqDTO.add(datNominaTrabajadorMqDTO2);
            }

            return datNominaTrabajadorMqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatNominaTrabajadorMq getDatNominaTrabajadorMq(
        Long datNominaTrabajadorMqId) throws Exception {
        log.debug("getting DatNominaTrabajadorMq instance");

        DatNominaTrabajadorMq entity = null;

        try {
            entity = datNominaTrabajadorMqDAO.findById(datNominaTrabajadorMqId);
        } catch (Exception e) {
            log.error("get DatNominaTrabajadorMq failed", e);
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMq");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMq> findPageDatNominaTrabajadorMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatNominaTrabajadorMq> entity = null;

        try {
            entity = datNominaTrabajadorMqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMq Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatNominaTrabajadorMq()
        throws Exception {
        Long entity = null;

        try {
            entity = datNominaTrabajadorMqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMq Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatNominaTrabajadorMq> list = new ArrayList<DatNominaTrabajadorMq>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
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
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
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
            list = datNominaTrabajadorMqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
