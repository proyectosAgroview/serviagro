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

import co.com.arcosoft.dataaccess.dao.IDatDiferidosCuotasAgricolasDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatDiferidosCuotasAgricolas;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatDiferidosCuotasAgricolasLogic")
public class DatDiferidosCuotasAgricolasLogic
    implements IDatDiferidosCuotasAgricolasLogic {
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosCuotasAgricolasLogic.class);

    /**
     * DAO injected by Spring that manages DatDiferidosCuotasAgricolas entities
     *
     */
    @Autowired
    private IDatDiferidosCuotasAgricolasDAO datDiferidosCuotasAgricolasDAO;

    /**
    * Logic injected by Spring that manages DatDiferidosAgricola entities
    *
    */
    @Autowired
    IDatDiferidosAgricolaLogic logicDatDiferidosAgricola1;

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasAgricolas> getDatDiferidosCuotasAgricolas()
        throws Exception {
        log.debug("finding all DatDiferidosCuotasAgricolas instances");

        List<DatDiferidosCuotasAgricolas> list = new ArrayList<DatDiferidosCuotasAgricolas>();

        try {
            list = datDiferidosCuotasAgricolasDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatDiferidosCuotasAgricolas failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatDiferidosCuotasAgricolas");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception {
        log.debug("saving DatDiferidosCuotasAgricolas instance");

        try {
            if (entity.getDatDiferidosAgricola() == null) {
                throw new ZMessManager().new ForeignException(
                    "datDiferidosAgricola");
            }

            if ((entity.getValorCuota() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorCuota(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorCuota");
            }

            if (entity.getDatDiferidosAgricola().getDatDiferidosAgricolaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datDiferidosAgricolaId_DatDiferidosAgricola");
            }

            if (getDatDiferidosCuotasAgricolas(
                        entity.getDatDiferidosCuotasAgricolasId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datDiferidosCuotasAgricolasDAO.save(entity);

            log.debug("save DatDiferidosCuotasAgricolas successful");
        } catch (Exception e) {
            log.error("save DatDiferidosCuotasAgricolas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception {
        log.debug("deleting DatDiferidosCuotasAgricolas instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatDiferidosCuotasAgricolas");
        }

        if (entity.getDatDiferidosCuotasAgricolasId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datDiferidosCuotasAgricolasId");
        }

        try {
            datDiferidosCuotasAgricolasDAO.delete(entity);

            log.debug("delete DatDiferidosCuotasAgricolas successful");
        } catch (Exception e) {
            log.error("delete DatDiferidosCuotasAgricolas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception {
        log.debug("updating DatDiferidosCuotasAgricolas instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatDiferidosCuotasAgricolas");
            }

            if (entity.getDatDiferidosAgricola() == null) {
                throw new ZMessManager().new ForeignException(
                    "datDiferidosAgricola");
            }

            if ((entity.getValorCuota() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorCuota(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorCuota");
            }

            if (entity.getDatDiferidosAgricola().getDatDiferidosAgricolaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datDiferidosAgricolaId_DatDiferidosAgricola");
            }

            datDiferidosCuotasAgricolasDAO.update(entity);

            log.debug("update DatDiferidosCuotasAgricolas successful");
        } catch (Exception e) {
            log.error("update DatDiferidosCuotasAgricolas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolas()
        throws Exception {
        try {
            List<DatDiferidosCuotasAgricolas> datDiferidosCuotasAgricolas = datDiferidosCuotasAgricolasDAO.findAll();

            List<DatDiferidosCuotasAgricolasDTO> datDiferidosCuotasAgricolasDTO = new ArrayList<DatDiferidosCuotasAgricolasDTO>();

            for (DatDiferidosCuotasAgricolas datDiferidosCuotasAgricolasTmp : datDiferidosCuotasAgricolas) {
                DatDiferidosCuotasAgricolasDTO datDiferidosCuotasAgricolasDTO2 = new DatDiferidosCuotasAgricolasDTO();

                datDiferidosCuotasAgricolasDTO2.setDatDiferidosCuotasAgricolasId(datDiferidosCuotasAgricolasTmp.getDatDiferidosCuotasAgricolasId());
                datDiferidosCuotasAgricolasDTO2.setAnio((datDiferidosCuotasAgricolasTmp.getAnio() != null)
                    ? datDiferidosCuotasAgricolasTmp.getAnio() : null);
                datDiferidosCuotasAgricolasDTO2.setFecha(datDiferidosCuotasAgricolasTmp.getFecha());
                datDiferidosCuotasAgricolasDTO2.setMes((datDiferidosCuotasAgricolasTmp.getMes() != null)
                    ? datDiferidosCuotasAgricolasTmp.getMes() : null);
                datDiferidosCuotasAgricolasDTO2.setValorCuota((datDiferidosCuotasAgricolasTmp.getValorCuota() != null)
                    ? datDiferidosCuotasAgricolasTmp.getValorCuota() : null);
                datDiferidosCuotasAgricolasDTO2.setDatDiferidosAgricolaId_DatDiferidosAgricola((datDiferidosCuotasAgricolasTmp.getDatDiferidosAgricola()
                                                                                                                              .getDatDiferidosAgricolaId() != null)
                    ? datDiferidosCuotasAgricolasTmp.getDatDiferidosAgricola()
                                                    .getDatDiferidosAgricolaId()
                    : null);
                datDiferidosCuotasAgricolasDTO.add(datDiferidosCuotasAgricolasDTO2);
            }

            return datDiferidosCuotasAgricolasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatDiferidosCuotasAgricolas getDatDiferidosCuotasAgricolas(
        Long datDiferidosCuotasAgricolasId) throws Exception {
        log.debug("getting DatDiferidosCuotasAgricolas instance");

        DatDiferidosCuotasAgricolas entity = null;

        try {
            entity = datDiferidosCuotasAgricolasDAO.findById(datDiferidosCuotasAgricolasId);
        } catch (Exception e) {
            log.error("get DatDiferidosCuotasAgricolas failed", e);
            throw new ZMessManager().new FindingException(
                "DatDiferidosCuotasAgricolas");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasAgricolas> findPageDatDiferidosCuotasAgricolas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatDiferidosCuotasAgricolas> entity = null;

        try {
            entity = datDiferidosCuotasAgricolasDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosCuotasAgricolas Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatDiferidosCuotasAgricolas()
        throws Exception {
        Long entity = null;

        try {
            entity = datDiferidosCuotasAgricolasDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosCuotasAgricolas Count");
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
    public List<DatDiferidosCuotasAgricolas> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        List<DatDiferidosCuotasAgricolas> list = new ArrayList<DatDiferidosCuotasAgricolas>();
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
            list = datDiferidosCuotasAgricolasDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(Long datDiferidosAgricolaId)
        throws Exception {
        try {
            List<DatDiferidosCuotasAgricolas> datDiferidosCuotasAgricolas = datDiferidosCuotasAgricolasDAO.
            		findByCriteria("datDiferidosAgricola.datDiferidosAgricolaId= " + datDiferidosAgricolaId);

            List<DatDiferidosCuotasAgricolasDTO> datDiferidosCuotasAgricolasDTO = new ArrayList<DatDiferidosCuotasAgricolasDTO>();

            for (DatDiferidosCuotasAgricolas datDiferidosCuotasAgricolasTmp : datDiferidosCuotasAgricolas) {
                DatDiferidosCuotasAgricolasDTO datDiferidosCuotasAgricolasDTO2 = new DatDiferidosCuotasAgricolasDTO();

                datDiferidosCuotasAgricolasDTO2.setDatDiferidosCuotasAgricolasId(datDiferidosCuotasAgricolasTmp.getDatDiferidosCuotasAgricolasId());
                datDiferidosCuotasAgricolasDTO2.setAnio((datDiferidosCuotasAgricolasTmp.getAnio() != null)
                    ? datDiferidosCuotasAgricolasTmp.getAnio() : null);
                datDiferidosCuotasAgricolasDTO2.setFecha(datDiferidosCuotasAgricolasTmp.getFecha());
                datDiferidosCuotasAgricolasDTO2.setMes((datDiferidosCuotasAgricolasTmp.getMes() != null)
                    ? datDiferidosCuotasAgricolasTmp.getMes() : null);
                datDiferidosCuotasAgricolasDTO2.setValorCuota((datDiferidosCuotasAgricolasTmp.getValorCuota() != null)
                    ? datDiferidosCuotasAgricolasTmp.getValorCuota() : null);
                datDiferidosCuotasAgricolasDTO2.setDatDiferidosAgricolaId_DatDiferidosAgricola((datDiferidosCuotasAgricolasTmp.getDatDiferidosAgricola()
                                                                                                                              .getDatDiferidosAgricolaId() != null)
                    ? datDiferidosCuotasAgricolasTmp.getDatDiferidosAgricola()
                                                    .getDatDiferidosAgricolaId()
                    : null);
                datDiferidosCuotasAgricolasDTO.add(datDiferidosCuotasAgricolasDTO2);
            }

            return datDiferidosCuotasAgricolasDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
