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

import co.com.arcosoft.dataaccess.dao.IDatPlanServiciosMqdetEjecDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanServiciosMqdetEjec;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetEjecDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPlanServiciosMqdetEjecLogic")
public class DatPlanServiciosMqdetEjecLogic
    implements IDatPlanServiciosMqdetEjecLogic {
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqdetEjecLogic.class);

    /**
     * DAO injected by Spring that manages DatPlanServiciosMqdetEjec entities
     *
     */
    @Autowired
    private IDatPlanServiciosMqdetEjecDAO datPlanServiciosMqdetEjecDAO;

    /**
    * Logic injected by Spring that manages DatPlanServiciosMqdet entities
    *
    */
    @Autowired
    IDatPlanServiciosMqdetLogic logicDatPlanServiciosMqdet1;

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo2;

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdetEjec> getDatPlanServiciosMqdetEjec()
        throws Exception {
        log.debug("finding all DatPlanServiciosMqdetEjec instances");

        List<DatPlanServiciosMqdetEjec> list = new ArrayList<DatPlanServiciosMqdetEjec>();

        try {
            list = datPlanServiciosMqdetEjecDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPlanServiciosMqdetEjec failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPlanServiciosMqdetEjec");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity)
        throws Exception {
        log.debug("saving DatPlanServiciosMqdetEjec instance");

        try {
            if (entity.getDatPlanServiciosMqdet() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanServiciosMqdet");
            }

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }

            if ((entity.getCantidadRealizada() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadRealizada(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadRealizada");
            }

            

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

           

            datPlanServiciosMqdetEjecDAO.save(entity);

            log.debug("save DatPlanServiciosMqdetEjec successful");
        } catch (Exception e) {
            log.error("save DatPlanServiciosMqdetEjec failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPlanServiciosMqdetEjec(
        DatPlanServiciosMqdetEjec entity) throws Exception {
        log.debug("deleting DatPlanServiciosMqdetEjec instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPlanServiciosMqdetEjec");
        }

        if (entity.getDatPlanServiciosMqdetEjecId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datPlanServiciosMqdetEjecId");
        }

        try {
            datPlanServiciosMqdetEjecDAO.delete(entity);

            log.debug("delete DatPlanServiciosMqdetEjec successful");
        } catch (Exception e) {
            log.error("delete DatPlanServiciosMqdetEjec failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPlanServiciosMqdetEjec(
        DatPlanServiciosMqdetEjec entity) throws Exception {
        log.debug("updating DatPlanServiciosMqdetEjec instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPlanServiciosMqdetEjec");
            }

            if (entity.getDatPlanServiciosMqdet() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanServiciosMqdet");
            }

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }

            if ((entity.getCantidadRealizada() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadRealizada(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadRealizada");
            }

            if (entity.getDatPlanServiciosMqdet().getDatPlanServiciosMqdetId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datPlanServiciosMqdetId_DatPlanServiciosMqdet");
            }

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

            datPlanServiciosMqdetEjecDAO.update(entity);

            log.debug("update DatPlanServiciosMqdetEjec successful");
        } catch (Exception e) {
            log.error("update DatPlanServiciosMqdetEjec failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdetEjecDTO> getDataDatPlanServiciosMqdetEjec()
        throws Exception {
        try {
            List<DatPlanServiciosMqdetEjec> datPlanServiciosMqdetEjec = datPlanServiciosMqdetEjecDAO.findAll();

            List<DatPlanServiciosMqdetEjecDTO> datPlanServiciosMqdetEjecDTO = new ArrayList<DatPlanServiciosMqdetEjecDTO>();

            for (DatPlanServiciosMqdetEjec datPlanServiciosMqdetEjecTmp : datPlanServiciosMqdetEjec) {
                DatPlanServiciosMqdetEjecDTO datPlanServiciosMqdetEjecDTO2 = new DatPlanServiciosMqdetEjecDTO();

                datPlanServiciosMqdetEjecDTO2.setDatPlanServiciosMqdetEjecId(datPlanServiciosMqdetEjecTmp.getDatPlanServiciosMqdetEjecId());
                datPlanServiciosMqdetEjecDTO2.setCantidadRealizada((datPlanServiciosMqdetEjecTmp.getCantidadRealizada() != null)
                    ? datPlanServiciosMqdetEjecTmp.getCantidadRealizada() : null);
                datPlanServiciosMqdetEjecDTO2.setFechaRegistro(datPlanServiciosMqdetEjecTmp.getFechaRegistro());
                datPlanServiciosMqdetEjecDTO2.setDatPlanServiciosMqdetId_DatPlanServiciosMqdet((datPlanServiciosMqdetEjecTmp.getDatPlanServiciosMqdet()
                                                                                                                            .getDatPlanServiciosMqdetId() != null)
                    ? datPlanServiciosMqdetEjecTmp.getDatPlanServiciosMqdet()
                                                  .getDatPlanServiciosMqdetId()
                    : null);

                if (datPlanServiciosMqdetEjecTmp.getEquipo() != null) {
                    datPlanServiciosMqdetEjecDTO2.setEquipoId_Equipo(datPlanServiciosMqdetEjecTmp.getEquipo()
                                                                                                 .getEquipoId());
                } else {
                    datPlanServiciosMqdetEjecDTO2.setEquipoId_Equipo(null);
                }

                
                if (datPlanServiciosMqdetEjecTmp.getOperario() != null) {
                    datPlanServiciosMqdetEjecDTO2.setOperarioId(datPlanServiciosMqdetEjecTmp.getOperario()
                                                                                                 .getTrabId());
                } else {
                    datPlanServiciosMqdetEjecDTO2.setOperarioId(null);
                }
                
                datPlanServiciosMqdetEjecDTO.add(datPlanServiciosMqdetEjecDTO2);
            }

            return datPlanServiciosMqdetEjecDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPlanServiciosMqdetEjec getDatPlanServiciosMqdetEjec(
        Long datPlanServiciosMqdetEjecId) throws Exception {
        log.debug("getting DatPlanServiciosMqdetEjec instance");

        DatPlanServiciosMqdetEjec entity = null;

        try {
            entity = datPlanServiciosMqdetEjecDAO.findById(datPlanServiciosMqdetEjecId);
        } catch (Exception e) {
            log.error("get DatPlanServiciosMqdetEjec failed", e);
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdetEjec");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdetEjec> findPageDatPlanServiciosMqdetEjec(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPlanServiciosMqdetEjec> entity = null;

        try {
            entity = datPlanServiciosMqdetEjecDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdetEjec Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPlanServiciosMqdetEjec()
        throws Exception {
        Long entity = null;

        try {
            entity = datPlanServiciosMqdetEjecDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdetEjec Count");
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
    public List<DatPlanServiciosMqdetEjec> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPlanServiciosMqdetEjec> list = new ArrayList<DatPlanServiciosMqdetEjec>();
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
            list = datPlanServiciosMqdetEjecDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
