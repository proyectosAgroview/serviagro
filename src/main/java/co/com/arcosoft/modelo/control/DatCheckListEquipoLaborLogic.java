package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
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
@Service("DatCheckListEquipoLaborLogic")
public class DatCheckListEquipoLaborLogic
    implements IDatCheckListEquipoLaborLogic {
    private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoLaborLogic.class);

    /**
     * DAO injected by Spring that manages DatCheckListEquipoLabor entities
     *
     */
    @Autowired
    private IDatCheckListEquipoLaborDAO datCheckListEquipoLaborDAO;

    /**
    * Logic injected by Spring that manages DatCheckListEquipoDet entities
    *
    */
    @Autowired
    IDatCheckListEquipoDetLogic logicDatCheckListEquipoDet1;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */
    @Autowired
    ILaborLogic logicLabor2;

    @Transactional(readOnly = true)
    public List<DatCheckListEquipoLabor> getDatCheckListEquipoLabor()
        throws Exception {
        log.debug("finding all DatCheckListEquipoLabor instances");

        List<DatCheckListEquipoLabor> list = new ArrayList<DatCheckListEquipoLabor>();

        try {
            list = datCheckListEquipoLaborDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatCheckListEquipoLabor failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatCheckListEquipoLabor");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception {
        log.debug("saving DatCheckListEquipoLabor instance");

        try {
            if (entity.getDatCheckListEquipoDet() == null) {
                throw new ZMessManager().new ForeignException(
                    "datCheckListEquipoDet");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getResultado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getResultado(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "resultado");
            }

            if (entity.getDatCheckListEquipoDet().getDatCheckListEquipoDetId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datCheckListEquipoDetId_DatCheckListEquipoDet");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            datCheckListEquipoLaborDAO.save(entity);

            log.debug("save DatCheckListEquipoLabor successful");
        } catch (Exception e) {
            log.error("save DatCheckListEquipoLabor failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception {
        log.debug("deleting DatCheckListEquipoLabor instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatCheckListEquipoLabor");
        }

        if (entity.getDatCheckListEquipoLaborId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datCheckListEquipoLabor");
        }

        try {
            datCheckListEquipoLaborDAO.delete(entity);

            log.debug("delete DatCheckListEquipoLabor successful");
        } catch (Exception e) {
            log.error("delete DatCheckListEquipoLabor failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception {
        log.debug("updating DatCheckListEquipoLabor instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatCheckListEquipoLabor");
            }

            if (entity.getDatCheckListEquipoDet() == null) {
                throw new ZMessManager().new ForeignException(
                    "datCheckListEquipoDet");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getResultado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getResultado(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "resultado");
            }

            if (entity.getDatCheckListEquipoDet().getDatCheckListEquipoDetId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datCheckListEquipoDetId_DatCheckListEquipoDet");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            datCheckListEquipoLaborDAO.update(entity);

            log.debug("update DatCheckListEquipoLabor successful");
        } catch (Exception e) {
            log.error("update DatCheckListEquipoLabor failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLabor()
        throws Exception {
        try {
            List<DatCheckListEquipoLabor> datCheckListEquipoLabor = datCheckListEquipoLaborDAO.findAll();

            List<DatCheckListEquipoLaborDTO> datCheckListEquipoLaborDTO = new ArrayList<DatCheckListEquipoLaborDTO>();

            for (DatCheckListEquipoLabor datCheckListEquipoLaborTmp : datCheckListEquipoLabor) {
                DatCheckListEquipoLaborDTO datCheckListEquipoLaborDTO2 = new DatCheckListEquipoLaborDTO();

                datCheckListEquipoLaborDTO2.setDatCheckListEquipoLaborId(datCheckListEquipoLaborTmp.getDatCheckListEquipoLaborId());
                datCheckListEquipoLaborDTO2.setObservacion((datCheckListEquipoLaborTmp.getObservacion() != null)
                    ? datCheckListEquipoLaborTmp.getObservacion() : null);
                datCheckListEquipoLaborDTO2.setResultado((datCheckListEquipoLaborTmp.getResultado() != null)
                    ? datCheckListEquipoLaborTmp.getResultado() : null);
                datCheckListEquipoLaborDTO2.setDatCheckListEquipoDetId_DatCheckListEquipoDet((datCheckListEquipoLaborTmp.getDatCheckListEquipoDet()
                                                                                                                        .getDatCheckListEquipoDetId() != null)
                    ? datCheckListEquipoLaborTmp.getDatCheckListEquipoDet()
                                                .getDatCheckListEquipoDetId()
                    : null);

                if (datCheckListEquipoLaborTmp.getLabor() != null) {
                    datCheckListEquipoLaborDTO2.setLaborId_Labor(datCheckListEquipoLaborTmp.getLabor()
                                                                                           .getLaborId());
                } else {
                    datCheckListEquipoLaborDTO2.setLaborId_Labor(null);
                }
                
                if (datCheckListEquipoLaborTmp.getLabor() != null) {
                    datCheckListEquipoLaborDTO2.setNombreLabor(datCheckListEquipoLaborTmp.getLabor().getNombre());
                } else {
                    datCheckListEquipoLaborDTO2.setNombreLabor(null);
                }

                datCheckListEquipoLaborDTO.add(datCheckListEquipoLaborDTO2);
            }

            return datCheckListEquipoLaborDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatCheckListEquipoLabor getDatCheckListEquipoLabor(
        Long datCheckListEquipoLabor) throws Exception {
        log.debug("getting DatCheckListEquipoLabor instance");

        DatCheckListEquipoLabor entity = null;

        try {
            entity = datCheckListEquipoLaborDAO.findById(datCheckListEquipoLabor);
        } catch (Exception e) {
            log.error("get DatCheckListEquipoLabor failed", e);
            throw new ZMessManager().new FindingException(
                "DatCheckListEquipoLabor");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatCheckListEquipoLabor> findPageDatCheckListEquipoLabor(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatCheckListEquipoLabor> entity = null;

        try {
            entity = datCheckListEquipoLaborDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCheckListEquipoLabor Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatCheckListEquipoLabor()
        throws Exception {
        Long entity = null;

        try {
            entity = datCheckListEquipoLaborDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCheckListEquipoLabor Count");
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
    public List<DatCheckListEquipoLabor> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatCheckListEquipoLabor> list = new ArrayList<DatCheckListEquipoLabor>();
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
            list = datCheckListEquipoLaborDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = true)
    public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLaborByEquipo(Long checkListEquipoId)
        throws Exception {
        try {
            List<DatCheckListEquipoLabor> datCheckListEquipoLabor = datCheckListEquipoLaborDAO.findByCriteria("datCheckListEquipoDet.datCheckListEquipoDetId= " + checkListEquipoId);

            List<DatCheckListEquipoLaborDTO> datCheckListEquipoLaborDTO = new ArrayList<DatCheckListEquipoLaborDTO>();

            for (DatCheckListEquipoLabor datCheckListEquipoLaborTmp : datCheckListEquipoLabor) {
                DatCheckListEquipoLaborDTO datCheckListEquipoLaborDTO2 = new DatCheckListEquipoLaborDTO();

                datCheckListEquipoLaborDTO2.setDatCheckListEquipoLaborId(datCheckListEquipoLaborTmp.getDatCheckListEquipoLaborId());
                datCheckListEquipoLaborDTO2.setObservacion((datCheckListEquipoLaborTmp.getObservacion() != null)
                    ? datCheckListEquipoLaborTmp.getObservacion() : null);
                datCheckListEquipoLaborDTO2.setResultado((datCheckListEquipoLaborTmp.getResultado() != null)
                    ? datCheckListEquipoLaborTmp.getResultado() : null);
                datCheckListEquipoLaborDTO2.setDatCheckListEquipoDetId_DatCheckListEquipoDet((datCheckListEquipoLaborTmp.getDatCheckListEquipoDet()
                                                                                                                        .getDatCheckListEquipoDetId() != null)
                    ? datCheckListEquipoLaborTmp.getDatCheckListEquipoDet()
                                                .getDatCheckListEquipoDetId()
                    : null);

                if (datCheckListEquipoLaborTmp.getLabor() != null) {
                    datCheckListEquipoLaborDTO2.setLaborId_Labor(datCheckListEquipoLaborTmp.getLabor()
                                                                                           .getLaborId());
                } else {
                    datCheckListEquipoLaborDTO2.setLaborId_Labor(null);
                }
                
                if (datCheckListEquipoLaborTmp.getLabor() != null) {
                    datCheckListEquipoLaborDTO2.setNombreLabor(datCheckListEquipoLaborTmp.getLabor().getNombre());
                } else {
                    datCheckListEquipoLaborDTO2.setNombreLabor(null);
                }

                datCheckListEquipoLaborDTO.add(datCheckListEquipoLaborDTO2);
            }

            return datCheckListEquipoLaborDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
