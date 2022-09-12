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

import co.com.arcosoft.dataaccess.dao.ILaborAdicionalMoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.LaborAdicionalMo;
import co.com.arcosoft.modelo.dto.LaborAdicionalMoDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("LaborAdicionalMoLogic")
public class LaborAdicionalMoLogic implements ILaborAdicionalMoLogic {
    private static final Logger log = LoggerFactory.getLogger(LaborAdicionalMoLogic.class);

    /**
     * DAO injected by Spring that manages LaborAdicionalMo entities
     *
     */
    @Autowired
    private ILaborAdicionalMoDAO laborAdicionalMoDAO;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */
    @Autowired
    ILaborLogic logicLabor1;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed2;

    @Transactional(readOnly = true)
    public List<LaborAdicionalMo> getLaborAdicionalMo()
        throws Exception {
        log.debug("finding all LaborAdicionalMo instances");

        List<LaborAdicionalMo> list = new ArrayList<LaborAdicionalMo>();

        try {
            list = laborAdicionalMoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all LaborAdicionalMo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "LaborAdicionalMo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception {
        log.debug("saving LaborAdicionalMo instance");

        try {
            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if ((entity.getCantidadAdicionalMo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadAdicionalMo(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadAdicionalMo");
            }

            if (entity.getLaborAdicionalMoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborAdicionalMoId");
            }

            if ((entity.getTarifaAdicionalMo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTarifaAdicionalMo(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tarifaAdicionalMo");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

       
            laborAdicionalMoDAO.save(entity);

            log.debug("save LaborAdicionalMo successful");
        } catch (Exception e) {
            log.error("save LaborAdicionalMo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception {
        log.debug("deleting LaborAdicionalMo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("LaborAdicionalMo");
        }

        if (entity.getLaborAdicionalMoId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "laborAdicionalMoId");
        }

        try {
            laborAdicionalMoDAO.delete(entity);

            log.debug("delete LaborAdicionalMo successful");
        } catch (Exception e) {
            log.error("delete LaborAdicionalMo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception {
        log.debug("updating LaborAdicionalMo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "LaborAdicionalMo");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if ((entity.getCantidadAdicionalMo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadAdicionalMo(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadAdicionalMo");
            }

            if (entity.getLaborAdicionalMoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborAdicionalMoId");
            }

            if ((entity.getTarifaAdicionalMo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTarifaAdicionalMo(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tarifaAdicionalMo");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

            laborAdicionalMoDAO.update(entity);

            log.debug("update LaborAdicionalMo successful");
        } catch (Exception e) {
            log.error("update LaborAdicionalMo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<LaborAdicionalMoDTO> getDataLaborAdicionalMo()
        throws Exception {
        try {
            List<LaborAdicionalMo> laborAdicionalMo = laborAdicionalMoDAO.findAll();

            List<LaborAdicionalMoDTO> laborAdicionalMoDTO = new ArrayList<LaborAdicionalMoDTO>();

            for (LaborAdicionalMo laborAdicionalMoTmp : laborAdicionalMo) {
                LaborAdicionalMoDTO laborAdicionalMoDTO2 = new LaborAdicionalMoDTO();

                laborAdicionalMoDTO2.setLaborAdicionalMoId(laborAdicionalMoTmp.getLaborAdicionalMoId());
                laborAdicionalMoDTO2.setCantidadAdicionalMo((laborAdicionalMoTmp.getCantidadAdicionalMo() != null)
                    ? laborAdicionalMoTmp.getCantidadAdicionalMo() : null);
                laborAdicionalMoDTO2.setFechaFinal(laborAdicionalMoTmp.getFechaFinal());
                laborAdicionalMoDTO2.setFechaInicial(laborAdicionalMoTmp.getFechaInicial());
                laborAdicionalMoDTO2.setTarifaAdicionalMo((laborAdicionalMoTmp.getTarifaAdicionalMo() != null)
                    ? laborAdicionalMoTmp.getTarifaAdicionalMo() : null);

                if (laborAdicionalMoTmp.getLabor() != null) {
                    laborAdicionalMoDTO2.setLaborId_Labor(laborAdicionalMoTmp.getLabor()
                                                                             .getLaborId());
                } else {
                    laborAdicionalMoDTO2.setLaborId_Labor(null);
                }

                laborAdicionalMoDTO2.setUdadMedId_UdadMed((laborAdicionalMoTmp.getUdadMed()
                                                                              .getUdadMedId() != null)
                    ? laborAdicionalMoTmp.getUdadMed().getUdadMedId() : null);
                laborAdicionalMoDTO.add(laborAdicionalMoDTO2);
            }

            return laborAdicionalMoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public LaborAdicionalMo getLaborAdicionalMo(Long laborAdicionalMoId)
        throws Exception {
        log.debug("getting LaborAdicionalMo instance");

        LaborAdicionalMo entity = null;

        try {
            entity = laborAdicionalMoDAO.findById(laborAdicionalMoId);
        } catch (Exception e) {
            log.error("get LaborAdicionalMo failed", e);
            throw new ZMessManager().new FindingException("LaborAdicionalMo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<LaborAdicionalMo> findPageLaborAdicionalMo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<LaborAdicionalMo> entity = null;

        try {
            entity = laborAdicionalMoDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "LaborAdicionalMo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberLaborAdicionalMo() throws Exception {
        Long entity = null;

        try {
            entity = laborAdicionalMoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "LaborAdicionalMo Count");
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
    public List<LaborAdicionalMo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<LaborAdicionalMo> list = new ArrayList<LaborAdicionalMo>();
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
            list = laborAdicionalMoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
