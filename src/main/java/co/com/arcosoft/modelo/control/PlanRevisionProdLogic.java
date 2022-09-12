package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;
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
@Service("PlanRevisionProdLogic")
public class PlanRevisionProdLogic implements IPlanRevisionProdLogic {
    private static final Logger log = LoggerFactory.getLogger(PlanRevisionProdLogic.class);

    /**
     * DAO injected by Spring that manages PlanRevisionProd entities
     *
     */
    @Autowired
    private IPlanRevisionProdDAO planRevisionProdDAO;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto1;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed2;

    @Transactional(readOnly = true)
    public List<PlanRevisionProd> getPlanRevisionProd()
        throws Exception {
        log.debug("finding all PlanRevisionProd instances");

        List<PlanRevisionProd> list = new ArrayList<PlanRevisionProd>();

        try {
            list = planRevisionProdDAO.findAll();
        } catch (Exception e) {
            log.error("finding all PlanRevisionProd failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "PlanRevisionProd");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePlanRevisionProd(PlanRevisionProd entity)
        throws Exception {
        log.debug("saving PlanRevisionProd instance");

        try {
            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if (entity.getCantidad() == null) {
                throw new ZMessManager().new EmptyFieldException("cantidad");
            }

            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

            planRevisionProdDAO.save(entity);

            log.debug("save PlanRevisionProd successful");
        } catch (Exception e) {
            log.error("save PlanRevisionProd failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePlanRevisionProd(PlanRevisionProd entity)
        throws Exception {
        log.debug("deleting PlanRevisionProd instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("PlanRevisionProd");
        }

        if (entity.getPlanRevisionProdId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "planRevisionProdId");
        }

        try {
            planRevisionProdDAO.delete(entity);

            log.debug("delete PlanRevisionProd successful");
        } catch (Exception e) {
            log.error("delete PlanRevisionProd failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePlanRevisionProd(PlanRevisionProd entity)
        throws Exception {
        log.debug("updating PlanRevisionProd instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "PlanRevisionProd");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if (entity.getCantidad() == null) {
                throw new ZMessManager().new EmptyFieldException("cantidad");
            }

            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

            planRevisionProdDAO.update(entity);

            log.debug("update PlanRevisionProd successful");
        } catch (Exception e) {
            log.error("update PlanRevisionProd failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PlanRevisionProdDTO> getDataPlanRevisionProd()
        throws Exception {
        try {
            List<PlanRevisionProd> planRevisionProd = planRevisionProdDAO.findAll();

            List<PlanRevisionProdDTO> planRevisionProdDTO = new ArrayList<PlanRevisionProdDTO>();

            for (PlanRevisionProd planRevisionProdTmp : planRevisionProd) {
                PlanRevisionProdDTO planRevisionProdDTO2 = new PlanRevisionProdDTO();

                planRevisionProdDTO2.setPlanRevisionProdId(planRevisionProdTmp.getPlanRevisionProdId());
                planRevisionProdDTO2.setCantidad((planRevisionProdTmp.getCantidad() != null)
                    ? planRevisionProdTmp.getCantidad() : null);
                planRevisionProdDTO2.setPlanRevisionEquipoId((planRevisionProdTmp.getPlanRevisionEquipoId().getPlanRevisionEquipoId() != null)
                    ? planRevisionProdTmp.getPlanRevisionEquipoId().getPlanRevisionEquipoId() : null);
                
                planRevisionProdDTO2.setProductoId_Producto((planRevisionProdTmp.getProducto() != null)
                    ? planRevisionProdTmp.getProducto() : null);
                
                planRevisionProdDTO2.setUdadMedId_UdadMed((planRevisionProdTmp.getUdadMed() != null)
                    ? planRevisionProdTmp.getUdadMed() : null);
                
                if (planRevisionProdTmp.getProducto() != null) {
                	planRevisionProdDTO2.setNombreProducto(planRevisionProdTmp.getProducto().getNombre());
				} else {
					planRevisionProdDTO2.setNombreProducto(null);
				}
                
                if (planRevisionProdTmp.getUdadMed() != null) {
                	planRevisionProdDTO2.setNombreUdadMed(planRevisionProdTmp.getUdadMed().getNombre());
				} else {
					planRevisionProdDTO2.setNombreUdadMed(null);
				}
                
                planRevisionProdDTO.add(planRevisionProdDTO2);
            }

            return planRevisionProdDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PlanRevisionProd getPlanRevisionProd(Long planRevisionProdId)
        throws Exception {
        log.debug("getting PlanRevisionProd instance");

        PlanRevisionProd entity = null;

        try {
            entity = planRevisionProdDAO.findById(planRevisionProdId);
        } catch (Exception e) {
            log.error("get PlanRevisionProd failed", e);
            throw new ZMessManager().new FindingException("PlanRevisionProd");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<PlanRevisionProd> findPagePlanRevisionProd(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<PlanRevisionProd> entity = null;

        try {
            entity = planRevisionProdDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PlanRevisionProd Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPlanRevisionProd() throws Exception {
        Long entity = null;

        try {
            entity = planRevisionProdDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PlanRevisionProd Count");
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
    public List<PlanRevisionProd> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<PlanRevisionProd> list = new ArrayList<PlanRevisionProd>();
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
            list = planRevisionProdDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<PlanRevisionProdDTO> getDataPlanRevisionProdByPlanRevision(Long planRecursoId)
        throws Exception {
        try {
            List<PlanRevisionProd> planRevisionProd = planRevisionProdDAO.findByCriteria("planRevisionEquipoId.planRevisionEquipoId= " + planRecursoId);

            List<PlanRevisionProdDTO> planRevisionProdDTO = new ArrayList<PlanRevisionProdDTO>();

            for (PlanRevisionProd planRevisionProdTmp : planRevisionProd) {
                PlanRevisionProdDTO planRevisionProdDTO2 = new PlanRevisionProdDTO();

                planRevisionProdDTO2.setPlanRevisionProdId(planRevisionProdTmp.getPlanRevisionProdId());
                planRevisionProdDTO2.setCantidad((planRevisionProdTmp.getCantidad() != null)
                    ? planRevisionProdTmp.getCantidad() : null);
                planRevisionProdDTO2.setPlanRevisionEquipoId((planRevisionProdTmp.getPlanRevisionEquipoId().getPlanRevisionEquipoId() != null)
                    ? planRevisionProdTmp.getPlanRevisionEquipoId().getPlanRevisionEquipoId() : null);
                
                planRevisionProdDTO2.setProductoId_Producto((planRevisionProdTmp.getProducto() != null)
                    ? planRevisionProdTmp.getProducto() : null);
                
                planRevisionProdDTO2.setUdadMedId_UdadMed((planRevisionProdTmp.getUdadMed() != null)
                    ? planRevisionProdTmp.getUdadMed() : null);
                
                if (planRevisionProdTmp.getProducto() != null) {
                	planRevisionProdDTO2.setNombreProducto(planRevisionProdTmp.getProducto().getNombre());
				} else {
					planRevisionProdDTO2.setNombreProducto(null);
				}
                
                if (planRevisionProdTmp.getProducto() != null) {
                	planRevisionProdDTO2.setCodProducto(planRevisionProdTmp.getProducto().getCodigo());
				} else {
					planRevisionProdDTO2.setCodProducto(null);
				}
                
                if (planRevisionProdTmp.getUdadMed() != null) {
                	planRevisionProdDTO2.setNombreUdadMed(planRevisionProdTmp.getUdadMed().getNombre());
				} else {
					planRevisionProdDTO2.setNombreUdadMed(null);
				}
                
                planRevisionProdDTO.add(planRevisionProdDTO2);
            }

            return planRevisionProdDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
