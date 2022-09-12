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

import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaOnivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanillaNominaOnivel4;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaOnivel4DTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPlanillaNominaOnivel4Logic")
public class DatPlanillaNominaOnivel4Logic
    implements IDatPlanillaNominaOnivel4Logic {
    private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaOnivel4Logic.class);

    /**
     * DAO injected by Spring that manages DatPlanillaNominaOnivel4 entities
     *
     */
    @Autowired
    private IDatPlanillaNominaOnivel4DAO datPlanillaNominaOnivel4DAO;

    /**
    * Logic injected by Spring that manages DatPlanillaNomina entities
    *
    */
    @Autowired
    IDatPlanillaNominaLogic logicDatPlanillaNomina1;

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

    @Transactional(readOnly = true)
    public List<DatPlanillaNominaOnivel4> getDatPlanillaNominaOnivel4()
        throws Exception {
        log.debug("finding all DatPlanillaNominaOnivel4 instances");

        List<DatPlanillaNominaOnivel4> list = new ArrayList<DatPlanillaNominaOnivel4>();

        try {
            list = datPlanillaNominaOnivel4DAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPlanillaNominaOnivel4 failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPlanillaNominaOnivel4");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception {
        log.debug("saving DatPlanillaNominaOnivel4 instance");

        try {
            if (entity.getDatPlanillaNomina() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanillaNomina");
            }

            if (entity.getNivel2() == null) {
                throw new ZMessManager().new ForeignException("nivel2");
            }

            if (entity.getNivel4() == null) {
                throw new ZMessManager().new ForeignException("nivel4");
            }

            if (entity.getDatPlanillaNomina().getPlanillaNominaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "planillaNominaId_DatPlanillaNomina");
            }

            if (entity.getNivel2().getNivel2Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel2Id_Nivel2");
            }

            if (entity.getNivel4().getNivel4Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel4Id_Nivel4");
            }

            if (getDatPlanillaNominaOnivel4(
                        entity.getDetPlanillaNominaOnivel4Id()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datPlanillaNominaOnivel4DAO.save(entity);

            log.debug("save DatPlanillaNominaOnivel4 successful");
        } catch (Exception e) {
            log.error("save DatPlanillaNominaOnivel4 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception {
        log.debug("deleting DatPlanillaNominaOnivel4 instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPlanillaNominaOnivel4");
        }

        if (entity.getDetPlanillaNominaOnivel4Id() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "detPlanillaNominaOnivel4Id");
        }

        try {
            datPlanillaNominaOnivel4DAO.delete(entity);

            log.debug("delete DatPlanillaNominaOnivel4 successful");
        } catch (Exception e) {
            log.error("delete DatPlanillaNominaOnivel4 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception {
        log.debug("updating DatPlanillaNominaOnivel4 instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPlanillaNominaOnivel4");
            }

            if (entity.getDatPlanillaNomina() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanillaNomina");
            }

            if (entity.getNivel2() == null) {
                throw new ZMessManager().new ForeignException("nivel2");
            }

            if (entity.getNivel4() == null) {
                throw new ZMessManager().new ForeignException("nivel4");
            }

            if (entity.getDatPlanillaNomina().getPlanillaNominaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "planillaNominaId_DatPlanillaNomina");
            }

            if (entity.getNivel2().getNivel2Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel2Id_Nivel2");
            }

            if (entity.getNivel4().getNivel4Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel4Id_Nivel4");
            }

            datPlanillaNominaOnivel4DAO.update(entity);

            log.debug("update DatPlanillaNominaOnivel4 successful");
        } catch (Exception e) {
            log.error("update DatPlanillaNominaOnivel4 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4()
        throws Exception {
        try {
            List<DatPlanillaNominaOnivel4> datPlanillaNominaOnivel4 = datPlanillaNominaOnivel4DAO.findAll();

            List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4DTO = new ArrayList<DatPlanillaNominaOnivel4DTO>();

            for (DatPlanillaNominaOnivel4 datPlanillaNominaOnivel4Tmp : datPlanillaNominaOnivel4) {
                DatPlanillaNominaOnivel4DTO datPlanillaNominaOnivel4DTO2 = new DatPlanillaNominaOnivel4DTO();

                datPlanillaNominaOnivel4DTO2.setDetPlanillaNominaOnivel4Id(datPlanillaNominaOnivel4Tmp.getDetPlanillaNominaOnivel4Id());
                datPlanillaNominaOnivel4DTO2.setPlanillaNominaId_DatPlanillaNomina((datPlanillaNominaOnivel4Tmp.getDatPlanillaNomina()
                                                                                                               .getPlanillaNominaId() != null)
                    ? datPlanillaNominaOnivel4Tmp.getDatPlanillaNomina()
                                                 .getPlanillaNominaId() : null);

                if (datPlanillaNominaOnivel4Tmp.getNivel2() != null) {
                    datPlanillaNominaOnivel4DTO2.setNivel2Id_Nivel2(datPlanillaNominaOnivel4Tmp.getNivel2()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setNivel2Id_Nivel2(null);
                }

                if (datPlanillaNominaOnivel4Tmp.getNivel2() != null) {
                    datPlanillaNominaOnivel4DTO2.setCodNivel2(datPlanillaNominaOnivel4Tmp.getNivel2().getCodigo()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setCodNivel2(null);
                }

                
                if (datPlanillaNominaOnivel4Tmp.getNivel4() != null) {
                    datPlanillaNominaOnivel4DTO2.setCodNivel4(datPlanillaNominaOnivel4Tmp.getNivel4().getCodigo()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setCodNivel4(null);
                }

                datPlanillaNominaOnivel4DTO.add(datPlanillaNominaOnivel4DTO2);
            }

            return datPlanillaNominaOnivel4DTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPlanillaNominaOnivel4 getDatPlanillaNominaOnivel4(
        Long detPlanillaNominaOnivel4Id) throws Exception {
        log.debug("getting DatPlanillaNominaOnivel4 instance");

        DatPlanillaNominaOnivel4 entity = null;

        try {
            entity = datPlanillaNominaOnivel4DAO.findById(detPlanillaNominaOnivel4Id);
        } catch (Exception e) {
            log.error("get DatPlanillaNominaOnivel4 failed", e);
            throw new ZMessManager().new FindingException(
                "DatPlanillaNominaOnivel4");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPlanillaNominaOnivel4> findPageDatPlanillaNominaOnivel4(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPlanillaNominaOnivel4> entity = null;

        try {
            entity = datPlanillaNominaOnivel4DAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanillaNominaOnivel4 Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPlanillaNominaOnivel4()
        throws Exception {
        Long entity = null;

        try {
            entity = datPlanillaNominaOnivel4DAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanillaNominaOnivel4 Count");
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
    public List<DatPlanillaNominaOnivel4> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPlanillaNominaOnivel4> list = new ArrayList<DatPlanillaNominaOnivel4>();
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
            list = datPlanillaNominaOnivel4DAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4ByNomina(Long planillaNominaId)
        throws Exception {
        try {

            List<DatPlanillaNominaOnivel4> datPlanillaNominaOnivel4 
   		 = datPlanillaNominaOnivel4DAO
			.findByCriteria("datPlanillaNomina.planillaNominaId= "
					+ planillaNominaId);
            
            List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4DTO = new ArrayList<DatPlanillaNominaOnivel4DTO>();

            for (DatPlanillaNominaOnivel4 datPlanillaNominaOnivel4Tmp : datPlanillaNominaOnivel4) {
                DatPlanillaNominaOnivel4DTO datPlanillaNominaOnivel4DTO2 = new DatPlanillaNominaOnivel4DTO();

                datPlanillaNominaOnivel4DTO2.setDetPlanillaNominaOnivel4Id(datPlanillaNominaOnivel4Tmp.getDetPlanillaNominaOnivel4Id());
                datPlanillaNominaOnivel4DTO2.setPlanillaNominaId_DatPlanillaNomina((datPlanillaNominaOnivel4Tmp.getDatPlanillaNomina()
                                                                                                               .getPlanillaNominaId() != null)
                    ? datPlanillaNominaOnivel4Tmp.getDatPlanillaNomina()
                                                 .getPlanillaNominaId() : null);

                if (datPlanillaNominaOnivel4Tmp.getNivel2() != null) {
                    datPlanillaNominaOnivel4DTO2.setNivel2Id_Nivel2(datPlanillaNominaOnivel4Tmp.getNivel2()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setNivel2Id_Nivel2(null);
                }

                if (datPlanillaNominaOnivel4Tmp.getNivel2() != null) {
                    datPlanillaNominaOnivel4DTO2.setCodNivel2(datPlanillaNominaOnivel4Tmp.getNivel2().getNombre()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setCodNivel2(null);
                }

                if (datPlanillaNominaOnivel4Tmp.getNivel4() != null) {
                    datPlanillaNominaOnivel4DTO2.setNivel4Id_Nivel4(datPlanillaNominaOnivel4Tmp.getNivel4()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setNivel4Id_Nivel4(null);
                }


                
                if (datPlanillaNominaOnivel4Tmp.getNivel4() != null) {
                    datPlanillaNominaOnivel4DTO2.setCodNivel4(datPlanillaNominaOnivel4Tmp.getNivel4().getNombre()
                                                                                               );
                } else {
                    datPlanillaNominaOnivel4DTO2.setCodNivel4(null);
                }
                datPlanillaNominaOnivel4DTO2.setAreaNeta(datPlanillaNominaOnivel4Tmp.getAreaNeta());
                
                datPlanillaNominaOnivel4DTO.add(datPlanillaNominaOnivel4DTO2);
            }

            return datPlanillaNominaOnivel4DTO;
        } catch (Exception e) {
            throw e;
        }
    }

}
