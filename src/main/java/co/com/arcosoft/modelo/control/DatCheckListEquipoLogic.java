package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDetDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatCheckListEquipoLogic")
public class DatCheckListEquipoLogic implements IDatCheckListEquipoLogic {
    private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoLogic.class);

    /**
     * DAO injected by Spring that manages DatCheckListEquipo entities
     *
     */
    @Autowired
    private IDatCheckListEquipoDAO datCheckListEquipoDAO;

    /**
    * DAO injected by Spring that manages DatCheckListEquipoDet entities
    *
    */
    @Autowired
    private IDatCheckListEquipoDetDAO datCheckListEquipoDetDAO;
    
    @Autowired
    private IDatCheckListEquipoLaborDAO datCheckListEquipoLaborDAO;

    /**
    * Logic injected by Spring that manages PlanRevisionEquipo entities
    *
    */
    @Autowired
    IPlanRevisionEquipoLogic logicPlanRevisionEquipo1;
    
    @Autowired
    IEquipoLogic logicEquipo2;
    
    @Autowired
    ISistemasEquipoLogic logicSistemasEquipo3;
    
    @Autowired
    ICompartimientosEquipoLogic logicCompartimientosEquipo4;
    
    @Autowired
    ILaborLogic logicLabor5;
    
    @Autowired
    IDatCheckListEquipoDetLogic logicDatCheckListEquipoDet6;
    
    @Autowired
    IBusinessDelegatorView businessDelegatorView;

    @Transactional(readOnly = true)
    public List<DatCheckListEquipo> getDatCheckListEquipo()
        throws Exception {
        log.debug("finding all DatCheckListEquipo instances");

        List<DatCheckListEquipo> list = new ArrayList<DatCheckListEquipo>();

        try {
            list = datCheckListEquipoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatCheckListEquipo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatCheckListEquipo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatCheckListEquipo(DatCheckListEquipo entity, List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
    		List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet)
        throws Exception {
        log.debug("saving DatCheckListEquipo instance");

        try {
            if (entity.getPlanRevisionEquipo() == null) {
                throw new ZMessManager().new ForeignException(
                    "planRevisionEquipo");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if (entity.getPlanRevisionEquipo().getPlanRevisionEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "planRevisionEquipoId_PlanRevisionEquipo");
            }

            datCheckListEquipoDAO.save(entity);
            
            if (dataDatCheckListEquipoDet != null) {

  				for (DatCheckListEquipoDetDTO valorDto : dataDatCheckListEquipoDet) {

  					DatCheckListEquipoDet valor = new DatCheckListEquipoDet();
  					
  					valor.setEquipo(logicEquipo2.getEquipo(valorDto.getEquipoId_Equipo()));
  					valor.setSistemasEquipo(logicSistemasEquipo3.getSistemasEquipo(valorDto.getSistemasEquipoId_SistemasEquipo()));
  					valor.setCompartimientosEquipo(logicCompartimientosEquipo4.getCompartimientosEquipo(valorDto.getCompartimientosEquipoId_CompartimientosEquipo()));
  					valor.setDiasHoy(valorDto.getDiasHoy());
  					valor.setHorasHoy(valorDto.getHorasHoy());
  					valor.setKmHoy(valorDto.getKmHoy());
  					valor.setDatCheckListEquipo(entity);

  					datCheckListEquipoDetDAO.save(valor);  	  					

  					Long planRevisionEquipoId =  entity.getPlanRevisionEquipo().getPlanRevisionEquipoId();
  					List<PlanRevisionEquipoActiv> data = null;  					
  					Object[] condicion = { "planRevisionEquipo", true, planRevisionEquipoId, "=" };
  					data = businessDelegatorView.findByCriteriaInPlanRevisionEquipoActiv(condicion, null, null);
  								
  					if (data != null && data.size() > 0) {
  						
  						if (dataDatCheckListEquipoLabor == null) {
  							dataDatCheckListEquipoLabor = new ArrayList<DatCheckListEquipoLaborDTO>();
  						}
  						
  						for (PlanRevisionEquipoActiv data2 : data) {
  							
  							DatCheckListEquipoLaborDTO datCheckListEquipoLaborDTO = new DatCheckListEquipoLaborDTO();
  							
  							datCheckListEquipoLaborDTO.setLaborId_Labor(data2.getLabor().getLaborId());
  							
  							Labor labor = businessDelegatorView.getLabor(data2.getLabor().getLaborId());	
  							datCheckListEquipoLaborDTO.setNombreLabor(labor.getNombre());
  							
  							datCheckListEquipoLaborDTO.setResultado("");
  							datCheckListEquipoLaborDTO.setObservacion("");
  							datCheckListEquipoLaborDTO.setDatCheckListEquipoDetId_DatCheckListEquipoDet(
  									valor.getDatCheckListEquipoDetId());
  							
  							dataDatCheckListEquipoLabor.add(datCheckListEquipoLaborDTO);
  						}
  					}  					
  				}
  			}
            
            if (dataDatCheckListEquipoLabor != null) {

  				for (DatCheckListEquipoLaborDTO valorDto : dataDatCheckListEquipoLabor) {

  					DatCheckListEquipoLabor valor = new DatCheckListEquipoLabor();
  					
  					valor.setLabor(logicLabor5.getLabor(valorDto.getLaborId_Labor()));
  					valor.setResultado(valorDto.getResultado());
  					valor.setObservacion(valorDto.getObservacion());
  					valor.setDatCheckListEquipoDet(logicDatCheckListEquipoDet6.getDatCheckListEquipoDet(valorDto.getDatCheckListEquipoDetId_DatCheckListEquipoDet()));

  					datCheckListEquipoLaborDAO.save(valor);  					
  				}
  			}

            log.debug("save DatCheckListEquipo successful");
        } catch (Exception e) {
            log.error("save DatCheckListEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatCheckListEquipo(DatCheckListEquipo entity)
        throws Exception {
        log.debug("deleting DatCheckListEquipo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatCheckListEquipo");
        }

        if (entity.getDatCheckListEquipoId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datCheckListEquipoId");
        }

        List<DatCheckListEquipoDet> datCheckListEquipoDets = null;

        try {
            datCheckListEquipoDets = datCheckListEquipoDetDAO.findByProperty("datCheckListEquipo.datCheckListEquipoId",
                    entity.getDatCheckListEquipoId());

            if (Utilities.validationsList(datCheckListEquipoDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datCheckListEquipoDets");
            }

            datCheckListEquipoDAO.delete(entity);

            log.debug("delete DatCheckListEquipo successful");
        } catch (Exception e) {
            log.error("delete DatCheckListEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatCheckListEquipo(DatCheckListEquipo entity, List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
    		List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet)
        throws Exception {
        log.debug("updating DatCheckListEquipo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatCheckListEquipo");
            }

            if (entity.getPlanRevisionEquipo() == null) {
                throw new ZMessManager().new ForeignException(
                    "planRevisionEquipo");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if (entity.getPlanRevisionEquipo().getPlanRevisionEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "planRevisionEquipoId_PlanRevisionEquipo");
            }

            datCheckListEquipoDAO.update(entity);
            
            if (dataDatCheckListEquipoDet != null) {

  				for (DatCheckListEquipoDetDTO valorDto : dataDatCheckListEquipoDet) {

   					if (valorDto.getDatCheckListEquipoDetId() == null) { 
   						
   						DatCheckListEquipoDet valor = new DatCheckListEquipoDet();
   						
   						valor.setEquipo(logicEquipo2.getEquipo(valorDto.getEquipoId_Equipo()));
   	  					valor.setSistemasEquipo(logicSistemasEquipo3.getSistemasEquipo(valorDto.getSistemasEquipoId_SistemasEquipo()));
   	  					valor.setCompartimientosEquipo(logicCompartimientosEquipo4.getCompartimientosEquipo(valorDto.getCompartimientosEquipoId_CompartimientosEquipo()));
   	  					valor.setDiasHoy(valorDto.getDiasHoy());
   	  					valor.setHorasHoy(valorDto.getHorasHoy());
   	  					valor.setKmHoy(valorDto.getKmHoy());
   	  					valor.setDatCheckListEquipo(entity);

   	  					datCheckListEquipoDetDAO.save(valor);

   					} else {
   						DatCheckListEquipoDet valor = datCheckListEquipoDetDAO.findById(valorDto.getDatCheckListEquipoDetId());
   						
   						valor.setEquipo(logicEquipo2.getEquipo(valorDto.getEquipoId_Equipo()));
   	  					valor.setSistemasEquipo(logicSistemasEquipo3.getSistemasEquipo(valorDto.getSistemasEquipoId_SistemasEquipo()));
   	  					valor.setCompartimientosEquipo(logicCompartimientosEquipo4.getCompartimientosEquipo(valorDto.getCompartimientosEquipoId_CompartimientosEquipo()));
   	  					valor.setDiasHoy(valorDto.getDiasHoy());
   	  					valor.setHorasHoy(valorDto.getHorasHoy());
   	  					valor.setKmHoy(valorDto.getKmHoy());

   	  					datCheckListEquipoDetDAO.update(valor);
   					}
   				}
   			}
            
            if (dataDatCheckListEquipoLabor != null) {

  				for (DatCheckListEquipoLaborDTO valorDto : dataDatCheckListEquipoLabor) {

   					if (valorDto.getDatCheckListEquipoLaborId() == null) { 
   						
   						DatCheckListEquipoLabor valor = new DatCheckListEquipoLabor();
   	  					
   	  					valor.setLabor(logicLabor5.getLabor(valorDto.getLaborId_Labor()));
   	  					valor.setResultado(valorDto.getResultado());
   	  					valor.setObservacion(valorDto.getObservacion());
   	  					valor.setDatCheckListEquipoDet(logicDatCheckListEquipoDet6.getDatCheckListEquipoDet(valorDto.getDatCheckListEquipoDetId_DatCheckListEquipoDet()));

   	  					datCheckListEquipoLaborDAO.save(valor);

   					} else {
   						DatCheckListEquipoLabor valor = datCheckListEquipoLaborDAO.findById(valorDto.getDatCheckListEquipoLaborId());
   	  					
   	  					valor.setLabor(logicLabor5.getLabor(valorDto.getLaborId_Labor()));
   	  					valor.setResultado(valorDto.getResultado());
   	  					valor.setObservacion(valorDto.getObservacion());

   	  					datCheckListEquipoLaborDAO.update(valor);
   					}
   				}
   			}

            log.debug("update DatCheckListEquipo successful");
        } catch (Exception e) {
            log.error("update DatCheckListEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatCheckListEquipoDTO> getDataDatCheckListEquipo()
        throws Exception {
        try {
            List<DatCheckListEquipo> datCheckListEquipo = datCheckListEquipoDAO.findAll();

            List<DatCheckListEquipoDTO> datCheckListEquipoDTO = new ArrayList<DatCheckListEquipoDTO>();

            for (DatCheckListEquipo datCheckListEquipoTmp : datCheckListEquipo) {
                DatCheckListEquipoDTO datCheckListEquipoDTO2 = new DatCheckListEquipoDTO();

                datCheckListEquipoDTO2.setDatCheckListEquipoId(datCheckListEquipoTmp.getDatCheckListEquipoId());
                datCheckListEquipoDTO2.setCompania((datCheckListEquipoTmp.getCompania() != null)
                    ? datCheckListEquipoTmp.getCompania() : null);
                datCheckListEquipoDTO2.setConsecutivo((datCheckListEquipoTmp.getConsecutivo() != null)
                    ? datCheckListEquipoTmp.getConsecutivo() : null);
                datCheckListEquipoDTO2.setEstado((datCheckListEquipoTmp.getEstado() != null)
                    ? datCheckListEquipoTmp.getEstado() : null);
                datCheckListEquipoDTO2.setFechaCreacion(datCheckListEquipoTmp.getFechaCreacion());
                datCheckListEquipoDTO2.setFechaModificacion(datCheckListEquipoTmp.getFechaModificacion());
                datCheckListEquipoDTO2.setObservacion((datCheckListEquipoTmp.getObservacion() != null)
                    ? datCheckListEquipoTmp.getObservacion() : null);
                datCheckListEquipoDTO2.setOrigenDatos((datCheckListEquipoTmp.getOrigenDatos() != null)
                    ? datCheckListEquipoTmp.getOrigenDatos() : null);
                datCheckListEquipoDTO2.setSupervisorId((datCheckListEquipoTmp.getSupervisorId() != null)
                    ? datCheckListEquipoTmp.getSupervisorId() : null);
                datCheckListEquipoDTO2.setUsuarioDigitacion((datCheckListEquipoTmp.getUsuarioDigitacion() != null)
                    ? datCheckListEquipoTmp.getUsuarioDigitacion() : null);
                
                if (datCheckListEquipoTmp.getPlanRevisionEquipo() != null) {
                    datCheckListEquipoDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(datCheckListEquipoTmp.getPlanRevisionEquipo()
                            .getPlanRevisionEquipoId());
                } else {
                    datCheckListEquipoDTO2.setPlanRevisionEquipoId_PlanRevisionEquipo(null);
                }
                
                datCheckListEquipoDTO.add(datCheckListEquipoDTO2);
            }

            return datCheckListEquipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatCheckListEquipo getDatCheckListEquipo(Long datCheckListEquipoId)
        throws Exception {
        log.debug("getting DatCheckListEquipo instance");

        DatCheckListEquipo entity = null;

        try {
            entity = datCheckListEquipoDAO.findById(datCheckListEquipoId);
        } catch (Exception e) {
            log.error("get DatCheckListEquipo failed", e);
            throw new ZMessManager().new FindingException("DatCheckListEquipo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatCheckListEquipo> findPageDatCheckListEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatCheckListEquipo> entity = null;

        try {
            entity = datCheckListEquipoDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCheckListEquipo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatCheckListEquipo() throws Exception {
        Long entity = null;

        try {
            entity = datCheckListEquipoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCheckListEquipo Count");
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
    public List<DatCheckListEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatCheckListEquipo> list = new ArrayList<DatCheckListEquipo>();
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
            list = datCheckListEquipoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
